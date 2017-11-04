package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Developers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Developer extends BaseEntity{
    @Column(nullable = false)
    private String developername;

    @Column(nullable = false)
    private String country;

    @OneToMany(targetEntity = Game.class,
            cascade = CascadeType.ALL)
    private List<Game> games;
}