package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class HandleFrameCombos {
    public static void handle_strike_strike (List<Frames> frames, int frameTracker, TABLE_DATABASE tdb) {
        frames.get(frameTracker - 2).scoreToCount = tdb.totalScore;
        tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + 20;
    }
}
