package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.*;
import com.tietoEVRY2.bowling.util.console.ConsoleDrawer;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

public class ConsoleBowling {

    public void showFullPlayerTable(String player, List<ScoreBoard> scoreBoardsIncoming) {
        ScoreBoard realPlayer = CheckPlayerExistance.checkExistance(player, scoreBoardsIncoming);
        if (ObjectUtils.equals(realPlayer, null)) {
            return;
        }
        //System.out.format("+-----------------+---------+--------+--------+%n");
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
            System.out.format("| %s          | Roll1   | Roll2  | Roll3  | Total  |%n", "Artjom");
        } else {
            System.out.format("+-----------------+---------+--------+--------+%n");
            System.out.format("| %s          | Roll1   | Roll2  | Total  |%n", "Artjom");
        }
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
        }
        else {
            System.out.format("+-----------------+---------+--------+--------+%n");
        }
        for (int throwsMade = 0; throwsMade < scoreBoardsIncoming
                .get(scoreBoardsIncoming.indexOf(realPlayer))
                .getFrames().size(); throwsMade++) {
            if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
                ConsoleDrawer.drawToConsoleOnLastFrame(realPlayer, throwsMade);
            } else {
                ConsoleDrawer.drawToConsole(realPlayer, throwsMade);

            }
        }
        if (scoreBoardsIncoming.get(scoreBoardsIncoming.indexOf(realPlayer)).getFrameTracker() > 8) {
            System.out.format("+-----------------+---------+--------+--------+--------+%n");
        }
        else {
            System.out.format("+-----------------+---------+--------+--------+%n");
        }
    }
}
