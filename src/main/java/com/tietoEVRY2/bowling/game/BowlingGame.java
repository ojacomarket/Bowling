package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.FrameScoreOutOfBoundariesException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@NoArgsConstructor
public class BowlingGame {
    public static GameStatus status;
    public List<String> playerNames;
    public List<ScoreBoard> scoreBoards;
    //private final static BowlingGame game = new BowlingGame(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    //private static List<List<Integer>> tracker = new ArrayList<>();
    private List<TABLE_DATABASE> tdb;

    public void init(String... names) {
        //if (status == GameStatus.INACTIVE || status == null) {
        status = GameStatus.START;
        playerNames = new ArrayList<>();
        scoreBoards = new ArrayList<>();
            /*BowlingGame startBowling = new BowlingGame(new ArrayList<>(), new ArrayList<>());
            game = startBowling;*/
        playerNames.addAll(Arrays.asList(names));
        playerNames.forEach(x -> scoreBoards.add(new ScoreBoard(x)));
    }
    // }


    public void throwBall(int roll1, int roll2, String whoIsThrowing) {

        try {
            ScoreBoard sample = scoreBoards.stream()
                    .filter(x -> whoIsThrowing.equals(x.getPlayerName()))
                    .findAny()
                    .orElse(null);
            scoreBoards.get(scoreBoards.indexOf(sample)).playBowling(roll1, roll2);
           /* tracker.add(new ArrayList<>());
            tracker.get(i).add(game.scoreBoards.get(0).getFrameTracker());*/

        } catch (FrameScoreOutOfBoundariesException fsobe) {
            System.out.println("Lol");
        }
    }



   /* public void throwBall(int roll1, int roll2, Integer roll3) {

    }
*/

    public void reset() {
        playerNames.clear();
        status = GameStatus.INACTIVE;
        scoreBoards.clear();
        tdb.clear();

    }


  /*  public static void main(String[] args) {
        init("Alex", "Johny");
        //game.throwBall(1, 2, 5);
        //tracker.forEach(x -> x.forEach(System.out::println));
        System.out.println(game.scoreBoards.get(0).getPlayerName());
        game.throwBall(1,5,3);
        //System.out.println(game.scoreBoards.get(0).getFrames().get(0).scoreToCount);
            *//*game.throwBall(1,2, 5);
            tracker.forEach(x -> x.forEach(System.out::println));*//*

     *//*game.playerNames.forEach(System.out::println);*/

    }
//}
