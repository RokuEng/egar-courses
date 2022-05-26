package com.RokuEng.entity.hero;

import com.RokuEng.entity.Persistent;
import com.RokuEng.entity.hero.Hero;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
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
