package com.RokuEng.entity.task;

import com.RokuEng.entity.hero.Hero;
import com.RokuEng.entity.location.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
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
