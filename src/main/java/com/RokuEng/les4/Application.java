package com.RokuEng.les4;

import com.RokuEng.les4.core.domains.Entity;
import com.RokuEng.les4.utils.factories.EntityFactory;

public class Application {

    public static void main(String[] args) {
        Entity dwarf = EntityFactory.createDwarf();
        Entity elf = EntityFactory.createElf();
        Entity archer = EntityFactory.createArcher();
        Entity mage = EntityFactory.createMage();
        Entity warrior = EntityFactory.createWarrior();
    }

}
