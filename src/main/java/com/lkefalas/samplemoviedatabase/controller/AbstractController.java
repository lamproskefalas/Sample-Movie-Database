package com.lkefalas.samplemoviedatabase.controller;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.domain.BaseModel;
import com.lkefalas.samplemoviedatabase.service.BaseService;
import com.lkefalas.samplemoviedatabase.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public abstract class AbstractController
        <T extends BaseModel,S extends BaseDTO,D extends BaseDTO, P extends BasePersistDTO>
        extends AbstractLogComponent
{
    protected abstract BaseService<T,Long> getBaseService();
    protected final ModelMapper modelMapper;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<? extends BaseDTO>>> findAll(@RequestParam(defaultValue = "false") String fullDetails) {

        List<? extends BaseDTO> responseDTO = null;
        if (fullDetails.equals("false")) {
            List<T> entities = getBaseService().findAll();

            if (entities!=null) {
                responseDTO = entities.stream().map(this::convertToSimpleDto).collect(Collectors.toList());
            }
        } else {
            List<T> entities = getBaseService().findAllWithDetails();
            
            if (entities!=null) {
                responseDTO = entities.stream().map(this::convertToDetailedDto).collect(Collectors.toList());
            }
        }
        return ResponseEntity.ok(ApiResponse.<List<? extends BaseDTO>>builder().data(responseDTO).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> find(
            @PathVariable("id") final Long id,
            @RequestParam(defaultValue = "false") String fullDetails
    ) {
        BaseDTO responseDTO;
        if (fullDetails.equals("false")) {
            T entity = getBaseService().find(id);

            responseDTO = (entity != null) ? convertToSimpleDto(entity) : null;
        } else {
            T entity = getBaseService().findWithDetails(id);
            responseDTO = (entity!=null) ? convertToDetailedDto(entity) : null;
        }

        return ResponseEntity.ok(ApiResponse.<BaseDTO>builder().data(responseDTO).build());
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> createObject(@Valid @RequestBody final P persistDTO) {
        T object = convertToEntity(persistDTO, "create");
        object = getBaseService().create(object);

        BaseDTO responseDTO = (object!=null) ? convertToDetailedDto(object) : null;
        return new ResponseEntity<>(ApiResponse.<BaseDTO>builder().data(responseDTO).build(), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final P persistDTO) {
        T object = convertToEntity(persistDTO, "update");

        if(!getBaseService().exists(object))
            throw new NoSuchElementException();

        getBaseService().update(object);
    }

    abstract T convertToEntity(P persistDTO, String mode);
    abstract D convertToDetailedDto(T model);
    abstract S convertToSimpleDto(T model);
}
