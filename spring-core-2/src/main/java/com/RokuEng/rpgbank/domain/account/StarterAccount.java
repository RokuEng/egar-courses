package com.RokuEng.rpgbank.domain.account;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class StarterAccount implements Account {
    private Float money = 0f;
}
