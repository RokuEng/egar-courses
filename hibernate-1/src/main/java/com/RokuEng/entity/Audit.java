package com.RokuEng.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@Data
@Embeddable
public class Audit {
    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @PrePersist
    public void create() {
        createDate = LocalDate.now();
    }

    @PreUpdate
    public void update() {
        updateDate = LocalDate.now();
    }
}
