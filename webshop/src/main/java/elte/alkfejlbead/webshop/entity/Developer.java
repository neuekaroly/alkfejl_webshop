package elte.alkfejlbead.webshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    private String developerName;

    @Column(nullable = false)
    private String country;

    @JsonIgnore
    @OneToMany(targetEntity = Game.class,
            cascade = CascadeType.ALL,
            mappedBy = "developer")
    private List<Game> games;
}