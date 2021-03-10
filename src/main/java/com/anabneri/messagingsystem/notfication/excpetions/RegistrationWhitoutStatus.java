package com.anabneri.messagingsystem.notfication.excpetions;

public class RegistrationWhitoutStatus extends RuntimeException {
    public RegistrationWhitoutStatus(String message) {
        super(message);
    }
}
