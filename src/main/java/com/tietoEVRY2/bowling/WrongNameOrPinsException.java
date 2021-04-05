package com.tietoEVRY2.bowling;

public class FrameScoreOutOfBoundariesException extends RuntimeException{
    public FrameScoreOutOfBoundariesException(String message) {
        super(message);
    }
}
