package com.tietoEVRY2.bowling;

import com.tietoEVRY2.bowling.game.BowlingGame;
import com.tietoEVRY2.bowling.game.ConsoleBowling;

public class TietoBowling {
    public static void main(String[] args) {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom","Alina");
        bowling.playerNames.forEach(System.out::println);
        bowling.throwBall(1,5, "Artjom");
        bowling.throwBall(1,5, "Artjom");
        bowling.throwBall(1,5, "Artjom");
        bowling.throwBall(1,5, "Artjom");
        bowling.throwBall(1,5, "Artjom");
        bowling.throwBall(10,0, "Artjom");
        bowling.throwBall(10,0, "Artjom");
        bowling.throwBall(10,0, "Artjom");
        System.out.println(bowling.scoreBoards.get(0).getFrames().get(0).scoreToCount);
        System.out.println(bowling.scoreBoards.get(0).getFrames().get(1).scoreToCount);
        System.out.println(bowling.scoreBoards.get(0).getCurrentScores().get(1).totalScore);

        ConsoleBowling playBowlingInConsole = new ConsoleBowling();
        playBowlingInConsole.showFullPlayerTable("Artjom", bowling.scoreBoards);
    }

}
