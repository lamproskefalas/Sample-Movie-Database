package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.domain.BaseModel;
import com.lkefalas.samplemoviedatabase.service.BaseService;
import com.lkefalas.samplemoviedatabase.transfer.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public abstract class AbstractController
        <T extends BaseModel,S extends BaseDTO,D extends BaseDTO, P extends BasePersistDTO>
        extends AbstractLogComponent
{
    protected abstract BaseService<T,Long> getBaseService();
    protected final ModelMapper modelMapper;

    protected AbstractController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<S>>> findAll() {
        List<T> details = getBaseService().findAll();

        List<S> simpleDTO = details.stream().map(this::convertToSimpleDto).collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponse.<List<S>>builder().data(simpleDTO).build());
    }

    @GetMapping("/fullDetails")
    public ResponseEntity<ApiResponse<List<D>>> findAllWithDetails(){
        List<T> details = getBaseService().findAllWithDetails();

        List<D> detailedDTO = details.stream().map(this::convertToDetailedDto).collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponse.<List<D>>builder().data(detailedDTO).build());
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<T>> createObject(@Valid @RequestBody final P persistDTO) {
        T object = convertToEntity(persistDTO, "create");
        return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(object)).build(), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final P persistDTO) {
        T object = convertToEntity(persistDTO, "update");
        getBaseService().update(object);
    }

    abstract T convertToEntity(P persistDTO, String mode);
    abstract D convertToDetailedDto(T model);
    abstract S convertToSimpleDto(T model);
}
