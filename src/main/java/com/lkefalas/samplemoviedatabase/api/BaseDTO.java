package com.lkefalas.samplemoviedatabase.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseDTO implements Serializable {
    private Long id;
}
