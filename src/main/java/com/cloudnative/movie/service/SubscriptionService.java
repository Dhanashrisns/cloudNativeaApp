package com.cloudnative.movie.service;

import com.cloudnative.movie.domain.SubscribeRequest;
import com.cloudnative.movie.jpa.entity.User;
import com.cloudnative.movie.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

  @Autowired
  JavaMailSender javaMailSender;

  @Autowired
  UserRepository userRepository;

  public String subscribe(SubscribeRequest subscribeRequest){

    User user = userRepository.findByEmail(subscribeRequest.getUserId());
    user.setSubscribed(subscribeRequest.getSubscribed());
    userRepository.saveAndFlush(user);
    String body =  "Your"+subscribeRequest.getSubscribed() +" subscription has been activated";
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo("sanasdhanashri13@gmail.com");
    simpleMailMessage.setSubject("OTT subscription");
    simpleMailMessage.setText(body);
    javaMailSender.send(simpleMailMessage);
    return body;
  }
}
