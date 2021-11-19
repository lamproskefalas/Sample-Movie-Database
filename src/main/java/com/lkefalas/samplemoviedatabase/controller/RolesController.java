package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.roles.RoleFullDetailsDTO;
import com.lkefalas.samplemoviedatabase.api.roles.RolePersistDTO;
import com.lkefalas.samplemoviedatabase.api.roles.RoleSimpleDTO;
import com.lkefalas.samplemoviedatabase.domain.Role;
import com.lkefalas.samplemoviedatabase.service.ActorService;
import com.lkefalas.samplemoviedatabase.service.RoleService;
import com.lkefalas.samplemoviedatabase.service.ShowService;
import com.lkefalas.samplemoviedatabase.transfer.ApiResponse;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/roles")
@Getter
public class RolesController extends AbstractController
        <Role, RoleSimpleDTO, RoleFullDetailsDTO, RolePersistDTO> {
    private final RoleService baseService;
    private final ShowService showService;
    private final ActorService actorService;

    protected RolesController(ModelMapper modelMapper, RoleService baseService, ShowService showService, ActorService actorService) {
        super(modelMapper);
        this.baseService = baseService;
        this.showService = showService;
        this.actorService = actorService;
    }

    @Override
    public Role convertToEntity(RolePersistDTO rolePersistDTO, String mode) {
        // We do not want to set the id when creating this even if provided
        if(mode.equals("create")) {
            rolePersistDTO.setId(null);
        }

        Role role = modelMapper.map(rolePersistDTO, Role.class);

        if(rolePersistDTO.getActorId() != null) {
            role.setActor(actorService.find(rolePersistDTO.getActorId()));
        }

        if(rolePersistDTO.getShowId() != null) {
            role.setShow(showService.find(rolePersistDTO.getShowId()));
        }

        return role;
    }

    @Override
    public RoleFullDetailsDTO convertToDetailedDto(Role model) {
        return modelMapper.map(model, RoleFullDetailsDTO.class);
    }

    @Override
    RoleSimpleDTO convertToSimpleDto(Role model) {
        return modelMapper.map(model, RoleSimpleDTO.class);
    }
}
