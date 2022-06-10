package com.cloudnative.movie.service;

import com.cloudnative.movie.domain.LoginRequest;
import com.cloudnative.movie.domain.RegistrationRequest;
import com.cloudnative.movie.domain.RegistrationResponse;
import com.cloudnative.movie.jpa.entity.User;
import com.cloudnative.movie.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService /*implements UserDetailsService*/ {

  @Autowired
  UserRepository userRepository;

 /* @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;*/

  public RegistrationResponse registerUser(RegistrationRequest registrationRequest){
     RegistrationResponse registrationResponse = new RegistrationResponse();
    User userDetails = new User();
    try {
      userDetails.setName(registrationRequest.getName());
      userDetails.setPassword(/*bCryptPasswordEncoder.encode(*/registrationRequest.getPassword());
      userDetails.setEmail(registrationRequest.getEmail());
      User userDtl = userRepository.findByEmail(registrationRequest.getEmail());
      if (userDtl != null) {
        registrationResponse.setMessage("User is already registered");
        registrationResponse.setUsername(userDtl.getName());
      } else {
        User userDetails1 = userRepository.saveAndFlush(userDetails);
        registrationResponse.setMessage("User registered successfully");
        registrationResponse.setUsername(userDetails1.getName());
      }
    }catch(Exception e){
      throw e;
    }
       return registrationResponse;
     }



  public RegistrationResponse loginUser(LoginRequest loginRequest){

    RegistrationResponse registrationResponse = new RegistrationResponse();
    try {
      User userDtl = userRepository.findByEmail(loginRequest.getEmail());
      if (userDtl != null) {
        registrationResponse.setMessage("User is successfully logged in");
        registrationResponse.setUsername(userDtl.getName());
      } else {
        registrationResponse.setMessage("User is not registered. Please register first");
        registrationResponse.setUsername(loginRequest.getEmail());
      }
    }catch (Exception e){
      throw e;
    }
    return registrationResponse;
  }

  /*@Override
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User userDetails = userRepository.findByEmail(username);
    if(userDetails==null){
      throw new UsernameNotFoundException("User can not be found");
    }
    return new CurrentUserDetail(userDetails);
  }*/
}
