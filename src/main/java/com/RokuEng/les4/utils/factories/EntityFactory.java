package com.RokuEng.les4.utils.factories;

import com.RokuEng.les4.core.domains.Entity;
import com.RokuEng.les4.core.domains.npc.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityFactory {

    public Entity createArcher() {
        return new Archer(0.1f);
    }

    public Entity createDwarf() {
        return new Dwarf(1f);
    }

    public Entity createElf() {
        return new Elf(1f);
    }

    public Entity createMage() {
        return new Mage(0.05f);
    }

    public Entity createWarrior() {
        return new Warrior(0.3f);
    }
}
