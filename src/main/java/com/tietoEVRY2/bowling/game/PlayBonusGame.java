package com.tietoEVRY2.bowling.game;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.tietoEVRY2.bowling.util.validations.ManageFrameStatusesBonus.*;

@AllArgsConstructor
public class PlayBonusGame {
    public TotalScoreDatabase db;
    public List<Frames> frames;
    public int frameNr;

    public void playBonusFrame(int roll1, int roll2, int roll3) {

        List<FrameStatus> localRollFrameStatuses = new ArrayList<>();

        throwRoll1(db, roll1, frames, frameNr, localRollFrameStatuses);

        throwRoll2and3(db, roll1, roll2, roll3, frames, frameNr, localRollFrameStatuses);
    }
}
