package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class HandleStrike {
    public static void handle_strike (TotalScoreDatabase tdb, Frames frameStart, int roll2, List<Frames> frames) {
        tdb.gameFrameStatuses.add(FrameStatus.STRIKE);
        roll2 = 0;
        frameStart.scoreToCount = 0;
        frames.add(frameStart);
        tdb.totalScore += 10;
    }
}
