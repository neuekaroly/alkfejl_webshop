package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.model.api.request.FilterDTO;
import elte.alkfejlbead.webshop.model.api.request.GameDTO;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.model.api.response.GameResponseDTO;
import elte.alkfejlbead.webshop.repository.CategoryRepository;
import elte.alkfejlbead.webshop.repository.DeveloperRepository;
import elte.alkfejlbead.webshop.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.Arrays;
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

    public void addNewGame(GameDTO game) {
        Game newGame = new Game();
        newGame.setGameName(game.getGameName());
        newGame.setReleaseDate(game.getReleaseDate());
        newGame.setPrice(game.getPrice());
        newGame.setAmount(game.getAmount());
        newGame.setDeveloper(developerRepository.findOne(game.getDeveloperId()));
        Developer developer = developerRepository.findOne(game.getDeveloperId());
        developer.getGames().add(newGame);
        newGame.setDescription(game.getDescription());
        newGame.setPlatform(game.getPlatform());
        newGame.setCategories(categoryRepository.findByIdIn(game.getCategoryIds()));
        byte[] bytes = game.getPicture().getBytes();
        try {
            Blob blob = new SerialBlob(bytes);
            newGame.setPicture(blob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        gameRepository.save(newGame);
        developerRepository.save(developer);
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

    public ListDTO<Game.Platform> getPlatforms() {
        ListDTO<Game.Platform> platforms = new ListDTO<>();
        platforms.setItems(Arrays.asList(Game.Platform.values()));
        return platforms;
    }

    public ListDTO<GameResponseDTO> searchByGameName(String gameName) {

        ListDTO<GameResponseDTO> games = new ListDTO<>();
        List<Game> dbGames = gameRepository.searchByGameName(gameName);
        for (Game dbGame : dbGames) {

            GameResponseDTO game = new GameResponseDTO(dbGame);
            games.add(game);
        }

        return games;
    }

    public ListDTO<GameResponseDTO> getAllGames() {
        ListDTO<GameResponseDTO> games = new ListDTO<>();
        List<Game> dbGames = gameRepository.findAllByOrderByPriceAsc();
        for (Game dbGame : dbGames) {

            GameResponseDTO game = new GameResponseDTO(dbGame);
            games.add(game);
        }

        return games;
    }

    public ListDTO<GameResponseDTO> advancedSearch(FilterDTO filter) {
        ListDTO<GameResponseDTO> games = new ListDTO<>();
       // List<Game> dbGames = gameRepository.advancedSearch(filter.getSearchTag(),filter.getPriceTag(),filter.getCategories(),filter.getPlatforms());
        List<Game> dbGames = gameRepository.advancedSearch(filter.getSearchTag(), filter.getPriceTag(), filter.getPlatforms(), filter.getCategories());
        for (Game dbGame : dbGames) {

            GameResponseDTO game = new GameResponseDTO(dbGame);
            games.add(game);
        }

        return games;
    }
}
