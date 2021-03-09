package com.anabneri.messagingsystem.notfication.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StatusNotFound extends RuntimeException {

    public StatusNotFound(String message) {
        super(message);
    }

}
