package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;

    private Double monthlyRent;
    private Double costOfFalt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Resident> residents = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "room_maintenance", joinColumns = @JoinColumn(name = "room_id"))
    @MapKeyColumn(name = "month")
    @Column(name = "amount")
    private Map<String, Double> monthlyMaintenance = new HashMap<>();

}
