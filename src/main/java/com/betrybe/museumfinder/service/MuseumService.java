package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * Representa a Service da aplicação.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }


  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    com.betrybe.museumfinder.model.Coordinate coordinate = museum.getCoordinate();
    boolean isValidCordinate = CoordinateUtil.isCoordinateValid(coordinate);

    if (!isValidCordinate) {
      throw new InvalidCoordinateException();
    }

    Museum newMuseum = museumFakeDatabase.saveMuseum(museum);
    return newMuseum;
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
