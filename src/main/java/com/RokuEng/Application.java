package com.RokuEng;

import com.RokuEng.les3.domains.GroupMessage;
import com.RokuEng.les3.domains.Message;
import com.RokuEng.les3.domains.PersonalMessage;

import java.time.Instant;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Message message = new PersonalMessage(
                "New message!",
                "/resources/images/Cat.png",
                Date.from(Instant.now())
        );

        Message anotherMessage = new GroupMessage(
                "New message!",
                "/resources/images/Cat.png",
                Date.from(Instant.now())
        );

        message.printContent();
        anotherMessage.printContent();

//        message.loadImage();
//        message.printDate();
    }
}
