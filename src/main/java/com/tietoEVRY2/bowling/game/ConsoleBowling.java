package com.tietoEVRY2.bowling.game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

//@AllArgsConstructor
@Data
public class ConsoleBowling {

    public String name;
    public List<Frames> frames;
    public int frameNr = 5;

    public void playBowlingInConsole() {
        String playerTableConsole = "| %-15s | %-7d | %-7s| %-7s| %n";

        System.out.format("+-----------------+---------+--------+--------+%n");
        System.out.format("| Player name     | Roll1   | Roll2  | Total  |%n");
        System.out.format("+-----------------+---------+--------+--------+%n");

           /* System.out.format(playerTableConsole, name, frames.get(whichPlayer).roll1,
                    frames.get(whichPlayer).roll2,frames.get(whichPlayer).scoreToCount );
*/
        System.out.format("+-----------------+---------+--------+--------+%n");
    }
    public void showFullPlayerTable(String player, List<ScoreBoard> scoreBoards) {
        String playerFullTableConsole = "| %-15s | %-7d | %-7d| %-7d| %n";
        String playerFullTableConsole2 = "| %-15s | %-7s | %-7s| %-7d| %n";
        String playerFullTableConsole3 = "| %-15s | %-7d | %-7s| %-7d| %n";
        String playerFullTableConsole4 = "| %-15s | %-7d | %-7s| %-7s| %n";
        String playerFullTableConsole5 = "| %-15s | %-7s | %-7s| %-7s| %n";
        String strike;
        String spare;

        System.out.format("+-----------------+---------+--------+--------+%n");
        System.out.format("| %s          | Roll1   | Roll2  | Total  |%n", "Artjom");
        System.out.format("+-----------------+---------+--------+--------+%n");
        ScoreBoard sample = scoreBoards.stream()
                .filter(x -> player.equals(x.getPlayerName()))
                .findAny()
                .orElse(null);
            for (int throwsMade = 0; throwsMade < scoreBoards
                    .get(scoreBoards.indexOf(sample))
                    .getFrames().size(); throwsMade++) {
                if (sample.getFrames().get(throwsMade).roll1 == 10) {
                    if (sample.getFrames().get(throwsMade).scoreToCount == 0) {
                        System.out.format(playerFullTableConsole5, "Frame nr " + throwsMade, "X",
                                " ", " ");
                    } else {
                        System.out.format(playerFullTableConsole2, "Frame nr " + throwsMade, "X",
                                " ", sample.getFrames().get(throwsMade).scoreToCount);
                    }
                }
                else if (sample.getFrames().get(throwsMade).roll1 + sample.getFrames().get(throwsMade).roll2 == 10){
                    if (sample.getFrames().get(throwsMade).scoreToCount == 0) {
                        System.out.format(playerFullTableConsole4, "Frame nr " + throwsMade, sample.getFrames().get(throwsMade).roll1,
                                "/", " ");
                    } else {
                        System.out.format(playerFullTableConsole3, "Frame nr " + throwsMade, sample.getFrames().get(throwsMade).roll1,
                                "/", sample.getFrames().get(throwsMade).scoreToCount);
                    }
                }
                else {
                    System.out.format(playerFullTableConsole, "Frame nr " + throwsMade, sample.getFrames().get(throwsMade).roll1,
                            sample.getFrames().get(throwsMade).roll2, sample.getFrames().get(throwsMade).scoreToCount);
                }
                }
            System.out.format("+-----------------+---------+--------+--------+%n");
    }

   /* public static void main(String[] args) {
        ConsoleBowling n = new ConsoleBowling();
        n.showFullPlayerTable();
    }*/
}


