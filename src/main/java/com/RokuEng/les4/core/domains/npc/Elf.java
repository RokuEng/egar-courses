package com.RokuEng.les4.core.domains.npc;

import com.RokuEng.les4.core.domains.Entity;

public class Elf extends Entity {

    @Override
    protected void attack() {
        System.out.println("Отсутствие атаки!");
    }

    public Elf(float damagePercent) {
        super(0);
    }
}
