package com.cloudnative.movie.jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="User_Detail")
public class User {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String email;

  private String name;

  private String password;

  private String subscribed;


  public User(){

  }

  public User(String id, String email, String name, String password, String subscribed) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.password = password;
    this.subscribed = subscribed;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSubscribed() {
    return subscribed;
  }

  public void setSubscribed(String subscribed) {
    this.subscribed = subscribed;
  }
}
