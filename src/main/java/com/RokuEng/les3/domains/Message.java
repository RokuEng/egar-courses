package com.RokuEng.les3.domains;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.Date;

@ToString
public class Message {
    protected String content;

    private String imagePath;

    private Date date;

    @Getter
    private int readCount;

    public void printContent() {
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

    public Message(String content, String imagePath, Date date) {
        this.content = content;
        this.imagePath = imagePath;
        this.date = date;
    }
}
