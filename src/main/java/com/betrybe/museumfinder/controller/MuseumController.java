package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Camada Controller - Responsável por lidas com as requisições.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * Cria um novo museu com base nos dados fornecidos.
   *
   * @param museumCreationDto representa o museu criado.
   * @return representa o museu criado convertido a partir da entidade {@code Museum}.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum museum = museumService.createMuseum(ModelDtoConverter.dtoToModel(museumCreationDto));
    return ResponseEntity.status(201).body(ModelDtoConverter.modelToDto(museum));
  }

  /**
   * Obtém o museu mais próximo com base nas coordenadas geográficas e na distância máxima
   * fornecida.
   *
   * @param lat         Coordenada de latitude da localização atual.
   * @param lng         Coordenada de longitude da localização atual.
   * @param maxDistKm Distância máxima em quilômetros dentro da qual o museu mais próximo deve ser
   *                    encontrado.
   * @return Um objeto MuseumDto que representa o museu
   * @throws NumberFormatException Se as coordenadas de latitude, longitude ou a distância máxima
   *                               não puderem ser convertidas em números válidos.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(@RequestParam(name = "lng") String lat,
      @RequestParam(name = "lng") String lng,
      @RequestParam(name = "max_dist_km") String maxDistKm) {
    double latitude = Double.parseDouble(lat);
    double longitude = Double.parseDouble(lng);
    double maxDist = Double.parseDouble(maxDistKm);
    Coordinate cordinate = new Coordinate(latitude, longitude);
    Museum museum = museumService.getClosestMuseum(cordinate, maxDist);
    return ResponseEntity.status(200).body(ModelDtoConverter.modelToDto(museum));
  }
}
