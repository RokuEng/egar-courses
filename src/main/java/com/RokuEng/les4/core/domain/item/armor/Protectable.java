package com.RokuEng.les4.core.domain.item.armor;

import com.RokuEng.les4.core.domain.actions.Ability;

public interface Protectable {
    Ability protect();

    default int getArmor() {
        return 0;
    }

}
