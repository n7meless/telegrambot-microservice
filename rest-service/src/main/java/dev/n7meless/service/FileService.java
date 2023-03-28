package dev.n7meless.service;

import dev.n7meless.entity.AppDocument;
import dev.n7meless.entity.AppPhoto;
import dev.n7meless.entity.BinaryContent;
import org.springframework.core.io.FileSystemResource;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
