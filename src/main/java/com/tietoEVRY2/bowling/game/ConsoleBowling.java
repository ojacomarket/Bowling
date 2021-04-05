package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.CheckPlayerExistance;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

public class ConsoleBowling {

    public void showFullPlayerTable(String player, List<ScoreBoard> scoreBoardsIncoming) {
        ScoreBoard realPlayer = CheckPlayerExistance.checkExistance(player, scoreBoardsIncoming);
        if (ObjectUtils.equals(realPlayer, null)) {
            return;
        }
        List<ScoreBoard> scoreBoards = scoreBoardsIncoming;
        String playerFullTableConsole = "| %-15s | %-7d | %-7d| %-7d| %n";
        String playerFullTableConsole2 = "| %-15s | %-7s | %-7s| %-7d| %n";
        String playerFullTableConsole3 = "| %-15s | %-7d | %-7s| %-7d| %n";
        String playerFullTableConsole4 = "| %-15s | %-7d | %-7s| %-7s| %n";
        String playerFullTableConsole5 = "| %-15s | %-7s | %-7s| %-7s| %n";
        String bonus = "| %-15s | %-7s | %-7s| %-7s| %-7s| %n";

        System.out.format("+-----------------+---------+--------+--------+%n");
        if (scoreBoardsIncoming.get(0).getFrameTracker() > 7) {
            System.out.format("| %s          | Roll1   | Roll2  | Roll3  | Total  |%n", "Artjom");
        } else {
            System.out.format("| %s          | Roll1   | Roll2  | Total  |%n", "Artjom");
        }
        System.out.format("+-----------------+---------+--------+--------+%n");
        /*ScoreBoard sample = scoreBoards.stream()
                .filter(x -> player.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);*/
            for (int throwsMade = 0; throwsMade < scoreBoards
                    .get(scoreBoards.indexOf(realPlayer))
                    .getFrames().size(); throwsMade++) {
                if (realPlayer.getFrames().get(throwsMade).roll1 == 10) {
                    if (realPlayer.getFrames().get(throwsMade).scoreToCount == 0) {
                        System.out.format(playerFullTableConsole5, "Frame nr " + throwsMade, "X",
                                " ", " ");
                    } else {
                        System.out.format(playerFullTableConsole2, "Frame nr " + throwsMade, "X",
                                " ", realPlayer.getFrames().get(throwsMade).scoreToCount);
                    }
                }
                else if (realPlayer.getFrames().get(throwsMade).roll1 + realPlayer.getFrames().get(throwsMade).roll2 == 10){
                    if (realPlayer.getFrames().get(throwsMade).scoreToCount == 0) {
                        System.out.format(playerFullTableConsole4, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                                "/", " ");
                    } else {
                        System.out.format(playerFullTableConsole3, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                                "/", realPlayer.getFrames().get(throwsMade).scoreToCount);
                    }
                }
                else {
                    System.out.format(playerFullTableConsole, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                            realPlayer.getFrames().get(throwsMade).roll2, realPlayer.getFrames().get(throwsMade).scoreToCount);
                }
                }
            System.out.format("+-----------------+---------+--------+--------+%n");
    }
}
