package elte.alkfejlbead.webshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private boolean aboveEighteen;

    @JsonIgnore
    @JoinColumn
    @ManyToMany(targetEntity = Game.class)
    List<Game> games;
}
