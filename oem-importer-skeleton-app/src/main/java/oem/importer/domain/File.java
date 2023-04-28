package oem.importer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class File {
    private final String fileType;

    public File(@JsonProperty("fileType") String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
