package com.example.demo.dto;

import com.example.demo.entities.Room;

import java.util.List;

public class FloorDto {

    private Long id;
    private int floor_number;
    private Long apartmentId;
    private List<Room> roomList;

    public FloorDto() {
    }

    public FloorDto(Long id, int floor_number, Long apartmentId, List<Room> roomList) {
        this.id = id;
        this.floor_number = floor_number;
        this.apartmentId = apartmentId;
        this.roomList = roomList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
