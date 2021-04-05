package com.tietoEVRY2.bowling.util.console;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import java.util.List;

import static com.tietoEVRY2.bowling.util.console.util.ConsoleFrameCombos.*;
import static com.tietoEVRY2.bowling.util.console.util.ConsoleFrameCombosHandler.*;
import static com.tietoEVRY2.bowling.util.validations.PatternValidator.decideOnPattern;

public abstract class ConsoleDrawer {
    public static void drawToConsole(ScoreBoard realPlayer, int throwsMade) {
        decideOnPattern(realPlayer, throwsMade);
    }

    public static void drawToConsoleOnLastFrame(ScoreBoard realPlayer, int throwsMade) {
        if (isNotRoll3(realPlayer, throwsMade)) {
            console_not_roll3_handler(realPlayer, throwsMade);
        } else {
            console_roll3_handler(realPlayer, throwsMade);
        }
    }

    public static void customizeHeaderAndColumns(List<ScoreBoard> scoreBoardsIncoming, ScoreBoard realPlayer) {
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
            System.out.format("| %s          | Roll1   | Roll2  | Roll3  | Total  |%n", "Artjom");
        } else {
            System.out.format("+-----------------+---------+--------+--------+%n");
            System.out.format("| %s          | Roll1   | Roll2  | Total  |%n", "Artjom");
        }
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
        } else {
            System.out.format("+-----------------+---------+--------+--------+%n");
        }
    }

    public static void customizeBody(List<ScoreBoard> scoreBoardsIncoming, ScoreBoard realPlayer) {
        for (int throwsMade = 0; throwsMade < scoreBoardsIncoming
                .get(scoreBoardsIncoming.indexOf(realPlayer))
                .getFrames().size(); throwsMade++) {
            if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
                drawToConsoleOnLastFrame(realPlayer, throwsMade);
            } else {
                drawToConsole(realPlayer, throwsMade);
            }
        }
    }

    public static void customizeFooter(List<ScoreBoard> scoreBoardsIncoming, ScoreBoard realPlayer) {
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
        } else {
            System.out.format("+-----------------+---------+--------+--------+%n");
        }
    }
}
