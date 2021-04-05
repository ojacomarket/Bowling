package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.FrameStatus;

import java.util.List;

public abstract class ManageFrameStatusesBonus {
    public static void checkFirstRoll(int roll1, List<FrameStatus> localRollFrameStatuses) {
        if (roll1 == 10) {
            localRollFrameStatuses.add(FrameStatus.STRIKE);
        } else {
            localRollFrameStatuses.add(FrameStatus.NORMAL);

        }
    }

    public static void checkSecondRoll(int roll1, int roll2, List<FrameStatus> localRollFrameStatuses) {
        if (roll1 + roll2 == 10) {
            localRollFrameStatuses.add(FrameStatus.SPARE);

        } else if (roll2 == 10) {
            localRollFrameStatuses.add(FrameStatus.STRIKE);

        } else {
            localRollFrameStatuses.add(FrameStatus.NORMAL);
        }
    }
}
