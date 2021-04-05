package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.CheckPlayerExistance;
import com.tietoEVRY2.bowling.util.ConsoleOutputConfig;
import com.tietoEVRY2.bowling.util.ConsolePlayerStrike;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static com.tietoEVRY2.bowling.util.ConsoleOutputConfig.*;

public class ConsoleBowling {

    public void showFullPlayerTable(String player, List<ScoreBoard> scoreBoardsIncoming) {
        ScoreBoard realPlayer = CheckPlayerExistance.checkExistance(player, scoreBoardsIncoming);
        if (ObjectUtils.equals(realPlayer, null)) {
            return;
        }
        /*String normal_table_setup = "| %-15s | %-7d | %-7d| %-7d| %n";
        String playerFullTableConsole2 = "| %-15s | %-7s | %-7s| %-7d| %n";
        String playerFullTableConsole3 = "| %-15s | %-7d | %-7s| %-7d| %n";
        String playerFullTableConsole4 = "| %-15s | %-7d | %-7s| %-7s| %n";
        String playerFullTableConsole5 = "| %-15s | %-7s | %-7s| %-7s| %n";
        String bonus = "| %-15s | %-7s | %-7s| %-7s| %-7s| %n";*/

        System.out.format("+-----------------+---------+--------+--------+%n");
        if (scoreBoardsIncoming.get(0).getFrameTracker() > 7) {
            System.out.format("| %s          | Roll1   | Roll2  | Roll3  | Total  |%n", "Artjom");
        } else {
            System.out.format("| %s          | Roll1   | Roll2  | Total  |%n", "Artjom");
        }
        System.out.format("+-----------------+---------+--------+--------+%n");

            for (int throwsMade = 0; throwsMade < scoreBoardsIncoming
                    .get(scoreBoardsIncoming.indexOf(realPlayer))
                    .getFrames().size(); throwsMade++) {
                if (realPlayer.getFrames().get(throwsMade).roll1 == 10) {
                    ConsolePlayerStrike.console_strike_case(realPlayer,throwsMade,STRIKES_TABLE_SCORE,STRIKES_TABLE);
                }
                else if (realPlayer.getFrames().get(throwsMade).roll1 + realPlayer.getFrames().get(throwsMade).roll2 == 10){
                    if (realPlayer.getFrames().get(throwsMade).scoreToCount == 0) {
                        System.out.format(SPARE_TABLE_SCORE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                                "/", " ");
                    } else {
                        System.out.format(SPARE_TABLE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                                "/", realPlayer.getFrames().get(throwsMade).scoreToCount);
                    }
                }
                else {
                    System.out.format(ConsoleOutputConfig.NORMAL_TABLE, "Frame nr " + throwsMade, realPlayer.getFrames().get(throwsMade).roll1,
                            realPlayer.getFrames().get(throwsMade).roll2, realPlayer.getFrames().get(throwsMade).scoreToCount);
                }
                }
            System.out.format("+-----------------+---------+--------+--------+%n");
    }
}
