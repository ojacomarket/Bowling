package com.tietoEVRY2.bowling.game.controller;

import com.tietoEVRY2.bowling.game.ScoreBoard;

import com.tietoEVRY2.bowling.game.service.BowlingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tables")
@AllArgsConstructor
public class BowlingController {
    private final BowlingService service;
    @GetMapping
    public ResponseEntity<List<ScoreBoard>> getPlayerTable() {
        List<ScoreBoard> players = service.getTables();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @GetMapping("/play")
    public ResponseEntity<List<ScoreBoard>> getGameResults() {
        List<ScoreBoard> players = service.getRes();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
