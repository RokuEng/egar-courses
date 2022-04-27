package com.RokuEng.les4.core.domains.npc;

import com.RokuEng.les4.core.domains.Entity;

public class Mage extends Entity {

    @Override
    protected void attack() {
        System.out.println("Атака магией!");
    }

    public Mage(float damagePercent) {
        super(damagePercent);
    }
}
