package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.FilterDTO;
import elte.alkfejlbead.webshop.model.api.request.GameDTO;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.model.api.response.GameResponseDTO;
import elte.alkfejlbead.webshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Role(User.Role.ADMIN)
    @PostMapping("")
    public void addGame(HttpServletRequest request, @RequestBody GameDTO game) {
        gameService.addNewGame(game);
    }

    @Role(User.Role.USER)
    @GetMapping("")
    public ListDTO<GameResponseDTO> getAllGames(HttpServletRequest request) {
        return this.gameService.getAllGames();
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

    @Role(User.Role.USER)
    @GetMapping("/platforms")
    public ListDTO<Game.Platform> getPlatforms(HttpServletRequest request) {
        return gameService.getPlatforms();
    }

    @Role(User.Role.USER)
    @GetMapping("/search/{gameName}")
    public ListDTO<GameResponseDTO> searchByGameName(HttpServletRequest request, @PathVariable String gameName) {
        return gameService.searchByGameName(gameName);
    }

    @Role(User.Role.USER)
    @PatchMapping("/advancedsearch")
    public ListDTO<GameResponseDTO> advancedSearch(HttpServletRequest request, @RequestBody FilterDTO filter) {
        return gameService.advancedSearch(filter);
    }
}
