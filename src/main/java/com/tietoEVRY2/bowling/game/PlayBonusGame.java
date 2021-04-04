package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.ThrowBonus;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayBonusGame {
    public TABLE_DATABASE db;
    public List<Frames> frames;
    public int frameNr;//9
   // public Frames incoming;
    //int rollsCount;

    public void playBonusGame(int roll1, int roll2, int roll3) {
        List<STATUS> localRollStatus = new ArrayList<>();
        //Frames frameStart = new Frames();
       /* int roll1;
        int roll2;
        int roll3 = 0;*/
        //int rollsCount = 0;


        //roll1 = Throwing_BALL.throwBall(1, 0);
        //roll1 = ThrowBonus.throwBonus(-1);
        db.totalScore += roll1;
        //rollsCount++;
        frames.get(frameNr).roll1 = roll1;
        //incoming.roll1 = roll1;
        //frames.get(frameNr).roll1 = roll1;


        if (roll1 == 10) {
            localRollStatus.add(STATUS.STRIKE);
            //db.gameStatus.add(STATUS.STRIKE);
            //roll2 = 0;
            //frameStart.roll2 = 0;
            //db.totalScore += 10;
            //incoming.scoreToCount = 0;
            //frames.add(frameNr, frameStart);
            //frameNr++;

        }
        else {
            localRollStatus.add(STATUS.NORMAL);
           // db.totalScore += roll1;
        }
        //roll2 = ThrowBonus.throwBonus(roll1);
        frames.get(frameNr).roll2 = roll2;
        db.totalScore += roll2;
        //frames.get(frameNr).roll2 = roll2;
        //rollsCount++;


        if (roll1 + roll2 == 10) {
            localRollStatus.add(STATUS.SPARE);
            //db.gameStatus.add(STATUS.SPARE);
            /*incoming.roll2 = roll2;*/
            //db.totalScore += 10;
            //frameStart.scoreToCount = totalScore.total; //10 always
            //incoming.scoreToCount = 0;
            //frames.add(frameStart);

        } else if (roll1 == 10) {
            localRollStatus.add(STATUS.STRIKE);
            //db.gameStatus.add(STATUS.STRIKE);
            //roll2 = 0;
            //frameStart.roll2 = 0;
            //db.totalScore += 10;
            //incoming.scoreToCount = 0;
            //frames.add(frameNr, frameStart);
            //frameNr++;

        } else {
            localRollStatus.add(STATUS.NORMAL);
            //db.gameStatus.add(STATUS.NORMAL);
            //incoming.roll2 = incoming.roll2;
            //db.totalScore += roll1 + roll2;
            //incoming.scoreToCount = db.totalScore;
            //frames.add(incoming);

            //return;
        }
        if (localRollStatus.get(0) == STATUS.STRIKE || localRollStatus.get(1) == STATUS.SPARE) {
            if (localRollStatus.get(1) == STATUS.STRIKE) {
                roll3 = ThrowBonus.throwBonus(-1);
                db.totalScore += roll3;
            }
            //else if (localRollStatus.get(1) == STATUS.SPARE) {
            else {
                roll3 = ThrowBonus.throwBonus(roll2);
                db.totalScore += roll3;
            }
            frames.get(frameNr).roll3 = roll3;
        }

        if (db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2 + roll3;
            //frames.add(frameStart);
            //frames.get(frameNr).roll1 = roll1;
            //frames.get(frameNr).roll2 = roll2;
            //frames.get(frameNr).roll3 = roll3;
        } else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE && localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2 + roll3;
        }
        else if (db.gameStatus.get(frameNr - 2) == STATUS.STRIKE &&
                db.gameStatus.get(frameNr - 1) == STATUS.STRIKE &&
                localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL ||
                localRollStatus.get(1) == STATUS.SPARE)) {
            frames.get(frameNr - 2).scoreToCount = db.totalScore - roll2;
            db.totalScore = frames.get(frameNr - 2).scoreToCount;
            frames.get(frameNr - 1).scoreToCount = db.totalScore + roll1 + roll2;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
        else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.SPARE) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2 + roll3;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
        else if (db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.NORMAL) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2;
            db.totalScore = frames.get(frameNr - 1).scoreToCount;
            frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
        else if (localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.NORMAL &&
        db.gameStatus.get(frameNr - 1) == STATUS.NORMAL) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
        else if (db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL || localRollStatus.get(1) == STATUS.SPARE)) {
            frames.get(frameNr - 1).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr-1).scoreToCount + roll1 + roll2;
            frames.get(frameNr).scoreToCount = db.totalScore;
        }
        else if (localRollStatus.get(0) == STATUS.STRIKE) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
        else if (localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.SPARE) {
            frames.get(frameNr).scoreToCount = db.totalScore;
            db.totalScore = frames.get(frameNr).scoreToCount;
        }
    }

}

