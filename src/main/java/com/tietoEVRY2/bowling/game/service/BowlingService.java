package com.tietoEVRY2.bowling.game.service;

import com.tietoEVRY2.bowling.game.ScoreBoard;
import com.tietoEVRY2.bowling.game.OVERALLScoreTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BowlingService {
    public List<ScoreBoard> getTables () {
        if (OVERALLScoreTable.psc.isEmpty())
        OVERALLScoreTable.initTables();
        return OVERALLScoreTable.psc;
    }
    public List<ScoreBoard> getRes () {
        OVERALLScoreTable.playGame();
        return OVERALLScoreTable.psc;
    }

}
