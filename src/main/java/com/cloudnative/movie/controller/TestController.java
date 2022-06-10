package com.cloudnative.movie.controller;

import com.cloudnative.movie.jpa.entity.MovieDetails;
import com.cloudnative.movie.jpa.repository.MovieDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class TestController {
Logger logger = Logger.getLogger(TestController.class.getName());

  @Autowired
 private MovieDetailRepository movieDetailRepository;


  @ResponseBody
  @RequestMapping(value = "/getMovies", method = RequestMethod.GET,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<?> getAllMovieList() throws IOException {
    ResponseEntity<List<MovieDetails>> responseEntity = null;
    List<MovieDetails> movieDetailsList = movieDetailRepository.getAllMovies();
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

    responseEntity = new ResponseEntity<>(movieDetailsList, headers, HttpStatus.OK);
    return responseEntity;
  }


  @ResponseBody
  @RequestMapping(value = "/filterMovies", method = RequestMethod.GET,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<?> filterMovies(@RequestParam (required = false) String title,@RequestParam (required = false) String year,@RequestParam (required = false) String language) throws IOException {
    ResponseEntity<List<MovieDetails>> responseEntity = null;
    List<MovieDetails> movieDetailsList=new ArrayList<>();
    if(title!="" && title!=null) {
      movieDetailsList = movieDetailRepository.searchByTitle(title);
    }else if(year!="" && year!=null){
      movieDetailsList = movieDetailRepository.searchByYear(new Integer(year));
    } else{
      movieDetailsList = movieDetailRepository.searchByLangauge(language);
    }
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

    responseEntity = new ResponseEntity<>(movieDetailsList, headers, HttpStatus.OK);
    return responseEntity;
  }



}
