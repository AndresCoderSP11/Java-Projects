package com.test.api.marvel_challenge.persistence.integration.marvel;

public record ComicDto(
    Long id,
    String title,
    String description,
    String modified,
    String resourceURI
) {
    
}
