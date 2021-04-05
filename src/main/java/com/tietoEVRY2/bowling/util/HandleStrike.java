package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.STATUS;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class HandleStrike {
    public static void handle_strike (TABLE_DATABASE tdb, Frames frameStart, int roll2, List<Frames> frames) {
        tdb.gameStatus.add(STATUS.STRIKE);
        roll2 = 0;
        frameStart.scoreToCount = 0;
        frames.add(frameStart);
        tdb.totalScore += 10;
    }
}
