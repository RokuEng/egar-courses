package com.RokuEng.les4.core.domain.item.armor;

import com.RokuEng.les4.core.domain.actions.Ability;
import lombok.Getter;

public class Chestplate implements Protectable {

    @Getter
    private final int armor = 5;

    @Override
    public Ability protect() {
        return u -> {
            u.applyToHp(armor);
        };
    }

}
