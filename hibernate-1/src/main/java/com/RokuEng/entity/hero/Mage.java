package com.RokuEng.entity.hero;

import com.RokuEng.entity.Persistent;
import com.RokuEng.entity.hero.Hero;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@NamedQuery(
        name = "exists tasks query",
        query = "SELECT m FROM Mage m WHERE m.hero.tasks IS NOT EMPTY"
)
@NamedQuery(
        name = "health more that",
        query = "SELECT m FROM Mage m WHERE m.hero.health > :health"
)
public class Mage implements Persistent<Integer> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private Integer mana;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "hero_id")
    private Hero hero;

}
