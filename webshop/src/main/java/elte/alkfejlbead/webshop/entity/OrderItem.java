package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends BaseEntity{
    @Column(nullable = false)
    private int quantity;

    @JoinColumn
    @ManyToOne(targetEntity = Game.class, cascade = CascadeType.ALL)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}