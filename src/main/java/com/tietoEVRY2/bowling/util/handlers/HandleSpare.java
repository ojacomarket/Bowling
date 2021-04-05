package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class HandleSpare {
    public static void handle_spare(TotalScoreDatabase tdb, Frames frameStart, int roll2, List<Frames> frames) {
        tdb.gameFrameStatuses.add(FrameStatus.SPARE);
        frameStart.roll2 = roll2;
        tdb.totalScore += 10;
        frameStart.scoreToCount = 0;
        frames.add(frameStart);
    }
}
