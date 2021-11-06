package com.lkefalas.samplemoviedatabase.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseModel {
    private static final long serialVersionUID = 1L;
    private Long id;
}