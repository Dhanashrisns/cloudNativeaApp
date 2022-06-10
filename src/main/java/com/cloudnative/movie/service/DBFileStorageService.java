package com.cloudnative.movie.service;

import com.cloudnative.movie.jpa.entity.MovieDetails;
import com.cloudnative.movie.jpa.repository.MovieDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class DBFileStorageService {
  Logger logger = Logger.getLogger(DBFileStorageService.class.getName());
  @Autowired
  private MovieDetailRepository dbFileRepository;

  public MovieDetails storeFile(MultipartFile file) {
    // Normalize file name
logger.info("storeFile");
    MovieDetails dbFile = new MovieDetails();
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      Date date = new Date();
      try {
        date = new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2021");
        logger.info("date"+date);
      }catch (Exception e){
        logger.info("exception-"+e.getStackTrace());
      }
      dbFile = new MovieDetails("Love You Zindagi",date,"60%","Hindi", file.getBytes());
       logger.info("dbFile"+dbFile);

    } catch (IOException ex) {
      logger.info("exception-"+ex.getStackTrace());
    }
    return dbFileRepository.saveAndFlush(dbFile);
  }
}
