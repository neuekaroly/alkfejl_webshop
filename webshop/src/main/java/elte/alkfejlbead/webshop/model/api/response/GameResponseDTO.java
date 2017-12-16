package elte.alkfejlbead.webshop.model.api.response;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.Game;
import lombok.Data;

import java.sql.SQLException;
import java.util.List;

@Data
public class GameResponseDTO {
    private String gameName;
    private String releaseDate;
    private String description;
    private Game.Platform platform;
    private int price;
    private int amount;
    private String picture;
    private Developer developer;
    private List<Category> categories;

    public GameResponseDTO(Game game) {

        this.gameName = game.getGameName();
        this.releaseDate = game.getReleaseDate();
        this.description = game.getDescription();
        this.platform = game.getPlatform();
        this.price = game.getPrice();
        this.amount = game.getAmount();
        try {
            this.picture = new String(game.getPicture().getBytes(1, (int) game.getPicture().length()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.developer = game.getDeveloper();
        this.categories = game.getCategories();

    }
}
