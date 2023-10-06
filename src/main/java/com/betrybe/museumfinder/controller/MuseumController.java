package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  @ResponseStatus(HttpStatus.CREATED)
  public MuseumDto createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum museum = museumService.createMuseum(
        ModelDtoConverter.dtoToModel(museumCreationDto)
    );
    return ModelDtoConverter.modelToDto(museum);
  }
}
