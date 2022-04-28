package com.RokuEng.les4.core.domain.playable;

import com.RokuEng.les4.core.domain.Entity;

public class Dwarf extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Прогресс невозможен без пива! ");
    }

    public Dwarf(int damage) {
        super(damage);
    }
}
