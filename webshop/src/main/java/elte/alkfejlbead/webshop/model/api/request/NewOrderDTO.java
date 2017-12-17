package elte.alkfejlbead.webshop.model.api.request;


import elte.alkfejlbead.webshop.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class NewOrderDTO {
    private int userID;
    private boolean paymentByCreditCard;
    private List<OrderItemDTO> orderItems;
    private List<Integer> quantities;
    private int orderPrice;
}
