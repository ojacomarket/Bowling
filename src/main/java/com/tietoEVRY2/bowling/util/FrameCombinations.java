package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.STATUS;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

public abstract class FrameCombinations {
    public static boolean strike_strike (int frameTracker, TABLE_DATABASE tdb) {
        return frameTracker > 1 && tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker-1) == STATUS.STRIKE;
    }
}
