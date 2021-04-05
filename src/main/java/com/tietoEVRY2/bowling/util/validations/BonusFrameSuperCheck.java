package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.FrameStatus;
import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;

import java.util.List;

public abstract class BonusFrameSuperCheck {
    public static void superCheck(List<FrameStatus> localRollFrameStatuses, TotalScoreDatabase db, List<Frames>
            frames, int frameNr, int roll1, int roll2, int roll3) {
        if (FrameCombinations.strike_bonus_for_spare(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_spare(db, frames, frameNr, roll3);
        }
        if (FrameCombinations.strike_strike_bonus_for_strike(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_strike(db, frames, frameNr, roll1, roll2, roll3);

        } else if (FrameCombinations.strike_bonus_for_strike(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_strike(db, frames, frameNr, roll1, roll2, roll3);

        } else if (FrameCombinations.spare_bonus_strike(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_strike(db, frames, frameNr, roll2, roll3);

        } else if (FrameCombinations.strike_strike_bonus_for_two_normals_or_single_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_strike_bonus_for_two_normals_or_single_spare(db, frames, frameNr, roll1, roll2, roll3);

        } else if (FrameCombinations.spare_bonus_for_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_spare(db, frames, frameNr, roll2, roll3);

        } else if (FrameCombinations.spare_bonus_for_normal(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_spare_bonus_for_normal(db, frames, frameNr, roll1, roll2);

        } else if (FrameCombinations.bonus_for_normal(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_bonus_for_normal(db, frames, frameNr);

        } else if (FrameCombinations.strike_bonus_for_normal_or_spare(localRollFrameStatuses, frameNr, db)) {
            HandleFrameCombosBonus.handle_strike_bonus_for_normal_or_spare(db, frames, frameNr, roll1, roll2, roll3);

        } else if (FrameCombinations.bonus_for_strike(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_bonus_for_strike(db, frames, frameNr, roll2, roll3);

        } else if (FrameCombinations.bonus_for_spare(localRollFrameStatuses)) {
            HandleFrameCombosBonus.handle_bonus_for_spare(db, frames, frameNr);
        }
    }
}
