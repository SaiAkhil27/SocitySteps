package com.example.demo.dto;

import com.example.demo.entities.Floor;

import java.util.List;

public class ApartmentDto {


    private Long id;
    private String name;
    private int totalFloors;
    private Long blockId;
    private List<Floor> floorList;

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public ApartmentDto(Long id, String name, int totalFloors, Long blockId, List<Floor> floorList) {
        this.id = id;
        this.name = name;
        this.totalFloors = totalFloors;
        this.blockId = blockId;
        this.floorList = floorList;
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

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }



    public ApartmentDto() {
    }
}
