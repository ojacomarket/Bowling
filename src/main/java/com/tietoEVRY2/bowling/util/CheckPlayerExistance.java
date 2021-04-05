package com.tietoEVRY2.bowling.util;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import java.util.List;

public abstract class CheckPlayerExistance {
    public static ScoreBoard checkExistance (String player, List<ScoreBoard> scoreBoards) {
        return scoreBoards.stream()
                .filter(x -> player.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);
    }
}
