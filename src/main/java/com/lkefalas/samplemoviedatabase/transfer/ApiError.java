package com.lkefalas.samplemoviedatabase.transfer;

import lombok.ToString;
import lombok.Value;

import java.util.List;

/**
 * This class represents an error occurred while serving the corresponding request
 */
@Value
@ToString
public class ApiError {
    Integer status;
    List<String> messages;
    String path;
}
