package com.RokuEng.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Float health;

    @Column(name = "damage")
    private Float damage;

    public Hero(String name, Float health, Float damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
}
