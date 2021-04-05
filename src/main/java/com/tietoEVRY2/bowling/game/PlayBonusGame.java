package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.FrameCombinations;
import com.tietoEVRY2.bowling.util.HandleFrameCombosBonus;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayBonusGame {
    public TABLE_DATABASE db;
    public List<Frames> frames;
    public int frameNr;

    public void playBonusFrame(int roll1, int roll2, int roll3) {
        System.out.println(frameNr);
        List<STATUS> localRollStatus = new ArrayList<>();
        db.totalScore += roll1;
        frames.add(new Frames());
        frames.get(frameNr).roll1 = roll1;
        if (roll1 == 10) {
            localRollStatus.add(STATUS.STRIKE);
        } else {
            localRollStatus.add(STATUS.NORMAL);

        }

        frames.get(frameNr).roll2 = roll2;
        db.totalScore += roll2;
        if (roll1 + roll2 == 10) {
            localRollStatus.add(STATUS.SPARE);

        } else if (roll2 == 10) {
            localRollStatus.add(STATUS.STRIKE);

        } else {
            localRollStatus.add(STATUS.NORMAL);
        }
        if (FrameCombinations.strike_bonus_for_spare(localRollStatus)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_spare(db,frames,frameNr,roll3);
        }

        if (FrameCombinations.strike_strike_bonus_for_strike(localRollStatus,frameNr,db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_strike(db,frames,frameNr,roll1,roll2,roll3);
        }
        else if (FrameCombinations.strike_bonus_for_strike(localRollStatus,frameNr,db)) {
           HandleFrameCombosBonus.handle_strike_bonus_for_strike(db,frames,frameNr,roll1,roll2,roll3);
        }
        else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE && localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore + roll2 + roll3;
        } else if (FrameCombinations.strike_strike_bonus_for_two_normals_or_single_spare(localRollStatus,frameNr,db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_two_normals_or_single_spare(db,frames,frameNr,roll1,roll2,roll3);
        } else if (FrameCombinations.spare_bonus_for_spare(localRollStatus,frameNr,db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_spare(db,frames,frameNr,roll2,roll3);
        } else if (FrameCombinations.spare_bonus_for_normal(localRollStatus,frameNr,db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_normal(db,frames,frameNr,roll1,roll2,roll3);
        } else if (localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.NORMAL &&
                db.gameStatus.get(frameNr - 1) == STATUS.NORMAL) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL || localRollStatus.get(1) == STATUS.SPARE)) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + roll1+roll2;
            frames.get(frameNr).scoreToCount = db.totalScore;
        } else if (localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount + roll2 + roll3;
        } else if (localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.SPARE) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount + 10;
        }
    }
}

