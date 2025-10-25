package com.example.demo.service.impl;

import com.example.demo.dto.ApartmentDto;
import com.example.demo.entities.Apartment;
import com.example.demo.entities.Block;
import com.example.demo.repositories.ApartmentRepository;
import com.example.demo.repositories.BlockRepository;
import com.example.demo.service.ApartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class apartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApartmentDto addApartment(ApartmentDto dto){
        Block block = blockRepository.findById(dto.getBlockId())
                .orElseThrow(()-> new RuntimeException("Not found with block id"));

        Apartment apartment = modelMapper.map(dto,Apartment.class);
        apartment.setBlock(block);
        Apartment saved = apartmentRepository.save(apartment);
        return modelMapper.map(saved,ApartmentDto.class);

    }

    @Override
    public List<ApartmentDto> getAll(Long id){
        return apartmentRepository.findByBlockId(id)
                .stream()
                .map(apartment -> modelMapper.map(apartment,ApartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ApartmentDto getApartmentById(Long id) {
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if(apartment.isPresent()){
            return modelMapper.map(apartment,ApartmentDto.class);
        }else{
            throw new RuntimeException("Apartment with given id is absent");
        }
    }
}
