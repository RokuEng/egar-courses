package com.RokuEng;

import com.RokuEng.dao.MageDao;
import com.RokuEng.entity.hero.Hero;
import com.RokuEng.entity.hero.Mage;

public class Application {
    public static void main(String[] args) {
        MageDao dao = new MageDao();

        System.out.println(dao.findByNameAndAndDamage("% %", 100f, 100f));
    }
}
