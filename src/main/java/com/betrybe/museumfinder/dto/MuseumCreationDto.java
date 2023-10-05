package com.betrybe.museumfinder.dto;

public record MuseumCreationDto(String name, String description, String address,
                                String collectionType, String subject, String url,
                                com.betrybe.museumfinder.model.Coordinate coordinate) {

}
