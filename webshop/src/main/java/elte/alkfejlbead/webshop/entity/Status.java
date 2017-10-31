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
    private OrderStatus orderstatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingstatus;

    @JoinColumn
    @OneToOne(targetEntity = OrderDetails.class)
    private OrderDetails orderdetail;

    public enum OrderStatus {
        DRAFT, COMPLETED, PROCESSING
    }

    public enum ShippingStatus {
        NOTYETSHIPPED, SHIPPED, SHIPPINGNOTREQUIRED
    }
}