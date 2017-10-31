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
public class Games extends BaseEntity {
    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String picture;

    @JoinColumn
    @ManyToOne(targetEntity = Developers.class)
    private Developers developer;

    @OneToMany(targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL)
    private List<OrderDetails> orderdetails;

    public enum Categories {
        SPORT, ACTION, FPS, TPS, SIMULATOR, MMORPG, ARCADE, ADVENTURE
    }
}