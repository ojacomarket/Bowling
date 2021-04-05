package com.tietoEVRY2.bowling;

public class WrongNameOrPinsException extends RuntimeException{
    public WrongNameOrPinsException(String message) {
        super(message);
    }
}
