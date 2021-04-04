package com.tietoEVRY2.bowling;

import java.util.Random;

public class ThrowBonus {

    public static int throwBonus(int secondRollValue) {
        if (secondRollValue == 10 || secondRollValue == -1) {
            return new Random().nextInt(11);
        }
        else {
            return new Random().nextInt(11 - secondRollValue);
        }
    }
}
