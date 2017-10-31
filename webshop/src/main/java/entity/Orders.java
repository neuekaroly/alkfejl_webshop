package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Orders extends BaseEntity{
    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private int orderPrice;

    @Column(nullable = false)
    private boolean paymentByCreditCard;

    @Column(nullable = false)
    private boolean isDone;

    @JoinColumn
    @ManyToOne(targetEntity = Users.class)
    private Users user;

}
