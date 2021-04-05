package com.tietoEVRY2.bowling.util.validations;

import com.tietoEVRY2.bowling.exceptions.WrongNameOrPinsException;
import com.tietoEVRY2.bowling.game.PlayBonusGame;
import com.tietoEVRY2.bowling.game.ScoreBoard;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class CheckPlayerExistance {
    public static ScoreBoard checkExistance(String player, List<ScoreBoard> scoreBoards) {
        return scoreBoards.stream()
                .filter(x -> player.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);
    }

    public static boolean isValidPlayer(int roll1, int roll2, String whoIsThrowing, List<String> playerNames) {
        return roll1 < 10 && roll1 + roll2 > 10 || StringUtils.isEmpty(whoIsThrowing) || playerNames.stream().noneMatch(x -> x.equals(whoIsThrowing));
    }

    public static void checkPlayerValidity(int roll1, int roll2, String whoIsThrowing, List<String> playerNames, List<ScoreBoard> scoreBoards) {
        if (isValidPlayer(roll1, roll2, whoIsThrowing, playerNames)) {
            throw new WrongNameOrPinsException("You have only 10 pins and unregistered players cannot play!");
        }
        try {
            ScoreBoard createScoreBoard = checkExistance(whoIsThrowing, scoreBoards);
            scoreBoards
                    .get(scoreBoards.indexOf(createScoreBoard))
                    .playFrame(roll1, roll2);
        } catch (WrongNameOrPinsException wnope) {
            System.out.println(wnope.getMessage());
        }
    }

    public static void checkPlayerValidityBonus(int roll1, int roll2,int roll3, String whoIsThrowing, List<String> playerNames,
                                           List<ScoreBoard> scoreBoards) {
        if (CheckPlayerExistance.isValidPlayer(roll1, roll2, whoIsThrowing, playerNames)) {
            throw new WrongNameOrPinsException("You have only 10 pins and unregistered players cannot play!");
        }
        try {
            ScoreBoard createScoreBoard = checkExistance(whoIsThrowing, scoreBoards);
            scoreBoards
                    .get(0)
                    .setFrameTracker(scoreBoards.get(0).getFrameTracker() + 1);
            PlayBonusGame playBonusFrame = new PlayBonusGame(
                    scoreBoards.get(0).getTdb(),
                    scoreBoards.get(scoreBoards.indexOf(createScoreBoard)).getFrames(),
                    scoreBoards.get(0).getFrameTracker());
            playBonusFrame.playBonusFrame(roll1, roll2, roll3);
        } catch (WrongNameOrPinsException wnope) {
            System.out.println(wnope.getMessage());
        }
    }
}
