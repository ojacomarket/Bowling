package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.FrameScoreOutOfBoundariesException;
import com.tietoEVRY2.bowling.util.*;
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
        Frames frameStart = new Frames();

        frameStart.roll1 = roll1;
        if (roll1 == 10) {
            HandleStrike.handle_strike(tdb, frameStart, roll2, frames);
            if (FrameCombinations.strike_strike(frameTracker, tdb)) {
                HandleFrameCombos.handle_strike_strike_strike(frames, frameTracker, tdb);
            }
            }

        else {
            if (roll1 + roll2 == 10) {
                HandleSpare.handle_spare(tdb,frameStart,roll2,frames);
                if (FrameCombinations.strike_strike(frameTracker, tdb)) {
                    HandleFrameCombos.handle_strike_strike_spare(frames,frameTracker,tdb,roll2,roll1);
                }
            } else {
                HandleNormal.handle_normal(tdb,frameStart,roll1,roll2,frames);
                if (FrameCombinations.strike_strike(frameTracker, tdb)) {
                    HandleFrameCombos.handle_strike_strike_spare(frames, frameTracker,tdb, roll2, roll1);
                }
            }
        }

        if (frameTracker >= 1) {
                if (FrameCombinations.strike_spare(frameTracker,tdb)) {
                    HandleFrameCombos.handle_strike_spare(frames,frameTracker,tdb);
                } else if (FrameCombinations.strike_normal(frameTracker,tdb)) {
                    HandleFrameCombos.handle_strike_normal(frames,frameTracker,tdb,roll1,roll2);
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
                }
            }
        currentScores.add(tdb);

    }
}

