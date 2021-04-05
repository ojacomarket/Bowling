package com.tietoEVRY2.bowling.util.handlers;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class HandleNormal {
    public static void handle_normal (TotalScoreDatabase tdb, Frames frameStart, int roll1, int roll2, List<Frames> frames) {
        tdb.gameFrameStatuses.add(FrameStatus.NORMAL);
        frameStart.roll2 = roll2;
        tdb.totalScore += roll1 + roll2;
        frameStart.scoreToCount = tdb.totalScore;
        System.out.println(tdb.totalScore + "TOTAL");
        frames.add(frameStart);
    }
}
