package com.RokuEng.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Warrior {

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
