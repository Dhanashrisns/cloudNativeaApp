package com.cloudnative.movie.domain;

public class UploadFileResponse {
  private String fileDownloadUri;

  public UploadFileResponse(String fileDownloadUri) {
    this.fileDownloadUri = fileDownloadUri;

  }



  public String getFileDownloadUri() {
    return fileDownloadUri;
  }

  public void setFileDownloadUri(String fileDownloadUri) {
    this.fileDownloadUri = fileDownloadUri;
  }


}
