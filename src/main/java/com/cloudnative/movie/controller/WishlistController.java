package com.cloudnative.movie.controller;

import com.cloudnative.movie.domain.WishListRequest;
import com.cloudnative.movie.jpa.entity.MovieDetails;
import com.cloudnative.movie.jpa.entity.WishList;
import com.cloudnative.movie.jpa.repository.MovieDetailRepository;
import com.cloudnative.movie.jpa.repository.WishlistRepository;
import com.cloudnative.movie.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WishlistController {

  @Autowired
  private WishlistService wishlistService;

  @Autowired
  private WishlistRepository wishlistRepository;


  @Autowired
  private MovieDetailRepository movieDetailRepository;


  @ResponseBody
  @RequestMapping(value = "/getWishList", method = RequestMethod.GET,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<List<MovieDetails>> getWishList(@RequestParam("userId") String userId) {

    List<WishList> wishList = wishlistService.readWishList(userId);
    List<MovieDetails> movieDetails = new ArrayList<>();
    for (WishList wishLst : wishList) {
      movieDetails.add(wishlistService.createMovieListResponse(wishLst));
    }

    return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
  }


  @ResponseBody
  @RequestMapping(value = "/addWishlist", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<List<MovieDetails>> addWishList(@RequestBody WishListRequest wishListRequest) {

    WishList wishLst = new WishList();
    List<MovieDetails> movieDetails = new ArrayList<>();
    MultiValueMap<String, String> headers = new HttpHeaders();
    try {
    MovieDetails movie = movieDetailRepository.findById(wishListRequest.getId());
    wishLst.setUserId(wishListRequest.getUserId());
    wishLst.setMovieDetails(movie);
    wishlistService.createWishlist(wishLst);
    List<WishList> wishList = wishlistService.readWishList(wishListRequest.getUserId());
    for (WishList wishList1 : wishList) {
      movieDetails.add(wishlistService.createMovieListResponse(wishList1));
    }
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
  }catch (Exception e){
    throw e;
  }
    return  new ResponseEntity<List<MovieDetails>>(movieDetails,headers, HttpStatus.OK);

  }

  @ResponseBody
  @RequestMapping(value = "/removeWishlist", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<List<MovieDetails>> removeWishList(@RequestBody WishListRequest wishListRequest) {

    WishList wishLst = new WishList();
    List<MovieDetails> movieDetails = new ArrayList<>();
    MultiValueMap<String, String> headers = new HttpHeaders();
    try {
      wishlistRepository.removeByUserIdAndId(wishListRequest.getUserId(),wishListRequest.getId());
      List<WishList> wishList = wishlistService.readWishList(wishListRequest.getUserId());
      for (WishList wishList1 : wishList) {
        movieDetails.add(wishlistService.createMovieListResponse(wishList1));
      }
      headers.add("Access-Control-Allow-Origin","*");
      headers.add("Access-Control-Allow-Methods","GET, POST");
      headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
      headers.add("X-XSS-Protection", "1; mode=block");
      headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
    }catch (Exception e){
      throw e;
    }
    return  new ResponseEntity<List<MovieDetails>>(movieDetails,headers, HttpStatus.OK);

  }
}
