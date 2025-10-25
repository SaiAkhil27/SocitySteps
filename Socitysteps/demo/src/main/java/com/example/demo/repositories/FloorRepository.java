package com.example.demo.repositories;

import com.example.demo.entities.Block;
import com.example.demo.entities.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {
    List<Floor> findByApartmentId(Long apartmentId);
}
