package com.tietoEVRY2.bowling.game;

import java.util.Random;

public class Throwing_BALL {
    public static int throwBall (int roll, int secondRollValue) {
        if (roll == 1) {
            return new Random().nextInt(11);
        }
        if (roll == 2) {
            return new Random().nextInt(11 - secondRollValue);
        }

        else {
            return 0;
        }
    }
}
