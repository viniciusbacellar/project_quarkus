package org.acme.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime instant;
    private int status;
    private String error;
    private String message;
    private String path;
}
