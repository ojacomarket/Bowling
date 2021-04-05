package com.tietoEVRY2.bowling;

import com.tietoEVRY2.bowling.game.BowlingGame;
import com.tietoEVRY2.bowling.game.ConsoleBowling;
import com.tietoEVRY2.bowling.util.CheckPlayerExistance;
import com.tietoEVRY2.bowling.util.HandleFrameCombosBonus;

public class TietoBowling {
    public static void main(String[] args) {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom", "Alina");
        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(5, 5, "Artjom");

        bowling.throwBall(10, 0, "Artjom");

        bowling.throwBall(4, 6, 2, "Artjom");

        ConsoleBowling playBowlingInConsole = new ConsoleBowling();
        playBowlingInConsole.showFullPlayerTable("Artjom", bowling.scoreBoards);
    }
}
