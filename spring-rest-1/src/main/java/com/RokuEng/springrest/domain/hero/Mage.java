package com.RokuEng.springrest.domain.hero;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Mage extends Hero {

    private Integer mana;

}
