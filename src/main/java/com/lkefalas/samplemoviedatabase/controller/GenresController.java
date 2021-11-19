package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.genres.GenreFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.genres.GenrePersistDTO;
import com.lkefalas.samplemoviedatabase.api.genres.GenreSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Genre;
import com.lkefalas.samplemoviedatabase.service.GenreService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/genres")
@Getter
public class GenresController extends AbstractController
        <Genre, GenreSimpleDTO, GenreFullDetailsDTO, GenrePersistDTO> {
    private final GenreService baseService;

    protected GenresController(ModelMapper modelMapper, GenreService baseService) {
        super(modelMapper);
        this.baseService = baseService;
    }

    @Override
    public Genre convertToEntity(GenrePersistDTO genrePersistDTO, String mode) {
        // We do not want to set the id when creating this even if provided
        if(mode.equals("create")) {
            genrePersistDTO.setId(null);
        }

        return modelMapper.map(genrePersistDTO, Genre.class);
    }

    @Override
    public GenreFullDetailsDTO convertToDetailedDto(Genre model) {
        return modelMapper.map(model, GenreFullDetailsDTO.class);
    }

    @Override
    GenreSimpleDTO convertToSimpleDto(Genre model) {
        return modelMapper.map(model, GenreSimpleDTO.class);
    }
}
