package com.example.demo.dto;


import com.example.demo.entities.Apartment;

import java.util.ArrayList;
import java.util.List;

public class BlockDto {
    private Long id;
    private String name;

    private List<Apartment> appartmetsList;

    public BlockDto() {
    }

    public BlockDto(Long id, String name, List<Apartment> appartmetsList) {
        this.id = id;
        this.name = name;
        this.appartmetsList = appartmetsList;
    }

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
}
