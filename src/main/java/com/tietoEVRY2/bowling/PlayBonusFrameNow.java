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
}
