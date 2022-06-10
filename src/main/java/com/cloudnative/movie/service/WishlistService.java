package com.cloudnative.movie.service;

import com.cloudnative.movie.jpa.entity.MovieDetails;
import com.cloudnative.movie.jpa.entity.WishList;
import com.cloudnative.movie.jpa.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

  @Autowired
  public WishlistRepository wishlistRepository;

  public void createWishlist(WishList wishList) {
    wishlistRepository.saveAndFlush(wishList);
  }

  public List<WishList> readWishList(String userId) {
    return wishlistRepository.findAllByUserId(userId);
  }

  public MovieDetails createMovieListResponse(WishList wishList) {
     MovieDetails movieDetails = new MovieDetails();
     movieDetails.setId(wishList.getMovieDetails().getId());
     movieDetails.setReleaseDate(wishList.getMovieDetails().getReleaseDate());
     movieDetails.setLanguage(wishList.getMovieDetails().getLanguage());
     movieDetails.setRating(wishList.getMovieDetails().getRating());
     movieDetails.setTitle(wishList.getMovieDetails().getTitle());
     movieDetails.setData(wishList.getMovieDetails().getData());

    return movieDetails;
  }

}
