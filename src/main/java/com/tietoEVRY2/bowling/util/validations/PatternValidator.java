package com.tietoEVRY2.bowling.util.validations;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import static com.tietoEVRY2.bowling.util.console.util.ConsoleFrameCombos.*;
import static com.tietoEVRY2.bowling.util.console.util.ConsolePlayerNormal.console_normal_case;
import static com.tietoEVRY2.bowling.util.console.util.ConsolePlayerSpare.console_spare_case;
import static com.tietoEVRY2.bowling.util.console.util.ConsolePlayerStrike.console_strike_case;

public abstract class PatternValidator {
    public static void decideOnPattern(ScoreBoard realPlayer, int throwsMade) {
        if (isStrike(realPlayer, throwsMade)) {
            console_strike_case(realPlayer, throwsMade);

        } else if (isSpare(realPlayer, throwsMade)) {
            console_spare_case(realPlayer, throwsMade);

        } else {
            console_normal_case(realPlayer, throwsMade);
        }
    }
}
