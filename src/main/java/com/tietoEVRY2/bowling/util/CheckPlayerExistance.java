package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.ScoreBoard;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class CheckPlayerExistance {
    public static ScoreBoard checkExistance (String player, List<ScoreBoard> scoreBoards) {
        return scoreBoards.stream()
                .filter(x -> player.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);
    }
    public static boolean isValidPlayer (int roll1, int roll2, String whoIsThrowing, List<String> playerNames){
       return roll1 < 10 && roll1 + roll2 > 10 || StringUtils.isEmpty(whoIsThrowing) || playerNames.stream().noneMatch(x -> x.equals(whoIsThrowing));
    }
}
