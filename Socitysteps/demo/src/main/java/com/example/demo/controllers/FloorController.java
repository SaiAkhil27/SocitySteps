package com.example.demo.controllers;

import com.example.demo.dto.FloorDto;
import com.example.demo.responses.APIResponse;
import com.example.demo.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @PostMapping("/add")
    public ResponseEntity<APIResponse<FloorDto>> createFloor(@RequestBody FloorDto dto){
     FloorDto saved = floorService.addFloor(dto);
     return ResponseEntity.status(HttpStatus.CREATED)
             .body(new APIResponse<>("new floor added",saved));
    }

    @GetMapping(value = "/apartment/{apartmentId}")
    public ResponseEntity<APIResponse<List<FloorDto>>> getAll(@PathVariable Long apartmentId){
        List<FloorDto> floorsList = floorService.getAllFloors(apartmentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new APIResponse<>("retried the floors",floorsList));
    }

    @GetMapping(value = "/{apartmentId}/{floorId}")
    public ResponseEntity<APIResponse<FloorDto>> getFloorById(@PathVariable Long floorId){
        FloorDto floorDto = floorService.getFloorById(floorId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new APIResponse<>("This is the floor with given ID" + floorId,floorDto));
    }


}
