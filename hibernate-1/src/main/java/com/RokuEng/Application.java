package com.RokuEng;

import com.RokuEng.dao.MageDao;

public class Application {
    public static void main(String[] args) {
        MageDao dao = new MageDao();
        System.out.println(dao.findByHealthGreaterMoreThat(110F));
    }
}
