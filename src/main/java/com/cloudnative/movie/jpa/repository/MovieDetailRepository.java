package com.cloudnative.movie.jpa.repository;

import com.cloudnative.movie.jpa.entity.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDetailRepository extends JpaRepository<MovieDetails,String> {

  @Query("SELECT movieDtl  from Movie_Detail movieDtl")
  public List<MovieDetails> getAllMovies();

  public MovieDetails findById(Integer id);

  @Query("SELECT movieDtl  from Movie_Detail movieDtl where movieDtl.title like %:title%")
  public List<MovieDetails> searchByTitle(@Param("title") String title);

  @Query("SELECT movieDtl  from Movie_Detail movieDtl where year(movieDtl.releaseDate)= :releaseDate")
  public List<MovieDetails> searchByYear(@Param("releaseDate") int releaseDate);

  @Query("SELECT movieDtl  from Movie_Detail movieDtl where movieDtl.language= :language")
  public List<MovieDetails> searchByLangauge(@Param("language") String language);
}
