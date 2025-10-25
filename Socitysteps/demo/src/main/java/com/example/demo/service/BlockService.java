package com.example.demo.service;
import com.example.demo.dto.BlockDto;
import java.util.List;

public interface BlockService {
    BlockDto createBlock(BlockDto blockDto);
    List<BlockDto> getAllBlocks();
    BlockDto getBlockById(Long id);
}
