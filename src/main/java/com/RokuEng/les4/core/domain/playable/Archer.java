package com.RokuEng.les4.core.domain.playable;

import com.RokuEng.les4.core.domain.Entity;

public class Archer extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Атака стрелой! ");
    }

    public Archer(int damage) {
        super(damage);
    }
}
