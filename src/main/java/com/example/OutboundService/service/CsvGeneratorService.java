package com.example.OutboundService.service;

import com.example.OutboundService.entity.GRNRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CsvGeneratorService {

    private final Path outboundFolder =
            Path.of("C:\\Outbound_Processing");

    public Path createCsv(GRNRequest grnRequest)
            throws IOException {

        // Create folder if it does not exist
        Files.createDirectories(outboundFolder);

        // Create filename: DDMMYYYY_GRNSTRUP_HHMMSS.csv
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

        String dateTime =
                LocalDateTime.now().format(formatter);

        String fileName =
                dateTime.substring(0, 8)
                + "_GRNSTRUP_"
                + dateTime.substring(9)
                + ".csv";

        Path csvFile =
                outboundFolder.resolve(fileName);

        // CSV header
        StringBuilder csvContent =
                new StringBuilder();

        csvContent.append(
                "GrnNumber,MaterialCode,MaterialDescription,"
                + "VendorName,VechileNumber,TotalQty,MaterialQty"
        ).append(System.lineSeparator());

        // CSV data
        csvContent.append(grnRequest.getGrnNumber())
                .append(",")
                .append(grnRequest.getMaterialCode())
                .append(",")
                .append(grnRequest.getMaterialDescription())
                .append(",")
                .append(grnRequest.getVendorName())
                .append(",")
                .append(grnRequest.getVechileNumber())
                .append(",")
                .append(grnRequest.getTotalQty())
                .append(",")
                .append(grnRequest.getMaterialQty())
                .append(System.lineSeparator());

        Files.writeString(
                csvFile,
                csvContent.toString()
        );

        System.out.println(
                "Outbound CSV created: "
                        + csvFile.toAbsolutePath()
        );

        return csvFile;
    }
}