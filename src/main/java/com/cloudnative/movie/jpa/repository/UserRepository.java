package com.cloudnative.movie.jpa.repository;

import com.cloudnative.movie.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {

  public User findByEmail(String email);
}
