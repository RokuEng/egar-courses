package com.RokuEng.rpgbank.util;

import com.RokuEng.rpgbank.domain.Hero;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class HeroBuilder {
    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private Float damage;

    @NonNull
    private Float health;

    public HeroBuilder(@NonNull Integer id, @NonNull String name, @NonNull Float damage, @NonNull Float health) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public Hero build() {
        Hero hero = new Hero();

        hero.setDamage(damage);
        hero.setName(name);
        hero.setId(id);
        hero.setHealth(health);

        return hero;
    }
}
