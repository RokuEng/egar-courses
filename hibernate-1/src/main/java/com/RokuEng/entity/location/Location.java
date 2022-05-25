package com.RokuEng.entity.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "x_cord")
    private BigDecimal x;

    @Column(name = "y_cord")
    private BigDecimal y;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private LocationType type;
}
