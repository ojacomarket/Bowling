package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.WrongNameOrPinsException;
import com.tietoEVRY2.bowling.util.CheckPlayerExistance;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void throwBall(int roll1, int roll2, String whoIsThrowing){
        if (roll1 + roll2 > 10 || StringUtils.isEmpty(whoIsThrowing) || playerNames.stream().noneMatch(x -> x.equals(whoIsThrowing)))
            {
            throw new WrongNameOrPinsException("You have only 10 pins and unregistered players cannot play!");
        }
        try {
            ScoreBoard sample = scoreBoards.stream()
                    .filter(x -> whoIsThrowing.equals(x.getPlayerName()))
                    .findAny()
                    .orElse(null);
            scoreBoards.get(scoreBoards.indexOf(sample)).playFrame(roll1, roll2);
        }
        catch (WrongNameOrPinsException oneOfTwo) {
            System.out.println(oneOfTwo.getMessage());
        }
    }

    public void throwBall(int roll1, int roll2, int roll3, String whoIsThrowing) {
        if (CheckPlayerExistance.isValidPlayer(roll1,roll2,whoIsThrowing,playerNames)) {
            throw new WrongNameOrPinsException("You have only 10 pins and unregistered players cannot play!");
        }
        try {
            ScoreBoard sample = scoreBoards.stream()
                    .filter(x -> whoIsThrowing.equals(x.getPlayerName()))
                    .findAny()
                    .orElse(null);
            scoreBoards.get(0).setFrameTracker(scoreBoards.get(0).getFrameTracker() + 1);
            PlayBonusGame playBonusFrame = new PlayBonusGame(scoreBoards.get(0).getTdb(), scoreBoards.get(scoreBoards.indexOf(sample)).getFrames(),
                    scoreBoards.get(0).getFrameTracker());
            playBonusFrame.playBonusFrame(roll1, roll2, roll3);
        } catch (WrongNameOrPinsException oneOfTwo) {
            System.out.println(oneOfTwo.getMessage());
        }
    }

    public void reset() {
        playerNames.clear();
        status = GameStatus.INACTIVE;
        scoreBoards.clear();
    }

    public int showCurrentScore(BowlingGame bowling) {
        return bowling.scoreBoards.get(bowling.scoreBoards.indexOf(
                CheckPlayerExistance.checkExistance("Artjom", bowling.scoreBoards))).getTdb().totalScore;
    }
}

