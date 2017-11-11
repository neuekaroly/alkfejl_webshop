package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Role(User.Role.ADMIN)
    @PostMapping("")
    public Game addGame(HttpServletRequest request, @RequestBody Game game) {
        return gameService.addNewGame(game);
    }

    @Role(User.Role.ADMIN)
    @PostMapping("/{gameId]/developer/{developerId}")
    public void addDeveloperToGame(HttpServletRequest request, @PathVariable int developerId, @PathVariable int gameId) {
        gameService.addDeveloperToGame(gameId, developerId);
    }

    @Role(User.Role.ADMIN)
    @PostMapping("/{gameId}/categories")
    public void addCategoriesToGame(HttpServletRequest request, @RequestBody ListDTO<Integer> categoryIds, @PathVariable int gameId) {
        gameService.addCategoriesToGame(gameId,categoryIds.getItems());
    }

    @Role(User.Role.ADMIN)
    @DeleteMapping("/{gameId}")
    public void deleteGame(HttpServletRequest request, @PathVariable int gameId) {
        gameService.deleteGame(gameId);
    }

    @Role(User.Role.ADMIN)
    @PatchMapping("/update")
    public void  updateGame(HttpServletRequest request, @RequestBody Game game) {
        gameService.updateGame(game);
    }
}
