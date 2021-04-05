package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class HandleFrameCombosBonus {
    public static void handle_strike_bonus_for_spare(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll3) {
        db.totalScore += roll3;
        frames.get(frameNr).roll3 = roll3;
    }

    public static void handle_strike_strike_bonus_for_strike(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll1, int roll2, int roll3) {
        frames.get(frameNr - 2).scoreToCount = db.totalScore - roll3 - roll2;
        db.totalScore = frames.get(frameNr - 2).scoreToCount + roll1 + 10 + roll2 + roll3;
        frames.get(frameNr - 1).scoreToCount = db.totalScore - roll3;
        db.totalScore = frames.get(frameNr - 1).scoreToCount + roll1 + roll2 + roll3;
        frames.get(frameNr).scoreToCount = db.totalScore;
    }

    public static void handle_strike_bonus_for_strike(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll1, int roll2, int roll3) {
        frames.get(frameNr - 1).scoreToCount = db.totalScore - roll3;
        db.totalScore = frames.get(frameNr - 1).scoreToCount + roll1 + roll2;
        frames.get(frameNr).scoreToCount = db.totalScore + roll3;
    }

    public static void handle_strike_strike_bonus_for_two_normals_or_single_spare(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll1, int roll2, int roll3) {
        frames.get(frameNr - 2).scoreToCount = db.totalScore - roll2 - roll3;
        db.totalScore = frames.get(frameNr - 2).scoreToCount + 10;
        frames.get(frameNr - 1).scoreToCount = db.totalScore + roll1 + roll2;
        db.totalScore = frames.get(frameNr - 1).scoreToCount;
        frames.get(frameNr).scoreToCount = db.totalScore + roll1 + roll2;
        db.totalScore = frames.get(frameNr).scoreToCount;
    }

    public static void handle_spare_bonus_for_spare(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll2, int roll3) {
        frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2 - roll3;
        db.totalScore = frames.get(frameNr - 1).scoreToCount + 10;
        frames.get(frameNr).scoreToCount = db.totalScore + roll3;
        db.totalScore = frames.get(frameNr).scoreToCount;
    }

    public static void handle_spare_bonus_for_normal(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll1, int roll2) {
        frames.get(frameNr - 1).scoreToCount = db.totalScore - roll2;
        db.totalScore = frames.get(frameNr - 1).scoreToCount + roll1 + roll2;
        frames.get(frameNr).scoreToCount = db.totalScore;
        db.totalScore = frames.get(frameNr).scoreToCount;
    }

    public static void handle_bonus_for_normal(TABLE_DATABASE db, List<Frames> frames, int frameNr) {
        frames.get(frameNr).scoreToCount = db.totalScore;
        db.totalScore = frames.get(frameNr).scoreToCount;
    }

    public static void handle_strike_bonus_for_normal_or_spare(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll1, int roll2) {
        frames.get(frameNr - 1).scoreToCount = db.totalScore;
        db.totalScore = frames.get(frameNr - 1).scoreToCount + roll1 + roll2;
        frames.get(frameNr).scoreToCount = db.totalScore;
    }

    public static void handle_bonus_for_strike(TABLE_DATABASE db, List<Frames> frames, int frameNr, int roll2, int roll3) {
        frames.get(frameNr).scoreToCount = db.totalScore;
        db.totalScore = frames.get(frameNr).scoreToCount + roll2 + roll3;
    }

    public static void handle_bonus_for_spare(TABLE_DATABASE db, List<Frames> frames, int frameNr) {
        frames.get(frameNr).scoreToCount = db.totalScore;
        db.totalScore = frames.get(frameNr).scoreToCount + 10;
    }
}
