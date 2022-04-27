package com.RokuEng.les4.core.domains.npc;

import com.RokuEng.les4.core.domains.Entity;

public class Warrior extends Entity {
    @Override
    protected void attack() {
        System.out.println("Атака мечём!");
    }

    public Warrior(float damagePercent) {
        super(damagePercent);
    }
}
