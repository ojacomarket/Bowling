package com.tietoEVRY2.bowling.util.console.util;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.BONUS_FRAME;

public abstract class ConsoleFrameCombosHandler {
    public static void console_not_roll3_handler(ScoreBoard realPlayer, int throwsMade) {
        System.out.format(BONUS_FRAME, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                realPlayer.getFrames().get(throwsMade).roll2,
                " ", realPlayer.getFrames().get(throwsMade).scoreToCount);
    }

    public static void console_roll3_handler(ScoreBoard realPlayer, int throwsMade) {
        System.out.format(BONUS_FRAME, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                realPlayer.getFrames().get(throwsMade).roll2,
                realPlayer.getFrames().get(throwsMade).roll3, realPlayer.getFrames().get(throwsMade).scoreToCount);
    }
}
