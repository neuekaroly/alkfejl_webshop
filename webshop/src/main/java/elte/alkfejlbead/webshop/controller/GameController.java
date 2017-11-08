package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("")
    public Game addGame(@RequestBody Game game) {
        return gameService.addNewGame(game);
    }

    @PostMapping("/{gameId]/developer/{developerId}")
    public void addDeveloperToGame(@PathVariable int developerId, @PathVariable int gameId) {
        gameService.addDeveloperToGame(gameId, developerId);
    }

    @PostMapping("/{gameId}/categories")
    public void addCategoriesToGame(@RequestBody List<Integer> categoryIds, @PathVariable int gameId) {
        gameService.addCategoriesToGame(gameId,categoryIds);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable int gameId) {
        gameService.deleteGame(gameId);
    }

    @PatchMapping("/update")
    public void  updateGame(@RequestBody Game game) {
        gameService.updateGame(game);
    }
}
