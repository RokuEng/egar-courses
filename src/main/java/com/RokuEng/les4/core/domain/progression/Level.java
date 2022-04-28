package com.RokuEng.les4.core.domain.progression;

import com.RokuEng.les4.core.domain.Entity;
import com.RokuEng.les4.core.domain.playable.*;
import lombok.Getter;

import java.util.Map;

@Getter
public enum Level {

    L1(Map.of(
            Archer.class, new Tuple(1f, 1f),
            Dwarf.class, new Tuple(1f, 1f),
            Elf.class, new Tuple(1f, 1f),
            Mage.class, new Tuple(1f, 1f),
            Warrior.class, new Tuple(1f, 1f)
    )),
    L2(Map.of(
            Archer.class, new Tuple(1.1f, 2f),
            Dwarf.class, new Tuple(1.3f, 1.1f),
            Elf.class, new Tuple(2f, 1f),
            Mage.class, new Tuple(1f, 2f),
            Warrior.class, new Tuple(1.4f, 1.1f)
    )),
    L3(Map.of(
            Archer.class, new Tuple(1.2f, 3f),
            Dwarf.class, new Tuple(1.3f, 1.1f),
            Elf.class, new Tuple(2f, 1f),
            Mage.class, new Tuple(3f, 2f),
            Warrior.class, new Tuple(1.4f, 1.1f)
    )),
    L4(Map.of(
            Archer.class, new Tuple(1.3f, 4f),
            Dwarf.class, new Tuple(1.3f, 1.1f),
            Elf.class, new Tuple(2f, 1f),
            Mage.class, new Tuple(2f, 2f),
            Warrior.class, new Tuple(1.4f, 1.1f)
    )),
    L5(Map.of(
            Archer.class, new Tuple(1.4f, 5f),
            Dwarf.class, new Tuple(1.3f, 1.1f),
            Elf.class, new Tuple(2f, 1f),
            Mage.class, new Tuple(2f, 2f),
            Warrior.class, new Tuple(6.4f, 1.1f)
    )),
    ;

    private final Map<Class<? extends Entity>, Tuple> entities;

    public Tuple getTuple(Entity entity) {
        return entities.get(entity.getClass());
    }

    Level(Map<Class<? extends Entity>, Tuple> entities) {
        this.entities = entities;
    }
}
