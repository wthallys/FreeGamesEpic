package com.wthallys.freeGamesEpic.controller;

import com.wthallys.freeGamesEpic.model.ElementDTO;
import com.wthallys.freeGamesEpic.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<ElementDTO> getFilteredGames() {
        return gameService.getFilteredElements();
    }

}
