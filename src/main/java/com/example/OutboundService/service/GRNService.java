package com.example.OutboundService.service;

import com.example.OutboundService.dto.GRNRequestDTO;
import com.example.OutboundService.entity.GRNRequest;
import com.example.OutboundService.repository.GRNRequestRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class GRNService {

    private final GRNRequestRepository grnRequestRepository;
    private final CsvGeneratorService csvGeneratorService;
    private final CsvBackupService csvBackupService;

    public GRNService(GRNRequestRepository grnRequestRepository, CsvGeneratorService csvGeneratorService, CsvBackupService csvBackupService) {
        this.grnRequestRepository = grnRequestRepository;
		this.csvGeneratorService = csvGeneratorService;
		this.csvBackupService = csvBackupService;
    }

    @Transactional
    public GRNRequest generateGRN(GRNRequestDTO request) throws IOException {

        // 1. Create GRN number
        String grnNumber = "GRN" +
                UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 8)
                        .toUpperCase();

        // 2. Create Entity object
        GRNRequest grnRequest = new GRNRequest();

        grnRequest.setGrnNumber(grnNumber);
        grnRequest.setMaterialCode(request.getMaterialCode());
        grnRequest.setMaterialDescription(
                request.getMaterialDescription()
        );
        grnRequest.setVendorName(request.getVendorName());
        grnRequest.setVechileNumber(request.getVechileNumber());
        grnRequest.setTotalQty(request.getTotalQty());
        grnRequest.setMaterialQty(request.getMaterialQty());

        // 3. Save into database
        GRNRequest savedGRN =
                grnRequestRepository.save(grnRequest);
        
        Path csvFile =
                csvGeneratorService.createCsv(savedGRN);

        csvBackupService.backupCsv(csvFile);

        return savedGRN;
    }
}