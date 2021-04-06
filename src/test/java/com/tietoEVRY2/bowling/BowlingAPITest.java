package com.tietoEVRY2.bowling;

import com.tietoEVRY2.bowling.exceptions.WrongNameOrPinsException;
import com.tietoEVRY2.bowling.game.BowlingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingAPITest {

    @Test
    @DisplayName("TEST 1: All strikes produce 300 points in total")
    void return_300_if_all_strikes() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 9; frame ++) {
            bowling.throwBall(10, 0, "Artjom");
        }
        bowling.throwBall(10,10,10, "Artjom");
        assertEquals(300, bowling.scoreBoards.get(0).getTdb().totalScore);
    }

    @Test
    @DisplayName("TEST 2: All misses give 0 points")
    void return_0_if_all_missed() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 9; frame ++) {
            bowling.throwBall(0, 0, "Artjom");
        }
        bowling.throwBall(0,0,"Artjom");
        assertEquals(0, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 3: All spares of 5/5 give 150 points")
    void return_150_if_all_spares() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 9; frame ++) {
            bowling.throwBall(5, 5, "Artjom");
        }
        bowling.throwBall(5,5,5,"Artjom");
        assertEquals(150, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 4: All normals of 1/3 give 40 points")
    void return_40_if_1_and_3_are_per_frame() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 9; frame ++) {
            bowling.throwBall(1, 3, "Artjom");
        }
        bowling.throwBall(1,3,"Artjom");
        assertEquals(40, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 5: When we throw 4-5p in first 3 frames, then 5-5 for second two" +
            "and last are strikes then result is 212")
    void return_212_when_4_5__4_5__4_5__5_5__5_5__then_all_strikes() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 3; frame ++) {
            bowling.throwBall(4, 5, "Artjom");
        }
        for (int frame = 3; frame < 5; frame++) {
            bowling.throwBall(5, 5, "Artjom");
        }
        for (int frame = 5; frame < 9; frame++) {
            bowling.throwBall(10, 0, "Artjom");
        }
        bowling.throwBall(10,10,10,"Artjom");
        assertEquals(212, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 6: When we throw until 5th frame (count from 0, 5 is included)" +
            " all strikes, then continue with spares (7/3) and finish with 3rd roll of 6," +
            "we get as result 234")
    void return_234_when_until_7th_frame_all_strikes_then_spares() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 6; frame ++) {
            bowling.throwBall(10, 0, "Artjom");
        }
        for (int frame = 6; frame < 9; frame++) {
            bowling.throwBall(7, 3, "Artjom");
        }

        bowling.throwBall(7,3,6,"Artjom");
        assertEquals(234, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 7: When we have all normals 3/4, and after (not included) 7th frame we go" +
            "all strikes")
    void return_162_when_normals_until_7th_then_strikes() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 7; frame ++) {
            bowling.throwBall(3, 4, "Artjom");
        }
        for (int frame = 7; frame < 9; frame++) {
            bowling.throwBall(10, 0, "Artjom");
        }

        bowling.throwBall(10,10,10,"Artjom");
        assertEquals(139, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 8: When we with sequence of 8/1--10--1/9 until the end, then result" +
            "is 150")
    void return_150_when_sequence_8_1__10__1_9() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 3; frame ++) {
            bowling.throwBall(8, 1, "Artjom");
            bowling.throwBall(10, 0, "Artjom");
            bowling.throwBall(1, 9, "Artjom");
        }
        bowling.throwBall(8,1,0,"Artjom");
        assertEquals(150, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 9: When we with sequence of 10--10--1/9 until the end, then result" +
            "is 204")
    void return_204_when_sequence_10__10__1_9() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 3; frame ++) {
            bowling.throwBall(10, 0, "Artjom");
            bowling.throwBall(10, 0, "Artjom");
            bowling.throwBall(1, 9, "Artjom");
        }
        bowling.throwBall(10, 10,1, "Artjom");
        assertEquals(204, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 10: When we with sequence of 6/2--10--5/1--8/2 until the end, then result" +
            "is 116")
    void return_204_when_sequence_6_2__10__5_1__8_2() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        for (int frame = 0; frame < 2; frame ++) {
            bowling.throwBall(6, 2, "Artjom");
            bowling.throwBall(10, 0, "Artjom");
            bowling.throwBall(5, 1, "Artjom");
            bowling.throwBall(8, 2, "Artjom");
        }
        bowling.throwBall(6, 2, "Artjom");
        bowling.throwBall(10, 5,1, "Artjom");
        assertEquals(116, bowling.scoreBoards.get(0).getTdb().totalScore);
    }
    @Test
    @DisplayName("TEST 11: Custom Exception is thrown if name at initialization isn't provided " +
            "or null and we try to throw a ball with unknown player")
    void return_WrongNameOrPinsException_on_bad_input() {
        BowlingGame bowling = new BowlingGame();
        bowling.init(null);
        //bowling.throwBall(1,1,"Artjom");
        assertThrows(WrongNameOrPinsException.class, () -> bowling.throwBall(1,1,"Artjom"));
    }
    @Test
    @DisplayName("TEST 11.2: Custom Exception is thrown if name at initialization isn't provided " +
            "or null and we try to throw a ball with unknown player")
    void return_WrongNameOrPinsException_on_bad_input_2() {
        BowlingGame bowling = new BowlingGame();
        bowling.init("Artjom");
        //bowling.throwBall(1,1,"Artjom");
        assertThrows(WrongNameOrPinsException.class, () -> bowling.throwBall(1,1,"Alina"));
    }
}
