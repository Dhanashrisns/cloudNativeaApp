package com.cloudnative.movie.jpa.entity;

import javax.persistence.*;

@Entity(name="wishlist")
public class WishList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private  String userId;

  @ManyToOne(cascade = CascadeType.ALL)
  private MovieDetails movieDetails;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public WishList() {
  }



  public WishList(String userId, String movieId) {
    this.userId = userId;
  }


  public String getUserId() {
    return userId;
  }



  public void setUserId(String userId) {
    this.userId = userId;
  }

  public MovieDetails getMovieDetails() {
    return movieDetails;
  }

  public void setMovieDetails(MovieDetails movieDetails) {
    this.movieDetails = movieDetails;
  }

}