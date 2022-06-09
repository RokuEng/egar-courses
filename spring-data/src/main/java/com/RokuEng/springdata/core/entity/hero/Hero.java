package com.RokuEng.springdata.core.entity.hero;

import com.RokuEng.springdata.core.entity.Audit;
import com.RokuEng.springdata.core.entity.Persistent;
import com.RokuEng.springdata.core.entity.item.Item;
import com.RokuEng.springdata.core.entity.task.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Hero implements Persistent<Integer> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    private Float health;

    private Float damage;

    @Column(name = "cache")
    private BigDecimal cache;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hero")
    private List<Item> items = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hero_task",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks = new ArrayList<>();

    @Embedded
    private Audit audit = new Audit();
}
