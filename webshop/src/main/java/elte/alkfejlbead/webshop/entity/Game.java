package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
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
    private Platform platform;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int rating;

    @Lob
    @Column(nullable = false)
    private Blob picture;

    @JoinColumn
    @ManyToOne
    private Developer developer;

    @JoinTable(name="games_categories", joinColumns = {@JoinColumn(name="game_id")}, inverseJoinColumns = {@JoinColumn(name="category_id")})
    @ManyToMany
    List<Category> categories;

    public enum Platform {
        PC,PS4,XBOXONE
    }
}