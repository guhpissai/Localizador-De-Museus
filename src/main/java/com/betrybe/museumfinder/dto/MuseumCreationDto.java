package com.betrybe.museumfinder.dto;

/**
 * Um objeto de transferência de dados (DTO).
 */
public record MuseumCreationDto(String name, String description, String address,
                                String collectionType, String subject, String url,
                                com.betrybe.museumfinder.model.Coordinate coordinate) {

}
