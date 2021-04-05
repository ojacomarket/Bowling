package com.tietoEVRY2.bowling.game;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class TotalScoreDatabase {
    public List<FrameStatus> gameFrameStatuses;
    public int totalScore;
}
