package com.tietoEVRY2.bowling.util.console;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.SPARE_TABLE;
import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.SPARE_TABLE_SCORE;

public abstract class ConsolePlayerSpare {
    public static void console_spare_case (ScoreBoard realPlayer, int throwsMade) {
        if (realPlayer.getFrames().get(throwsMade).scoreToCount == 0) {
            System.out.format(SPARE_TABLE_SCORE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                    "/", " ");
        } else {
            System.out.format(SPARE_TABLE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                    "/", realPlayer.getFrames().get(throwsMade).scoreToCount);
        }
    }
}
