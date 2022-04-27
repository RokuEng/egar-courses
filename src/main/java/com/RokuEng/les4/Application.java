package com.RokuEng.les4;

import com.RokuEng.les4.core.domains.Entity;
import com.RokuEng.les4.core.domains.item.armor.Boots;
import com.RokuEng.les4.core.domains.item.armor.Chestplate;
import com.RokuEng.les4.util.factories.EntityFactory;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        Entity dwarf = EntityFactory.createDwarf();
        dwarf.getProtects().add(new Boots());

        Entity elf = EntityFactory.createElf();
        elf.getProtects().addAll(List.of(
                new Chestplate(),
                new Chestplate(),
                new Chestplate()
        ));

        Entity archer = EntityFactory.createArcher();
        Entity mage = EntityFactory.createMage();
        Entity warrior = EntityFactory.createWarrior();

        dwarf.attack(elf);
        elf.attack(archer);
        archer.attack(mage);
        mage.attack(warrior);
        warrior.attack(dwarf);

        System.out.println();
    }

}
