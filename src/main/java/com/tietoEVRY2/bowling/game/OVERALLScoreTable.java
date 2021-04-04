package com.tietoEVRY2.bowling.game;

import java.util.ArrayList;
import java.util.List;

public class OVERALLScoreTable {
    static GameStatus status = GameStatus.INACTIVE;
    public static List<ScoreBoard> psc = new ArrayList<>(3);
    static int init = 3;

    public static void initTables() {
        if (status.equals(GameStatus.INACTIVE)) {
            Game.init(init);
            status = GameStatus.START;
        }
        for (int i = 0; i < Game.numberOfPlayers; i++) {
            //psc.add(new ScoreBoard());
        }
    }
    public static void reset () {
            psc.clear();
        status = GameStatus.INACTIVE;
    }

    public static void playGame() {
        if (status.equals(GameStatus.FINISH)) {
            reset();
            initTables();
        } else {
            for (int i = 0; i < init; i++) {
                //psc.get(i).playBowling();
                List<Frames> fr = psc.get(i).getFrames();
                psc.get(i).setFrames(fr);
            }
            status = GameStatus.FINISH;
        }
    }
}
