package com.RokuEng.les4.util.factories;

import com.RokuEng.les4.core.domain.Entity;
import com.RokuEng.les4.core.domain.playable.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityFactory {

    public Entity createArcher() {
        return new Archer(10);
    }

    public Entity createDwarf() {
        return new Dwarf(100);
    }

    public Entity createElf() {
        return new Elf(100);
    }

    public Entity createMage() {
        return new Mage(5, 100);
    }

    public Entity createWarrior() {
        return new Warrior(30);
    }
}
