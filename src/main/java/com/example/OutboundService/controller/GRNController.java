package com.example.OutboundService.controller;

import com.example.OutboundService.dto.GRNRequestDTO;
import com.example.OutboundService.entity.GRNRequest;
import com.example.OutboundService.service.GRNService;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GRNController {

    private final GRNService grnService;

    public GRNController(GRNService grnService) {
        this.grnService = grnService;
    }

    @PostMapping("/generate-grn")
    public ResponseEntity<GRNRequest> generateGRN(
            @RequestBody GRNRequestDTO request) throws IOException {

        GRNRequest grn =
                grnService.generateGRN(request);

        return ResponseEntity.ok(grn);
    }
}