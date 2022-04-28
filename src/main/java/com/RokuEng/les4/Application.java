package com.RokuEng.les4;

import com.RokuEng.les4.core.domain.Entity;
import com.RokuEng.les4.core.domain.item.armor.Boots;
import com.RokuEng.les4.core.domain.item.armor.Chestplate;
import com.RokuEng.les4.core.domain.progression.Level;
import com.RokuEng.les4.util.factories.EntityFactory;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Entity dwarf = EntityFactory.createDwarf();
        dwarf.getProtects().add(new Boots());

        Entity elf = EntityFactory.createElf();
        elf.getProtects().addAll(List.of(
                new Chestplate(),
                new Chestplate()
        ));

        Entity archer = EntityFactory.createArcher();
        Entity mage = EntityFactory.createMage();
        Entity warrior = EntityFactory.createWarrior();

        dwarf.attack(elf);

        elf.attack(archer);
        elf.update(Level.L5);

        archer.attack(mage);
        archer.update(Level.L2);

        mage.attack(warrior);

        warrior.attack(dwarf);
        warrior.update(Level.L3);

        System.out.println();

        dwarf.attack(elf);

        elf.attack(archer);
        elf.update(Level.L5);

        archer.attack(mage);

        mage.attack(warrior);

        warrior.attack(dwarf);

        System.out.println();
    }

}
