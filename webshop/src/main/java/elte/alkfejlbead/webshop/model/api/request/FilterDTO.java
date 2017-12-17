package elte.alkfejlbead.webshop.model.api.request;

import elte.alkfejlbead.webshop.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class FilterDTO {
    private String searchTag;
    private int priceTag;
    private List<Integer> categories;
    private List<Game.Platform> platforms;
}
