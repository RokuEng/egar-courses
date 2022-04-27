package com.RokuEng.les4.core.domains.npc;

import com.RokuEng.les4.core.domains.Entity;

public class Archer extends Entity {

    @Override
    protected void attack() {
        System.out.println("Атака стрелой!");
    }

    public Archer(float damagePercent) {
        super(damagePercent);
    }
}
