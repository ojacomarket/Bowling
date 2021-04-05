package com.tietoEVRY2.bowling.util.validations;

import com.tietoEVRY2.bowling.exceptions.PlayerNotFoundException;
import com.tietoEVRY2.bowling.game.BowlingGame;
import com.tietoEVRY2.bowling.game.ScoreBoard;

import static com.tietoEVRY2.bowling.util.validations.CheckPlayerExistance.checkExistance;

public abstract class DisplayScoreOrThrowException {
    public static int printCurrentScore(int score, BowlingGame bowling, String forWhom) {
        try {
            ScoreBoard scoreBoard = checkExistance(forWhom, bowling.scoreBoards);
            if (scoreBoard == null) {
                throw new PlayerNotFoundException("There is no such a player --> " + forWhom + " <--");
            }
            score = bowling
                    .scoreBoards
                    .get(bowling.scoreBoards.indexOf(scoreBoard))
                    .getTdb()
                    .totalScore;
        } catch (PlayerNotFoundException pnfe) {
            System.err.println(pnfe.getMessage());
            return -1;
        }
        return score;
    }
}
