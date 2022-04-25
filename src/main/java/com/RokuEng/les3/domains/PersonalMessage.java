package com.RokuEng.les3.domains;

import java.util.Date;

public class PersonalMessage extends Message {

    @Override
    public void printContent() {
        System.out.println("НЕ ДЛЯ ВСЕХ ПОЛЬЗОВАТЕЛЕЙ! " + getContent());
    }

    public PersonalMessage(String content, String imagePath, Date date) {
        super(content, imagePath, date);
    }
}
