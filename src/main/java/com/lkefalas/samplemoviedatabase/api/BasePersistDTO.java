package com.lkefalas.samplemoviedatabase.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BasePersistDTO implements Serializable {
    private Long id;
}
