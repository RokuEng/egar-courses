package com.RokuEng.les4.core.domains.npc;

import com.RokuEng.les4.core.domains.Entity;

public class Dwarf extends Entity {

    @Override
    protected void attack() {
        System.out.println("Прогресс невозможен без пива!");
    }

    public Dwarf(float damagePercent) {
        super(damagePercent);
    }
}
