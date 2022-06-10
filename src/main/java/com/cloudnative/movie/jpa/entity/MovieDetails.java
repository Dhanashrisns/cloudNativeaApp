package com.cloudnative.movie.jpa.entity;

import javax.persistence.*;
import java.util.Date;


@Entity(name="Movie_Detail")
public class MovieDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private Date releaseDate;

  private String rating;

  private String language;

  @Lob
  private byte[] data;


  public MovieDetails() {

  }

  public MovieDetails(String title, Date releaseDate, String rating, String language, byte[] data) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.rating = rating;
    this.language = language;
    this.data = data;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}
