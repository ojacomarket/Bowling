package com.tietoEVRY2.bowling;

import com.tietoEVRY2.bowling.game.BowlingGame;
import com.tietoEVRY2.bowling.game.ConsoleBowling;

public class TietoBowling {
    public static void main(String[] args) {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom", "Alina");
        bowling.throwBall(1, 9, "Artjom");

        bowling.throwBall(5, 0, "Artjom");

        bowling.throwBall(1, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(1, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(0, 5, "Artjom");

        bowling.throwBall(1, 0,"Artjom");

        bowling.throwBall(0, 1, "Artjom");

        ConsoleBowling playBowlingInConsole = new ConsoleBowling();
        playBowlingInConsole.showFullPlayerTable("Artjom", bowling.scoreBoards);

       // System.out.println(bowling.showCurrentScore(bowling, "Artjom"));
    }
}
