package com.RokuEng.les3.domains;

import lombok.SneakyThrows;

import java.util.Date;

public class Message {

    private String content;
    private String imagePath;
    private Date date;
    private int readCount;

    public void printMessage() {
        System.out.println(content);
    }

    @SneakyThrows
    public void loadImage() {
        System.out.println("Идёт процесс загрузки по пути: " + imagePath);
        Thread.sleep(1000);
        System.out.println("Картинка загружена!");
    }

    public void printDate() {
        System.out.println(date);
    }
}
