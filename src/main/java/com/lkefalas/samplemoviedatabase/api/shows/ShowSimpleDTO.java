package com.lkefalas.samplemoviedatabase.api.shows;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ShowSimpleDTO extends BaseDTO {
    private String title;

    private Integer releaseYear;

    private BigDecimal rating;

    private ShowTypeDTO showType;
}
