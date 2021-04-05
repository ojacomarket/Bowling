package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.STATUS;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class HandleNormal {
    public static void handle_normal (TABLE_DATABASE tdb, Frames frameStart, int roll1, int roll2, List<Frames> frames) {
        tdb.gameStatus.add(STATUS.NORMAL);
        frameStart.roll2 = roll2;
        tdb.totalScore += roll1 + roll2;
        frameStart.scoreToCount = tdb.totalScore;
        System.out.println(tdb.totalScore + "TOTAL");
        frames.add(frameStart);
    }
}
