package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.actors.ActorFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorsPersistDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorsSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.service.ActorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController()
@RequestMapping("/actors")
@Getter
public class ActorsController extends AbstractController
        <Actor, ActorsSimpleDTO, ActorFullDetailsDTO, ActorsPersistDTO> {
    private final ActorService baseService;

    protected ActorsController(ModelMapper modelMapper, ActorService baseService) {
        super(modelMapper);
        this.baseService = baseService;
    }

    @Override
    public Actor convertToEntity(ActorsPersistDTO actorsPersistDTO, String mode) {
        // We do not want to set the id when creating this even if provided
        if(mode.equals("create")) {
            actorsPersistDTO.setId(null);
        }

        return modelMapper.map(actorsPersistDTO, Actor.class);
    }

    @Override
    public ActorFullDetailsDTO convertToDetailedDto(Actor model) {
        return modelMapper.map(model, ActorFullDetailsDTO.class);
    }

    @Override
    ActorsSimpleDTO convertToSimpleDto(Actor model) {
        return modelMapper.map(model, ActorsSimpleDTO.class);
    }
}
