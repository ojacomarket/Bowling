package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.FrameScoreOutOfBoundariesException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ScoreBoard {
    @NonNull
    private String playerName;
    private List<Frames> frames;
    private int frameTracker = -1;
    private List<TABLE_DATABASE> currentScores;
    private TABLE_DATABASE tdb;

    public void playBowling(int roll1, int roll2) throws FrameScoreOutOfBoundariesException {
        if (frameTracker == -1) {
            tdb = new TABLE_DATABASE(new ArrayList<>(), 0);
            frames = new ArrayList<>();
            currentScores = new ArrayList<>();
        }
        frameTracker++;
        if (frameTracker > 9) {
            return;
        }
        if (roll1 + roll2 > 10) {
            throw new FrameScoreOutOfBoundariesException();
        }
        //tdb.rollsInFrame = new ArrayList<>();
        //tdb.gameStatus = new ArrayList<>();
        //TOTAL_ScORE totalScore = new TOTAL_ScORE();
        //totalScore.total = 0;
        //for (int frame = 0; frame < 10; frame++) {
        Frames frameStart = new Frames();
       /* if (frameTracker > 1) {
            if (tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE) {
                if (frameTracker - 2 == 0) {
                    frames.get(frameTracker - 2).scoreToCount = tdb.totalScore + roll1;
                    tdb.totalScore += frames.get(frameTracker - 2).scoreToCount;
                } else {
                    frames.get(frameTracker - 2).scoreToCount = tdb.totalScore;
                    tdb.totalScore += frames.get(frameTracker - 2).scoreToCount;
                    //frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
                    // frames.get(frameTracker - 1).scoreToCount = tdb.totalScore + ;
                }
            }
        }*/
           /* if (frameTracker > 8) {
                System.out.println("IM HERE!"); //proceeded
                frames.add(frameStart);
                PlayBonusGame bonusFrame = new PlayBonusGame(tdb,frames, frameTracker);
                bonusFrame.playBonusGame(roll1, roll2, roll3);
                //ConsoleBowling start = new ConsoleBowling(playerName, frames);
                //start.playBowlingInConsole();
                return;
            }*/
        frameStart.roll1 = roll1;
        if (roll1 == 10) {
            tdb.gameStatus.add(STATUS.STRIKE);
            roll2 = 0;
            frameStart.scoreToCount = 0;
            frames.add(frameStart);
            tdb.totalScore += 10;
            if (frameTracker > 1 && tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker-1) == STATUS.STRIKE) {
                frames.get(frameTracker - 2).scoreToCount = tdb.totalScore;
                tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + 20;
            }
            }

        else {
            if (roll1 + roll2 == 10) {
                tdb.gameStatus.add(STATUS.SPARE);
                frameStart.roll2 = roll2;
                tdb.totalScore += 10;
                frameStart.scoreToCount = 0;
                frames.add(frameStart);
                if (frameTracker > 1 && tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker-1) == STATUS.STRIKE) {
                    frames.get(frameTracker - 2).scoreToCount = tdb.totalScore - roll2;
                    tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + roll1 + roll2 + 10;
                }
            } else {
                tdb.gameStatus.add(STATUS.NORMAL);
                frameStart.roll2 = roll2;
                tdb.totalScore += roll1 + roll2;
                frameStart.scoreToCount = tdb.totalScore;
                System.out.println(tdb.totalScore + "TOTAL");
                frames.add(frameStart);
                if (frameTracker > 1 && tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker-1) == STATUS.STRIKE) {
                    frames.get(frameTracker - 2).scoreToCount = tdb.totalScore - roll2;
                    tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + roll1 + roll2 + 10;
                }
            }
        }

        if (frameTracker >= 1) {
                if (tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker) == STATUS.SPARE) {
                    frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
                    tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
                } else if (tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker) == STATUS.NORMAL) {
                    frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
                    tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + roll1 + roll2;
                    frames.get(frameTracker).scoreToCount = tdb.totalScore;
                    //totalScore.total += roll1 +roll2 + 10;
                } else if (tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.NORMAL) {
                    frames.get(frameTracker - 1).scoreToCount = tdb.totalScore - roll2;
                    tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + roll1 + roll2;
                    frames.get(frameTracker).scoreToCount = tdb.totalScore;
                    //totalScore.total += roll1 + 10;
                } else if (tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.STRIKE) {
                    frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
                    tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
                    //totalScore.total += 20;
                } else if (tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.SPARE) {
                    frames.get(frameTracker - 1).scoreToCount = tdb.totalScore - roll2;
                    tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
                    //frames.get(frame).scoreToCount = frames.get(frame - 1).scoreToCount + roll1;
                    //totalScore.total += 20;
                }
            }

        currentScores.add(tdb);
        System.out.println("And here twice!");

    }
}

