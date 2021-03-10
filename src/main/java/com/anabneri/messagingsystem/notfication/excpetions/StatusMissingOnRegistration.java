package com.anabneri.messagingsystem.notfication.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class StatusMissingOnRegistration extends RuntimeException {

    public StatusMissingOnRegistration(String message) {
        super(message);
    }
}
