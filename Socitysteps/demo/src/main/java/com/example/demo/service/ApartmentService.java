package com.example.demo.service;

import com.example.demo.dto.ApartmentDto;

import java.util.List;

public interface ApartmentService {
    ApartmentDto addApartment(ApartmentDto dto);
     List<ApartmentDto> getAll(Long id);

     ApartmentDto getApartmentById(Long id);


    }
