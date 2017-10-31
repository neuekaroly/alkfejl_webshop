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
public class OrderDetails extends BaseEntity{
    @Column(nullable = false)
    private int quantity;

    @JoinColumn
    @ManyToOne(targetEntity = Games.class)
    private Games game;

    @JoinColumn
    @OneToOne(targetEntity = Status.class)
    private Status status;

    @JoinColumn
    @ManyToOne(targetEntity = Orders.class)
    private Orders order;
}