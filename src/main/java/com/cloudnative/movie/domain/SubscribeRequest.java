package com.cloudnative.movie.domain;

public class SubscribeRequest {

  String subscribed;
  String userId;

  public SubscribeRequest(String subscribed, String userId) {
    this.subscribed = subscribed;
    this.userId = userId;
  }

  public String getSubscribed() {
    return subscribed;
  }

  public void setSubscribed(String subscribed) {
    this.subscribed = subscribed;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
