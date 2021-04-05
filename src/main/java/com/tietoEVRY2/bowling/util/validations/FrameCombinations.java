package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class FrameCombinations {
    public static boolean strike_strike(int frameTracker, TotalScoreDatabase tdb) {
        return frameTracker > 1 && tdb.gameFrameStatuses.get(frameTracker - 2) == FrameStatus.STRIKE && tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.STRIKE;
    }

    public static boolean strike_spare(int frameTracker, TotalScoreDatabase tdb) {
        return tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.STRIKE && tdb.gameFrameStatuses.get(frameTracker) == FrameStatus.SPARE;
    }

    public static boolean strike_normal(int frameTracker, TotalScoreDatabase tdb) {
        return tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.STRIKE && tdb.gameFrameStatuses.get(frameTracker) == FrameStatus.NORMAL;
    }

    public static boolean spare_normal(int frameTracker, TotalScoreDatabase tdb) {
        return tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.SPARE && tdb.gameFrameStatuses.get(frameTracker) == FrameStatus.NORMAL;
    }

    public static boolean spare_strike(int frameTracker, TotalScoreDatabase tdb) {
        return tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.SPARE && tdb.gameFrameStatuses.get(frameTracker) == FrameStatus.STRIKE;
    }

    public static boolean spare_spare(int frameTracker, TotalScoreDatabase tdb) {
        return tdb.gameFrameStatuses.get(frameTracker - 1) == FrameStatus.SPARE && tdb.gameFrameStatuses.get(frameTracker) == FrameStatus.SPARE;
    }

    public static boolean strike_bonus_for_spare(List<FrameStatus> localRollFrameStatuses) {
        return localRollFrameStatuses.get(0) == FrameStatus.STRIKE || localRollFrameStatuses.get(1) == FrameStatus.SPARE;
    }

    public static boolean strike_strike_bonus_for_strike(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 2) == FrameStatus.STRIKE && db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.STRIKE &&
                localRollFrameStatuses.get(0) == FrameStatus.STRIKE;
    }

    public static boolean strike_bonus_for_strike(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.STRIKE && localRollFrameStatuses.get(0) == FrameStatus.STRIKE;
    }

    public static boolean strike_strike_bonus_for_two_normals_or_single_spare(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 2) == FrameStatus.STRIKE &&
                db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.STRIKE &&
                localRollFrameStatuses.get(0) == FrameStatus.NORMAL &&
                (localRollFrameStatuses.get(1) == FrameStatus.NORMAL ||
                        localRollFrameStatuses.get(1) == FrameStatus.SPARE);
    }

    public static boolean spare_bonus_for_spare(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.SPARE &&
                localRollFrameStatuses.get(1) == FrameStatus.SPARE;
    }

    public static boolean spare_bonus_for_normal(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.SPARE &&
                localRollFrameStatuses.get(1) == FrameStatus.NORMAL;
    }

    public static boolean spare_bonus_strike(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.SPARE && localRollFrameStatuses.get(0) == FrameStatus.STRIKE;
    }

    public static boolean bonus_for_normal(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return localRollFrameStatuses.get(0) == FrameStatus.NORMAL && localRollFrameStatuses.get(1) == FrameStatus.NORMAL &&
                db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.NORMAL;
    }

    public static boolean strike_bonus_for_normal_or_spare(List<FrameStatus> localRollFrameStatuses, int frameNr, TotalScoreDatabase db) {
        return db.gameFrameStatuses.get(frameNr - 1) == FrameStatus.STRIKE && localRollFrameStatuses.get(0) == FrameStatus.NORMAL &&
                (localRollFrameStatuses.get(1) == FrameStatus.NORMAL || localRollFrameStatuses.get(1) == FrameStatus.SPARE);
    }

    public static boolean bonus_for_strike(List<FrameStatus> localRollFrameStatuses) {
        return localRollFrameStatuses.get(0) == FrameStatus.STRIKE;
    }

    public static boolean bonus_for_spare(List<FrameStatus> localRollFrameStatuses) {
        return localRollFrameStatuses.get(0) == FrameStatus.NORMAL && localRollFrameStatuses.get(1) == FrameStatus.SPARE;
    }
}
