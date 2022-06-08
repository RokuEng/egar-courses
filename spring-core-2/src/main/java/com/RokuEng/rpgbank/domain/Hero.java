package com.RokuEng.rpgbank.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hero {
    private Integer id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private Float health;
    @EqualsAndHashCode.Exclude
    private Float damage;
}
