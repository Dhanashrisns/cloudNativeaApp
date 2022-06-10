package com.cloudnative.movie.domain;

public class RegistrationResponse {
  String message;
  String username;

  public RegistrationResponse(){

  }

  public RegistrationResponse(String message, String username) {
    this.message = message;
    this.username = username;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
