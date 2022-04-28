package com.RokuEng.les4.core.domain;

import com.RokuEng.les4.core.domain.item.armor.Protectable;
import com.RokuEng.les4.core.domain.progression.Level;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public abstract class Entity {

    @Setter(AccessLevel.PRIVATE)
    private Level level = Level.L1;
    @Getter
    private float hp = 100;
    @Getter
    private float damage;

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
            System.out.printf("Персонаж уже мёртв! ");
            return;
        }

        damage(enemy);

        System.out.printf("У %s осталось: %d здоровья! ", enemy.getClass().getSimpleName(),Math.round(enemy.hp));
    }

    private void damage(Entity enemy) {
        int armor = enemy.protects
                .stream()
                .peek(e -> {
                    System.out.printf("Применена защита <%s> ", e.getClass().getSimpleName());
                })
                .mapToInt(Protectable::protect)
                .sum();

        if (armor >= damage) {
            System.out.printf("Враг защитился! ");
            return;
        } else {
            System.out.printf("Враг защитился! %d HP! ", armor);
        }

        enemy.hp -= (damage - armor);
    }

    public boolean isDeath() {
        return hp <= 0;
    }

    @Deprecated
    private void correctHp() {
        if (hp < 0) {
            hp = 0;
        } if (hp > 100) {
            hp = 100;
        }
    }

    public void update(Level level) {
        this.level = level;
        this.damage = this.damage * level.getTuple(this).getDamageMultiplayer();
        this.hp = this.hp * level.getTuple(this).getHpMultiplayer();
        System.out.printf("Получен уровень <%d>! Новое Хп: %d Новый Урон: %d", level.ordinal()+1, Math.round(this.hp), Math.round(this.damage));
    }
}
