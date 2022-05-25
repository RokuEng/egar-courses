package com.RokuEng.entity.hero;

import com.RokuEng.entity.Persistent;
import com.RokuEng.entity.hero.Hero;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Warrior implements Persistent<Integer> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "hero_id")
    private Hero hero;

    public Warrior(Hero hero) {
        this.hero = hero;
    }
}
