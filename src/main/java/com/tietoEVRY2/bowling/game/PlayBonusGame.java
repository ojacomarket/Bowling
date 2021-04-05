package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.ThrowBonus;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayBonusGame {
    public TABLE_DATABASE db;
    public List<Frames> frames;
    public int frameNr;

    public void playBonusGame(int roll1, int roll2, int roll3) {
        List<STATUS> localRollStatus = new ArrayList<>();
        db.totalScore += roll1;
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
        if (localRollStatus.get(0) == STATUS.STRIKE || localRollStatus.get(1) == STATUS.SPARE) {
            /*if (localRollStatus.get(1) == STATUS.STRIKE) {
                db.totalScore += roll3;
            } else {*/
                db.totalScore += roll3;
            //}
            frames.get(frameNr).roll3 = roll3;
        }

        if (db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore + roll2 + roll3;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE && localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore + roll2 + roll3;
        } else if (db.gameStatus.get(frameNr - 2) == STATUS.STRIKE &&
                db.gameStatus.get(frameNr - 1) == STATUS.STRIKE &&
                localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL ||
                        localRollStatus.get(1) == STATUS.SPARE)) {
            frames.get(frameNr - 2).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 2).scoreToCount + 10;
            frames.get(frameNr - 1).scoreToCount = db.totalScore + roll1 + roll2;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2;
            db.totalScore = frames.get(frameNr).scoreToCount;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.SPARE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore + roll3;
            db.totalScore = frames.get(frameNr).scoreToCount;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.NORMAL) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        } else if (localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.NORMAL &&
                db.gameStatus.get(frameNr - 1) == STATUS.NORMAL) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL || localRollStatus.get(1) == STATUS.SPARE)) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
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

