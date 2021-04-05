package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.util.validations.DisplayScoreOrThrowException;

import java.util.*;

import static com.tietoEVRY2.bowling.util.validations.CheckPlayerExistance.*;

public class BowlingGame {
    public static GameStatus status;
    public List<String> playerNames;
    public List<ScoreBoard> scoreBoards;

    public void init(String... names) {
        if (status == GameStatus.FINISH) {
            reset();
        }
        status = GameStatus.START;
        playerNames = new ArrayList<>();
        scoreBoards = new ArrayList<>();
        playerNames.addAll(Arrays.asList(names));
        playerNames.forEach(x -> scoreBoards.add(new ScoreBoard(x)));
        status = GameStatus.FINISH;
    }

    public void throwBall(int roll1, int roll2, String whoIsThrowing) {
        checkPlayerValidity(roll1, roll2, whoIsThrowing, playerNames, scoreBoards);
    }

    public void throwBall(int roll1, int roll2, int roll3, String whoIsThrowing) {
        checkPlayerValidityBonus(roll1, roll2, roll3, whoIsThrowing, playerNames, scoreBoards);
    }

    public void reset() {
        playerNames.clear();
        status = GameStatus.INACTIVE;
        scoreBoards.clear();
    }

    public int showCurrentScore(BowlingGame bowling, String forWhom) {
        int score = 0;
        score = DisplayScoreOrThrowException.printCurrentScore(score, bowling, forWhom);
        return score;
    }
}
