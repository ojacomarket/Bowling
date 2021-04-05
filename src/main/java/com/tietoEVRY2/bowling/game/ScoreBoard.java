package com.tietoEVRY2.bowling.game;

import com.tietoEVRY2.bowling.exceptions.WrongNameOrPinsException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static com.tietoEVRY2.bowling.util.validations.Scoring.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ScoreBoard {
    @NonNull
    private String playerName;
    private List<Frames> frames;
    private int frameTracker = -1;
    private List<TotalScoreDatabase> currentScores;
    private TotalScoreDatabase tdb;

    public void playFrame(int roll1, int roll2) throws WrongNameOrPinsException {
        if (frameTracker == -1) {
            tdb = new TotalScoreDatabase(new ArrayList<>(), 0);
            frames = new ArrayList<>();
            currentScores = new ArrayList<>();
        }
        frameTracker++;
        if (frameTracker > 9) {
            return;
        }
        Frames frameStart = new Frames();
        frameStart.roll1 = roll1;
        assessSingularFrame(roll1, roll2, tdb, frameStart, frameTracker, frames);
        predictCalculations(roll1, roll2, tdb, frameTracker, frames);
        currentScores.add(tdb);
    }
}
