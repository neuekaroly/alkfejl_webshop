package elte.alkfejlbead.webshop.model.api.request;

import elte.alkfejlbead.webshop.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class GameDTO {
    private String gameName;
    private String releaseDate;
    private String description;
    private Game.Platform platform;
    private int price;
    private int amount;
    private String picture;
    private int developerId;
    private List<Integer> categoryIds;
}
