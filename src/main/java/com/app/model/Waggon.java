package com.app.model;

import com.app.model.Enums.WaggonStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WAGGONS")
public class Waggon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_WAGGON", unique = true)
    private int idWaggon;

    @Column(name = "REGISTRATION_NUMBER")
    private String regNumber;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private WaggonStatus status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @JsonIgnore
    @OneToMany
    private List<Driver> drivers;

    @JsonIgnore
    @OneToOne(mappedBy = "currentWaggon")
//            , cascade = {CascadeType.ALL})
    private Order order;

    @Override
    public String toString() {
        return "Waggon{" +
                "idWaggon=" + idWaggon +
                ", regNumber='" + regNumber + '\'' +
                ", shiftSize=" + shiftSize +
                ", capacity=" + capacity +
                ", status=" + status +
                ", city=" + city +
                ", drivers=" + drivers +
                '}';
    }
}
