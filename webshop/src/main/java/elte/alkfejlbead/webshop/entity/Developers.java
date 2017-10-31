package elte.alkfejlbead.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Developers extends BaseEntity{
    @Column(nullable = false)
    private String developername;

    @Column(nullable = false)
    private String country;

    @OneToMany(targetEntity = Games.class,
            cascade = CascadeType.ALL)
    private List<Games> games;
}