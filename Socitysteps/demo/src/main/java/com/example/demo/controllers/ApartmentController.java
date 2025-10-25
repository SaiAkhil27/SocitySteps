package com.example.demo.controllers;


import com.example.demo.dto.ApartmentDto;
import com.example.demo.responses.APIResponse;
import com.example.demo.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @PostMapping("/add")
    public ResponseEntity<APIResponse<ApartmentDto>> createNewApartment(@RequestBody ApartmentDto dto){
        ApartmentDto saved  = apartmentService.addApartment(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>("Apartment got Created",saved));
    }

    @GetMapping("/block/{BlockId}")
    public ResponseEntity<APIResponse<List<ApartmentDto>>> getAll(@PathVariable Long BlockId){
        List<ApartmentDto> apartments = apartmentService.getAll(BlockId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new APIResponse<>("Retrived Successfully",apartments));
    }

    @GetMapping("/block/{blockId}/{apartmentId}")
    public ResponseEntity<APIResponse<ApartmentDto>> getById(@PathVariable Long apartmentId){
        ApartmentDto apartmentDto = apartmentService.getApartmentById(apartmentId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new APIResponse<>("Apartment with Given ID" + apartmentId,apartmentDto));
    }


}
