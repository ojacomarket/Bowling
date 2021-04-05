package com.tietoEVRY2.bowling.util.console.util;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.STRIKES_TABLE;
import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.STRIKES_TABLE_SCORE;

public abstract class ConsolePlayerStrike {
    public static void console_strike_case(ScoreBoard realPlayer, int throwsMade) {
        if (realPlayer.getFrames().get(throwsMade).scoreToCount == 0) {
            System.out.format(STRIKES_TABLE_SCORE,
                    "Frame nr " + throwsMade,
                    "X",
                    " ",
                    " ");
        } else {
            System.out.format(STRIKES_TABLE,
                    "Frame nr " + throwsMade,
                    "X",
                    " ", realPlayer.getFrames().get(throwsMade).scoreToCount);
        }
    }
}
