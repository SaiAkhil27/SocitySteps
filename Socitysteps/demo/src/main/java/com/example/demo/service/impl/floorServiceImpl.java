package com.example.demo.service.impl;


import com.example.demo.dto.FloorDto;
import com.example.demo.entities.Apartment;
import com.example.demo.entities.Floor;
import com.example.demo.repositories.ApartmentRepository;
import com.example.demo.repositories.FloorRepository;
import com.example.demo.service.FloorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class floorServiceImpl implements FloorService {

    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FloorDto addFloor(FloorDto dto) {
        Apartment apartment = apartmentRepository.findById(dto.getApartmentId())
                .orElseThrow(()->new RuntimeException("Apartment with given id is not found"));

       Floor floor = modelMapper.map(dto,Floor.class);
       floor.setApartment(apartment);
       int num_floors = dto.getFloor_number();
       Floor saved = floorRepository.save(floor);
       return modelMapper.map(saved,FloorDto.class);
    }

    @Override
    public List<FloorDto> getAllFloors(Long id) {
          return floorRepository.findByApartmentId(id)
                  .stream()
                  .map(floor -> modelMapper.map(floor,FloorDto.class))
                  .collect(Collectors.toList());
       }

    @Override
    public FloorDto getFloorById(Long id) {
      Optional<Floor> floor = floorRepository.findById(id);

      if(floor.isPresent()){
          return modelMapper.map(floor,FloorDto.class);

      }else{
          throw new RuntimeException("Floor with given id is not present");
      }
    }
}
