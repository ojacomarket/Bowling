package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.BonusFrameSuperCheck;
import com.tietoEVRY2.bowling.util.ManageFrameStatusesBonus;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayBonusGame {
    public TotalScoreDatabase db;
    public List<Frames> frames;
    public int frameNr;

    public void playBonusFrame(int roll1, int roll2, int roll3) {
        System.out.println(frameNr);
        List<FrameStatus> localRollFrameStatuses = new ArrayList<>();
        db.totalScore += roll1;
        frames.add(new Frames());
        frames.get(frameNr).roll1 = roll1;
        ManageFrameStatusesBonus.checkFirstRoll(roll1, localRollFrameStatuses);

        frames.get(frameNr).roll2 = roll2;
        db.totalScore += roll2;
        ManageFrameStatusesBonus.checkSecondRoll(roll1, roll2, localRollFrameStatuses);
        BonusFrameSuperCheck.superCheck(localRollFrameStatuses, db, frames, frameNr, roll1, roll2, roll3);
    }
}
