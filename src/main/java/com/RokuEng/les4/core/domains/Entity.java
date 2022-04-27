package com.RokuEng.les4.core.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public abstract class Entity {

    @Getter
    private int hp = 100;
    @Getter
    private float damagePercent;

    public Entity(float damagePercent) {
        this.damagePercent = damagePercent;
    }

    protected abstract void attack();

    public void attack(Entity enemy) {
        attack();
        enemy.hp *= 1 - damagePercent;
    }

    public boolean isDeath() {
        return hp <= 0;
    }
}
