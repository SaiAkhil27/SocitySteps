package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "block",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference

    private List<Apartment> appartmetsList = new ArrayList<>();

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

    public List<Apartment> getAppartmetsList() {
        return appartmetsList;
    }

    public void setAppartmetsList(List<Apartment> appartmetsList) {
        this.appartmetsList = appartmetsList;
    }

    public Block() {
    }

    public Block(Long id, String name, List<Apartment> appartmetsList) {
        this.id = id;
        this.name = name;
        this.appartmetsList = appartmetsList;
    }
}
