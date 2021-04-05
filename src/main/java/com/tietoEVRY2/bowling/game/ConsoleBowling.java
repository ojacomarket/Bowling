package com.tietoEVRY2.bowling.game;

import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static com.tietoEVRY2.bowling.util.CheckPlayerExistance.checkExistance;
import static com.tietoEVRY2.bowling.util.console.ConsoleDrawer.*;

public class ConsoleBowling {

    public void showFullPlayerTable(String player, List<ScoreBoard> scoreBoardsIncoming) {
        ScoreBoard realPlayer = checkExistance(player, scoreBoardsIncoming);
        if (ObjectUtils.equals(realPlayer, null)) {
            return;
        }

        customizeHeaderAndColumns(scoreBoardsIncoming, realPlayer);

        customizeBody(scoreBoardsIncoming, realPlayer);

        customizeFooter(scoreBoardsIncoming, realPlayer);
    }
}
