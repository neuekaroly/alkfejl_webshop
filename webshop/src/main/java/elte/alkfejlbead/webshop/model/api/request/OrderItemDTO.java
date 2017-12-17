package elte.alkfejlbead.webshop.model.api.request;

import lombok.Data;

@Data
public class OrderItemDTO {
    private int gameId;
    private int quantity;
}
