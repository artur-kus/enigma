package com.example.enigma_z2.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DefaultException extends Exception {

    private String message;
    private Map<String, String> errors;

    public DefaultException(String message) {
        super(message);
    }
}