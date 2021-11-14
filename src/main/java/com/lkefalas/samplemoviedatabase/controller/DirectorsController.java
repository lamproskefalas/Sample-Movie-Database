package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.directors.DirectorFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.directors.DirectorPersistDTO;
import com.lkefalas.samplemoviedatabase.api.directors.DirectorSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.service.DirectorService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/directors")
@Getter
public class DirectorsController extends AbstractController
        <Director, DirectorSimpleDTO, DirectorFullDetailsDTO, DirectorPersistDTO> {
    private final DirectorService baseService;
    private final ModelMapper modelMapper;

    public DirectorsController(DirectorService baseService, ModelMapper modelMapper) {
        super(modelMapper);
        this.baseService = baseService;
        this.modelMapper = modelMapper;
    }

    @Override
    public DirectorFullDetailsDTO convertToDetailedDto(Director model) {
        return modelMapper.map(model, DirectorFullDetailsDTO.class);
    }

    @Override
    DirectorSimpleDTO convertToSimpleDto(Director model) {
        return modelMapper.map(model, DirectorSimpleDTO.class);
    }

    @Override
    public Director convertToEntity(DirectorPersistDTO DirectorPersistDTO, String mode) {
        if(mode.equals("create")){
            DirectorPersistDTO.setId(null);
        }
        return modelMapper.map(DirectorPersistDTO, Director.class);
    }
}
