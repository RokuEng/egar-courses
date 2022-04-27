package com.RokuEng.les4.core.domains.playable;

import com.RokuEng.les4.core.domains.Entity;

public class Elf extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Я мирный! ");
    }

    public Elf(int damage) {
        super(0);
    }
}
