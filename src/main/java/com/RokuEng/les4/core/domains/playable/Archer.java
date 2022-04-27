package com.RokuEng.les4.core.domains.playable;

import com.RokuEng.les4.core.domains.Entity;

public class Archer extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Атака стрелой! ");
    }

    public Archer(int damage) {
        super(damage);
    }
}
