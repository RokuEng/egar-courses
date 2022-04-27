package com.RokuEng.les4.core.domains.playable;

import com.RokuEng.les4.core.domains.Entity;

public class Dwarf extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Прогресс невозможен без пива! ");
    }

    public Dwarf(int damage) {
        super(damage);
    }
}
