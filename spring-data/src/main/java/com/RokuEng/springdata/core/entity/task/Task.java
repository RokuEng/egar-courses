package com.RokuEng.springdata.core.entity.task;

import com.RokuEng.springdata.core.entity.hero.Hero;
import com.RokuEng.springdata.core.entity.location.Location;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private Integer award;

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "hero_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "hero_id")
    )
    private List<Hero> heroes;
}
