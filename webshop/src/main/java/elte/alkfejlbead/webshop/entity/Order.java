package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity{
    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private int orderPrice;

    @Column(nullable = false)
    private boolean paymentByCreditCard;

    @Column(nullable = false)
    private boolean isDone;

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User user;

    @OneToMany(targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

}