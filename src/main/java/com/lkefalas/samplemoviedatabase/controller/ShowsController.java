package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.actors.ActorsPersistDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowPersistDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.domain.Show;
import com.lkefalas.samplemoviedatabase.service.ShowService;
import com.lkefalas.samplemoviedatabase.transfer.ApiResponse;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/shows")
@Getter
public class ShowsController extends AbstractController
        <Show, ShowSimpleDTO, ShowFullDetailsDTO, ShowPersistDTO> {
    private final ShowService baseService;
    private final ModelMapper modelMapper;

    public ShowsController(ShowService baseService, ModelMapper modelMapper) {
        super(modelMapper);
        this.baseService = baseService;
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
        return modelMapper.map(showPersistDTO, Show.class);
    }
}
