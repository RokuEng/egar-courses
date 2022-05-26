package com.RokuEng.entity.hero;

import com.RokuEng.entity.Audit;
import com.RokuEng.entity.item.Item;
import com.RokuEng.entity.Persistent;
import com.RokuEng.entity.task.Task;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Hero implements Persistent<Integer> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private String name;

    private Float health;

    private Float damage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hero")
    private List<Item> items = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hero_task",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks = new ArrayList<>();

    @Embedded
    private Audit audit = new Audit();
}
