package com.cloudnative.movie.controller;

import com.cloudnative.movie.domain.SubscribeRequest;
import com.cloudnative.movie.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionController {

  @Autowired
  SubscriptionService subscriptionService;

  @ResponseBody
  @RequestMapping(value = "/subscribe", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
         public ResponseEntity<String> subscribe(@RequestBody SubscribeRequest subscribeRequest) {
    String message;
    try {
    message = subscriptionService.subscribe(subscribeRequest);
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin","*");
    headers.add("Access-Control-Allow-Methods","GET, POST");
    headers.add("Access-Control-Allow-Headers","Content-Type,Accept,X-Requested-With");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
  }catch (Exception e){
    throw e;
  }
    return  new ResponseEntity<String>(message, HttpStatus.OK);
  }
}
