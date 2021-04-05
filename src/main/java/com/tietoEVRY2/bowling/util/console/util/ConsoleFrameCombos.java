package com.tietoEVRY2.bowling.util.console.util;

import com.tietoEVRY2.bowling.game.ScoreBoard;

public abstract class ConsoleFrameCombos {
    public static boolean isStrike(ScoreBoard realPlayer, int throwsMade) {
        return realPlayer.getFrames().get(throwsMade).roll1 == 10;
    }

    public static boolean isSpare(ScoreBoard realPlayer, int throwsMade) {
        return realPlayer.getFrames().get(throwsMade).roll1 + realPlayer.getFrames().get(throwsMade).roll2 == 10;
    }
    public static boolean isNotRoll3 (ScoreBoard realPlayer, int throwsMade) {
       return realPlayer.getFrames().get(throwsMade).roll3 == null;
    }
}
