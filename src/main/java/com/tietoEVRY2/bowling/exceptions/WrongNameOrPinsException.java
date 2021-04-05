package com.tietoEVRY2.bowling.exceptions;

public class WrongNameOrPinsException extends RuntimeException{
    public WrongNameOrPinsException(String message) {
        super(message);
    }
}
