package com.RokuEng.springrest.domain.hero;

import com.RokuEng.springrest.domain.Persistent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Hero extends Persistent<Integer> {
    private String name;

    private Float health;

    private Float damage;
}
