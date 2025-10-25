package com.example.demo.controllers;


import com.example.demo.dto.BlockDto;
import com.example.demo.entities.Block;
import com.example.demo.repositories.BlockRepository;
import com.example.demo.responses.APIResponse;
import com.example.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/block")
public class BlockController {

    @Autowired
    public BlockRepository blockRepository;

    @Autowired
    private BlockService blockService;

    @PostMapping("/add")
    public ResponseEntity<APIResponse<BlockDto>> createBlock(@RequestBody BlockDto block) {
        BlockDto saved = blockService.createBlock(block);
  return ResponseEntity.status(HttpStatus.CREATED)
          .body(new APIResponse<>("Block got created",saved));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<APIResponse<List<BlockDto>>> getAllTheBlocks(){
        List<BlockDto> blocks = blockService.getAllBlocks();
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new APIResponse<>("Got retrived successfyully",blocks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<BlockDto>> getBlockById(@PathVariable Long id){
        BlockDto block = blockService.getBlockById(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new APIResponse<>("Block with given Id",block));
    }
}
