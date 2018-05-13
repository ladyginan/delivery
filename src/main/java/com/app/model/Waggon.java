package com.app.model;

import com.app.model.Enums.WaggonStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="WAGGONS")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Waggon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DRIVER", unique = true)
    private String IdWaggon;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Column(name = "STATUS")
    private WaggonStatus status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;
}
