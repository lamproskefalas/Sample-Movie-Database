package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.actors.ActorFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorPersistDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.service.ActorService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/actors")
@Getter
public class ActorsController extends AbstractController
        <Actor, ActorSimpleDTO, ActorFullDetailsDTO, ActorPersistDTO> {
    private final ActorService baseService;

    protected ActorsController(ModelMapper modelMapper, ActorService baseService) {
        super(modelMapper);
        this.baseService = baseService;
    }

    @Override
    public Actor convertToEntity(ActorPersistDTO actorPersistDTO, String mode) {
        // We do not want to set the id when creating this even if provided
        if(mode.equals("create")) {
            actorPersistDTO.setId(null);
        }

        return modelMapper.map(actorPersistDTO, Actor.class);
    }

    @Override
    public ActorFullDetailsDTO convertToDetailedDto(Actor model) {
        return modelMapper.map(model, ActorFullDetailsDTO.class);
    }

    @Override
    ActorSimpleDTO convertToSimpleDto(Actor model) {
        return modelMapper.map(model, ActorSimpleDTO.class);
    }
}
