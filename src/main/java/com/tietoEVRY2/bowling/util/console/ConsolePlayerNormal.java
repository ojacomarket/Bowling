package com.tietoEVRY2.bowling.util.console;

import com.tietoEVRY2.bowling.game.ScoreBoard;

public abstract class ConsolePlayerNormal {
    public static void console_normal_case(ScoreBoard realPlayer, int throwsMade) {
        System.out.format(ConsoleOutputConfig.NORMAL_TABLE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                realPlayer.getFrames().get(throwsMade).roll2, realPlayer.getFrames().get(throwsMade).scoreToCount);
    }
}
