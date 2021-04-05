package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.FrameScoreOutOfBoundariesException;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class BowlingGame {
    public static GameStatus status;
    public List<String> playerNames;
    public List<ScoreBoard> scoreBoards;
    private List<TABLE_DATABASE> tdb;

    public void init(String... names) {

        status = GameStatus.START;
        playerNames = new ArrayList<>();
        scoreBoards = new ArrayList<>();
        playerNames.addAll(Arrays.asList(names));
        playerNames.forEach(x -> scoreBoards.add(new ScoreBoard(x)));
    }

    public void throwBall(int roll1, int roll2, String whoIsThrowing) {

        try {
            ScoreBoard sample = scoreBoards.stream()
                    .filter(x -> whoIsThrowing.equals(x.getPlayerName()))
                    .findAny()
                    .orElse(null);
            scoreBoards.get(scoreBoards.indexOf(sample)).playFrame(roll1, roll2);
        } catch (FrameScoreOutOfBoundariesException fsobe) {
            System.out.println("Lol");
        }
    }

    public void throwBall(int roll1, int roll2, int roll3, String whoIsThrowing) {
        ScoreBoard sample = scoreBoards.stream()
                .filter(x -> whoIsThrowing.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);
        scoreBoards.get(0).setFrameTracker(scoreBoards.get(0).getFrameTracker() +1);
        PlayBonusGame playBonusFrame = new PlayBonusGame(scoreBoards.get(0).getTdb(), scoreBoards.get(scoreBoards.indexOf(sample)).getFrames(),
                scoreBoards.get(0).getFrameTracker());
        playBonusFrame.playBonusFrame(roll1, roll2, roll3);
    }

    public void reset() {

        playerNames.clear();
        status = GameStatus.INACTIVE;
        scoreBoards.clear();
        tdb.clear();
    }
}

