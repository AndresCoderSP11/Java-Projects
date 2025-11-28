package com.test.api.marvel_challenge.persistence.repository;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ComicDto;

import java.util.List;

public class ComicRepository {
    public List<ComicDto> findAll(MyPageable pageable, Long characterId) {
        return null;
    }

    public ComicDto findById(Long comicId) {
        return null;
    }
}
