package elte.alkfejlbead.webshop.model.api.request;


import lombok.Data;

import java.util.List;

@Data
public class NewOrderDTO {
    private int userID;
    private boolean paymentByCreditCard;
    private List<Integer> gameIds;
    private List<Integer> quantities;
}
