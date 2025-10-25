package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "this field is IMP")
    private String name;
    @Min(value = 1)
    @Max(value = 14)
    private int totalFloors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    @ManyToOne
    @JoinColumn(name = "block_id")
    @JsonBackReference
    private Block block;

    @OneToMany(mappedBy = "apartment",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Floor> floorList = new ArrayList<>();

    public Apartment(Long id, String name, int totalFloors, Block block, List<Floor> floorList) {
        this.id = id;
        this.name = name;
        this.totalFloors = totalFloors;
        this.block = block;
        this.floorList = floorList;
    }

    public Apartment() {
    }
}
