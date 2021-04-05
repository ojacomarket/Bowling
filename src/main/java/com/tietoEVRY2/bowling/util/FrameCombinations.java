package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.STATUS;
import com.tietoEVRY2.bowling.game.TABLE_DATABASE;

import java.util.List;

public abstract class FrameCombinations {
    public static boolean strike_strike(int frameTracker, TABLE_DATABASE tdb) {
        return frameTracker > 1 && tdb.gameStatus.get(frameTracker - 2) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE;
    }

    public static boolean strike_spare(int frameTracker, TABLE_DATABASE tdb) {
        return tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker) == STATUS.SPARE;
    }

    public static boolean strike_normal(int frameTracker, TABLE_DATABASE tdb) {
        return tdb.gameStatus.get(frameTracker - 1) == STATUS.STRIKE && tdb.gameStatus.get(frameTracker) == STATUS.NORMAL;
    }

    public static boolean spare_normal(int frameTracker, TABLE_DATABASE tdb) {
        return tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.NORMAL;
    }

    public static boolean spare_strike(int frameTracker, TABLE_DATABASE tdb) {
        return tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.STRIKE;
    }

    public static boolean spare_spare(int frameTracker, TABLE_DATABASE tdb) {
        return tdb.gameStatus.get(frameTracker - 1) == STATUS.SPARE && tdb.gameStatus.get(frameTracker) == STATUS.SPARE;
    }

    public static boolean strike_bonus_for_spare(List<STATUS> localRollStatus) {
        return localRollStatus.get(0) == STATUS.STRIKE || localRollStatus.get(1) == STATUS.SPARE;
    }

    public static boolean strike_strike_bonus_for_strike(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 2) == STATUS.STRIKE && db.gameStatus.get(frameNr - 1) == STATUS.STRIKE &&
                localRollStatus.get(0) == STATUS.STRIKE;
    }

    public static boolean strike_bonus_for_strike(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.STRIKE;
    }

    public static boolean strike_strike_bonus_for_two_normals_or_single_spare(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 2) == STATUS.STRIKE &&
                db.gameStatus.get(frameNr - 1) == STATUS.STRIKE &&
                localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL ||
                        localRollStatus.get(1) == STATUS.SPARE);
    }

    public static boolean spare_bonus_for_spare(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.SPARE;
    }

    public static boolean spare_bonus_for_normal(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 1) == STATUS.SPARE &&
                localRollStatus.get(1) == STATUS.NORMAL;
    }

    public static boolean bonus_for_normal(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.NORMAL &&
                db.gameStatus.get(frameNr - 1) == STATUS.NORMAL;
    }

    public static boolean strike_bonus_for_normal_or_spare(List<STATUS> localRollStatus, int frameNr, TABLE_DATABASE db) {
        return db.gameStatus.get(frameNr - 1) == STATUS.STRIKE && localRollStatus.get(0) == STATUS.NORMAL &&
                (localRollStatus.get(1) == STATUS.NORMAL || localRollStatus.get(1) == STATUS.SPARE);
    }

    public static boolean bonus_for_strike(List<STATUS> localRollStatus) {
        return localRollStatus.get(0) == STATUS.STRIKE;
    }

    public static boolean bonus_for_spare(List<STATUS> localRollStatus) {
        return localRollStatus.get(0) == STATUS.NORMAL && localRollStatus.get(1) == STATUS.SPARE;
    }
}
