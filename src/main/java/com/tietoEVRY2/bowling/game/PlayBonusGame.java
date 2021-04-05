package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.FrameCombinations;
import com.tietoEVRY2.bowling.util.HandleFrameCombosBonus;
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
        if (roll1 == 10) {
            localRollFrameStatuses.add(FrameStatus.STRIKE);
        } else {
            localRollFrameStatuses.add(FrameStatus.NORMAL);

        }
        frames.get(frameNr).roll2 = roll2;
        db.totalScore += roll2;
        if (roll1 + roll2 == 10) {
            localRollFrameStatuses.add(FrameStatus.SPARE);

        } else if (roll2 == 10) {
            localRollFrameStatuses.add(FrameStatus.STRIKE);

        } else {
            localRollFrameStatuses.add(FrameStatus.NORMAL);
        }
        if (FrameCombinations.strike_bonus_for_spare(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_spare(db, frames, frameNr, roll3);
        }
        if (FrameCombinations.strike_strike_bonus_for_strike(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_strike(db, frames, frameNr, roll1, roll2, roll3);
        } else if (FrameCombinations.strike_bonus_for_strike(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_strike(db, frames, frameNr, roll1, roll2, roll3);
        } else if (db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.SPARE && localRollFrameStatuses.get(0) == FrameStatus.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore + roll2 + roll3;
        } else if (FrameCombinations.strike_strike_bonus_for_two_normals_or_single_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_two_normals_or_single_spare(db, frames, frameNr, roll1, roll2, roll3);
        } else if (FrameCombinations.spare_bonus_for_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_spare(db, frames, frameNr, roll2, roll3);
        } else if (FrameCombinations.spare_bonus_for_normal(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_normal(db, frames, frameNr, roll1, roll2);
        } else if (FrameCombinations.bonus_for_normal(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_bonus_for_normal(db, frames, frameNr);
        } else if (FrameCombinations.strike_bonus_for_normal_or_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_normal_or_spare(db, frames, frameNr, roll1, roll2);
        } else if (FrameCombinations.bonus_for_strike(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_bonus_for_strike(db, frames, frameNr, roll2, roll3);
        } else if (FrameCombinations.bonus_for_spare(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_bonus_for_spare(db, frames, frameNr);
        }
    }
}
