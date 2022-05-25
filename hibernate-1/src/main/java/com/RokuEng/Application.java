package com.RokuEng;

import com.RokuEng.dao.WarriorDao;
import com.RokuEng.entity.Hero;
import com.RokuEng.entity.Warrior;

public class Application {
    public static void main(String[] args) {
        WarriorDao dao = new WarriorDao();

        dao.save(new Warrior(new Hero("Warrior", 100F, 991F)));

        System.out.println(dao.findById(6));
    }
}
