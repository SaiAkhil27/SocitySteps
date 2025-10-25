package com.example.demo.repositories;

import com.example.demo.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
    List<Apartment> findByBlockId(Long blockId);

}
