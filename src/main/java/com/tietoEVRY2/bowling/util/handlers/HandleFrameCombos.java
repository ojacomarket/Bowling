package com.tietoEVRY2.bowling.util.handlers;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class HandleFrameCombos {
    public static void handle_strike_strike_strike(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb) {
        frames.get(frameTracker - 2).scoreToCount = tdb.totalScore;
        tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + 20;
    }

    public static void handle_strike_strike_spare(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb, int roll2, int roll1) {
        frames.get(frameTracker - 2).scoreToCount = tdb.totalScore - roll2;
        tdb.totalScore = frames.get(frameTracker - 2).scoreToCount + roll1 + roll2 + 10;
    }

    public static void handle_strike_spare(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb) {
        frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
        tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
    }

    public static void handle_strike_normal(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb, int roll1, int roll2) {
        frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
        tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + roll1 + roll2;
        frames.get(frameTracker).scoreToCount = tdb.totalScore;
    }
    public static void handle_spare_normal(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb, int roll1, int roll2) {
        frames.get(frameTracker - 1).scoreToCount = tdb.totalScore - roll2;
        tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + roll1 + roll2;
        frames.get(frameTracker).scoreToCount = tdb.totalScore;
    }
    public static void handle_spare_strike(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb) {
        frames.get(frameTracker - 1).scoreToCount = tdb.totalScore;
        tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
    }
    public static void handle_spare_spare(List<Frames> frames, int frameTracker, TotalScoreDatabase tdb, int roll2) {
        frames.get(frameTracker - 1).scoreToCount = tdb.totalScore - roll2;
        tdb.totalScore = frames.get(frameTracker - 1).scoreToCount + 10;
    }
}
