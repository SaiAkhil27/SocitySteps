package com.example.demo.service;

import com.example.demo.dto.FloorDto;
import com.example.demo.entities.Floor;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FloorService  {

    FloorDto addFloor(FloorDto dto);
    List<FloorDto> getAllFloors(Long id);

    FloorDto getFloorById(Long id);

}
