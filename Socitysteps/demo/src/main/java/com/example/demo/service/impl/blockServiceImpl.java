package com.example.demo.service.impl;

import com.example.demo.dto.BlockDto;
import com.example.demo.entities.Block;
import com.example.demo.repositories.BlockRepository;
import com.example.demo.service.BlockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class blockServiceImpl implements BlockService {

    @Autowired
  private BlockRepository blockRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BlockDto createBlock(BlockDto blockDto) {
        Block block = modelMapper.map(blockDto,Block.class);
        blockRepository.save(block);
        return modelMapper.map(block,BlockDto.class);
    }

    @Override
    public List<BlockDto> getAllBlocks() {
       return blockRepository.findAll()
               .stream()
               .map((block -> modelMapper.map(block,BlockDto.class)))
               .collect(Collectors.toList());
    }

    @Override
    public BlockDto getBlockById(Long id) {
        Optional<Block> block = blockRepository.findById(id);

        if(block.isPresent()){
            return modelMapper.map(block,BlockDto.class);
        }else{
            throw new RuntimeException("Block with given id is not present");
        }
    }
}
