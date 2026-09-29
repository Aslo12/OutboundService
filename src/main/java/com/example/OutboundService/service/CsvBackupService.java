package com.example.OutboundService.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class CsvBackupService {

    private final Path archiveFolder =
            Path.of("C:\\Archieve\\Outbound");

    public Path backupCsv(Path csvFile)
            throws IOException {

        // Create archive folder if it does not exist
        Files.createDirectories(archiveFolder);

        // Same filename in archive folder
        Path backupFile =
                archiveFolder.resolve(csvFile.getFileName());

        // Copy CSV to archive
        Files.copy(
                csvFile,
                backupFile,
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println(
                "CSV backup created: "
                        + backupFile.toAbsolutePath()
        );

        return backupFile;
    }
}	