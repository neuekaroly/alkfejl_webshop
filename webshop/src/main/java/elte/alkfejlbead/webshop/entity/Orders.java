package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Orders extends BaseEntity{
    @Column(nullable = false)
    private String orderdate;

    @Column(nullable = false)
    private int orderprice;

    @Column(nullable = false)
    private boolean paymentbycreditcard;

    @Column(nullable = false)
    private boolean isdone;

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User user;

    @OneToMany(targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL)
    private List<OrderDetails> orderdetails;

}