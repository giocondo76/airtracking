package com.nc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loc_id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "location")
    private List<Device> devices;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "location")
    private List<Condition> conditions;

    @ManyToOne
    @JoinColumn(name = "type")
    private LocType locType;

     @ManyToOne
     @JoinColumn(name = "standart")
     private Standart standart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location() {
    }

    public Location(Integer id, String name, LocType locType, Standart standart) {
        this.id = id;
        this.name = name;
        this.locType = locType;
        this.standart = standart;
    }

    public LocType getLocType() {
        return locType;
    }

    public void setLocType(LocType locType) {
        this.locType = locType;
    }

    public Standart getStandart() {
        return standart;
    }

    public void setStandart(Standart standart) {
        this.standart = standart;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locType=" + locType +
                ", standart=" + standart +
                '}';
    }
}


