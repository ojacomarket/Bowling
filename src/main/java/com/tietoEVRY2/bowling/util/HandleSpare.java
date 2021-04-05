package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.STATUS;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class HandleSpare {
    public static void handle_spare(TABLE_DATABASE tdb, Frames frameStart, int roll2, List<Frames> frames) {
        tdb.gameStatus.add(STATUS.SPARE);
        frameStart.roll2 = roll2;
        tdb.totalScore += 10;
        frameStart.scoreToCount = 0;
        frames.add(frameStart);
    }
}
