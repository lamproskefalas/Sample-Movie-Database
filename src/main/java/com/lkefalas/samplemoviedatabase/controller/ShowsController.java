package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.shows.ShowFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowPersistDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Genre;
import com.lkefalas.samplemoviedatabase.domain.Show;
import com.lkefalas.samplemoviedatabase.service.DirectorService;
import com.lkefalas.samplemoviedatabase.service.GenreService;
import com.lkefalas.samplemoviedatabase.service.ShowService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController()
@RequestMapping("/shows")
@Getter
public class ShowsController extends AbstractController
        <Show, ShowSimpleDTO, ShowFullDetailsDTO, ShowPersistDTO> {
    private final ShowService baseService;
    private final DirectorService directorService;
    private final GenreService genreService;
    private final ModelMapper modelMapper;

    public ShowsController(ShowService baseService, DirectorService directorService, GenreService genreService, ModelMapper modelMapper) {
        super(modelMapper);
        this.baseService = baseService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShowFullDetailsDTO convertToDetailedDto(Show model) {
        return modelMapper.map(model, ShowFullDetailsDTO.class);
    }

    @Override
    ShowSimpleDTO convertToSimpleDto(Show model) {
        return modelMapper.map(model, ShowSimpleDTO.class);
    }

    @Override
    public Show convertToEntity(ShowPersistDTO showPersistDTO, String mode) {
        if(mode.equals("create")){
            showPersistDTO.setId(null);
        }

        Show show = modelMapper.map(showPersistDTO, Show.class);

        if(showPersistDTO.getDirectorId() != null) {
            show.setDirector(directorService.find(showPersistDTO.getDirectorId()));
        }

        if(showPersistDTO.getMovieGenres() != null) {
            Set<Genre> movieGenres = new HashSet<>();
            for (Long genreId: showPersistDTO.getMovieGenres()) {
                Genre genre = genreService.find(genreId);
                if(genre != null) {
                    movieGenres.add(genre);
                }
            }
            show.setDirector(directorService.find(showPersistDTO.getDirectorId()));
            show.setGenres(movieGenres);
        }

        return show;
    }
}
