package com.RokuEng.springdata.core.entity.hero;

import com.RokuEng.springdata.core.entity.Persistent;
import lombok.Data;

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
