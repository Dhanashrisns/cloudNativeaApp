package com.cloudnative.movie.jpa.repository;

import com.cloudnative.movie.jpa.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishList,String> {

  List<WishList> findAllByUserId(String userId);

  @Query("delete from wishlist wishLst where wishLst.userId= :userId and wishLst.movieDetails= :movieDetails")
  void removeByUserIdAndId(@Param("userId") String userId,@Param("movieDetails") Integer movieDetails);


}
