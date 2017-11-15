package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Games")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Game extends BaseEntity {
    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String picture;

    @JoinColumn
    @ManyToOne(targetEntity = Developer.class)
    private Developer developer;

    @JoinColumn
    @ManyToMany(targetEntity = Category.class)
    List<Category> categories;
}