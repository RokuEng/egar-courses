package com.RokuEng.les4.core.domains;

import com.RokuEng.les4.core.domains.item.armor.Protectable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public abstract class Entity {

    @Getter
    private int hp = 100;
    @Getter
    private int damage;

    @Getter
    private List<Protectable> protects = new ArrayList<>();

    public Entity(int damage) {
        this.damage = damage;
    }

    protected abstract void attack();

    public void attack(Entity enemy) {
        System.out.printf("\n\n<%s> ", this.getClass().getSimpleName());

        attack();

        if (isDeath()) {
            System.out.printf("Персонаж уже мёртв!");
            return;
        }

        damage(enemy);

        System.out.printf("У %s осталось: %d здоровья ", enemy.getClass().getSimpleName(), enemy.hp);
    }

    private void damage(Entity enemy) {
        int armor = enemy.protects.stream().mapToInt(Protectable::protect).sum();

        if (armor > damage) {
            return;
        }

        enemy.hp -= (damage - armor);
    }

    public boolean isDeath() {
        return hp <= 0;
    }

    private void correctHp() {
        if (hp < 0) {
            hp = 0;
        } if (hp > 100) {
            hp = 100;
        }
    }
}
