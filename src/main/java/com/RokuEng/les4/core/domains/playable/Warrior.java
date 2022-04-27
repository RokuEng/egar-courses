package com.RokuEng.les4.core.domains.playable;

import com.RokuEng.les4.core.domains.Entity;

public class Warrior extends Entity {
    @Override
    protected void attack() {
        System.out.printf("Атака мечём! ");
    }

    public Warrior(int damage) {
        super(damage);
    }
}
