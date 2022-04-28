package com.RokuEng.les4.core.domain.playable;

import com.RokuEng.les4.core.domain.Entity;

public class Elf extends Entity {

    @Override
    protected void attack() {
        System.out.printf("Я мирный! ");
    }

    public Elf(int damage) {
        super(0);
    }
}
