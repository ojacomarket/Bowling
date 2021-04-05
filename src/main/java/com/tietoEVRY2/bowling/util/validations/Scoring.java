package com.tietoEVRY2.bowling.util.validations;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

import static com.tietoEVRY2.bowling.util.validations.FrameCombinations.*;
import static com.tietoEVRY2.bowling.util.validations.FrameCombinations.spare_spare;
import static com.tietoEVRY2.bowling.util.handlers.HandleFrameCombos.*;
import static com.tietoEVRY2.bowling.util.handlers.HandleNormal.handle_normal;
import static com.tietoEVRY2.bowling.util.handlers.HandleSpare.handle_spare;
import static com.tietoEVRY2.bowling.util.handlers.HandleStrike.handle_strike;

public abstract class Scoring {
    public static void assessSingularFrame(int roll1,
                                           int roll2,
                                           TotalScoreDatabase tdb,
                                           Frames frameStart,
                                           int frameTracker,
                                           List<Frames> frames) {
        if (roll1 == 10) {
            handle_strike(tdb, frameStart, roll2, frames);
            if (strike_strike(frameTracker, tdb)) {
                handle_strike_strike_strike(frames, frameTracker, tdb);
            }
        } else {
            if (roll1 + roll2 == 10) {
                handle_spare(tdb, frameStart, roll2, frames);
                if (strike_strike(frameTracker, tdb)) {
                    handle_strike_strike_spare(frames, frameTracker, tdb, roll2, roll1);
                }
            } else {
                handle_normal(tdb, frameStart, roll1, roll2, frames);
                if (strike_strike(frameTracker, tdb)) {
                    handle_strike_strike_spare(frames, frameTracker, tdb, roll2, roll1);
                }
            }
        }
    }

    public static void predictCalculations(int roll1,
                                           int roll2,
                                           TotalScoreDatabase tdb,
                                           int frameTracker,
                                           List<Frames> frames) {
        if (frameTracker >= 1) {
            if (strike_spare(frameTracker, tdb)) {
                handle_strike_spare(frames, frameTracker, tdb);

            } else if (strike_normal(frameTracker, tdb)) {
                handle_strike_normal(frames, frameTracker, tdb, roll1, roll2);

            } else if (spare_normal(frameTracker, tdb)) {
                handle_spare_normal(frames, frameTracker, tdb, roll1, roll2);

            } else if (spare_strike(frameTracker, tdb)) {
                handle_spare_strike(frames, frameTracker, tdb);

            } else if (spare_spare(frameTracker, tdb)) {
                handle_spare_spare(frames, frameTracker, tdb, roll2);
            }
        }
    }
}
