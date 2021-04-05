package com.tietoEVRY2.bowling.util.console;

import com.tietoEVRY2.bowling.game.ScoreBoard;
import com.tietoEVRY2.bowling.util.console.util.ConsoleFrameCombos;
import com.tietoEVRY2.bowling.util.console.util.ConsoleFrameCombosHandler;

import static com.tietoEVRY2.bowling.util.console.ConsoleOutputConfig.*;

public abstract class ConsoleDrawer {
    public static void drawToConsole(ScoreBoard realPlayer, int throwsMade) {
        if (ConsoleFrameCombos.isStrike(realPlayer, throwsMade)) {
            ConsolePlayerStrike.console_strike_case(realPlayer, throwsMade);
        } else if (ConsoleFrameCombos.isSpare(realPlayer, throwsMade)) {
            ConsolePlayerSpare.console_spare_case(realPlayer, throwsMade);
        } else {
            ConsolePlayerNormal.console_normal_case(realPlayer, throwsMade);
        }
    }

    public static void drawToConsoleOnLastFrame(ScoreBoard realPlayer, int throwsMade) {
        if (ConsoleFrameCombos.isNotRoll3(realPlayer, throwsMade)) {
            ConsoleFrameCombosHandler.console_roll3_handler(realPlayer, throwsMade);
        } else {
            ConsoleFrameCombosHandler.console_roll3_handler(realPlayer, throwsMade);
        }
    }
}
