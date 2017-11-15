package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.repository.CategoryRepository;
import elte.alkfejlbead.webshop.repository.DeveloperRepository;
import elte.alkfejlbead.webshop.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;
    private DeveloperRepository developerRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public GameService(GameRepository gameRepository, DeveloperRepository developerRepository, CategoryRepository categoryRepository) {
        this.gameRepository = gameRepository;
        this.developerRepository = developerRepository;
        this.categoryRepository = categoryRepository;
    }

    public Game addNewGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(int gameId) {
        gameRepository.delete(gameId);
    }

    public void updateGame(Game game) {
       Game updatedGame = gameRepository.findOne(game.getId());
       updatedGame.setGameName(game.getGameName());
       updatedGame.setAmount(game.getAmount());
       updatedGame.setDescription(game.getDescription());
       updatedGame.setPicture(game.getPicture());
       updatedGame.setPlatform(game.getPlatform());
       updatedGame.setPrice(game.getPrice());
       updatedGame.setRating(game.getRating());
       updatedGame.setReleaseDate(game.getReleaseDate());
       gameRepository.save(updatedGame);
    }

    public void addDeveloperToGame(int gameId, int developerId) {
        Game game = gameRepository.findOne(gameId);
        Developer developer = developerRepository.findOne(developerId);
        developer.getGames().add(game);
        game.setDeveloper(developer);
    }

    public void addCategoriesToGame(int gameId, List<Integer> categories) {
        Game game = gameRepository.findOne(gameId);
        for (Integer i : categories) {
            categoryRepository.findOne(i).getGames().add(game);
            game.getCategories().add(categoryRepository.findOne(i));
        }
        gameRepository.save(game);
    }
}
