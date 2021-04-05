package com.tietoEVRY2.bowling;

import com.tietoEVRY2.bowling.game.Frames;
import com.tietoEVRY2.bowling.game.PlayBonusGame;
import com.tietoEVRY2.bowling.game.TotalScoreDatabase;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class PlayBonusFrameNow {
    private int frameTracker;
    private List<Frames> frames;
    private TotalScoreDatabase tdb;

    public void lastFrame(int roll1, int roll2, int roll3) {
        Frames frameStart = new Frames();
        if (frameTracker > 8) {
            frames.add(frameStart);
            PlayBonusGame bonusFrame = new PlayBonusGame(tdb, frames, frameTracker);
            bonusFrame.playBonusFrame(roll1, roll2, roll3);
        }
    }
}
