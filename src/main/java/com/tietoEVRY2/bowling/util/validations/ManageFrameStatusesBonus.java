package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.GameStatus;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

import static com.tietoEVRY2.bowling.util.BonusFrameSuperCheck.superCheck;

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
    public static void throwRoll1 (TotalScoreDatabase db,
                                   int roll1,
                                   List<Frames> frames,
                                   int frameNr,
                                   List<FrameStatus> localRollFrameStatuses) {
        db.totalScore += roll1;
        frames.add(new Frames());
        frames.get(frameNr).roll1 = roll1;
        checkFirstRoll(roll1, localRollFrameStatuses);
    }
    public static void throwRoll2and3 (TotalScoreDatabase db,
                                       int roll1,
                                       int roll2,
                                       int roll3,
                                       List<Frames> frames,
                                       int frameNr,
                                       List<FrameStatus> localRollFrameStatuses) {
        frames.get(frameNr).roll2 = roll2;
        db.totalScore += roll2;
        checkSecondRoll(roll1, roll2, localRollFrameStatuses);
        superCheck(localRollFrameStatuses, db, frames, frameNr, roll1, roll2, roll3);
    }
}
