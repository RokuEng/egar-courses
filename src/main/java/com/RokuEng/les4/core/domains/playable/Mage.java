package com.RokuEng.les4.core.domains.playable;

import com.RokuEng.les4.core.domains.Entity;
import lombok.Getter;

public class Mage extends Entity {

    @Getter
    private int mana;
    private int manacost = 10;

    public Mage(int damage, int mana) {
        super(damage);
        this.mana = mana;
    }

    @Override
    protected void attack() {
        System.out.printf("Атака магией! ");
    }

    @Override
    public void attack(Entity enemy) {

        if (isManaEmpty()) {
            System.out.printf("Нет маны! ");
            return;
        }

        super.attack(enemy);
        mana -= manacost;
        System.out.printf("Осталось %d маны", mana);
    }

    private boolean isManaEmpty() {
        return mana <= 0;
    }
}
