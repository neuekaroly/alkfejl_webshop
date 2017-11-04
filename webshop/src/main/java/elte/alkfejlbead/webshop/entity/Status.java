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
public class Status extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.DRAFT;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus = ShippingStatus.NOTYETSHIPPED;

    @JoinColumn
    @OneToOne(targetEntity = Order.class)
    private Order order;

    public enum OrderStatus {
        DRAFT, COMPLETED, PROCESSING
    }

    public enum ShippingStatus {
        NOTYETSHIPPED, SHIPPED, SHIPPINGNOTREQUIRED
    }
}