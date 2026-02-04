package com.keisar.Hotel.Management.controller;

import com.keisar.Hotel.Management.dto.request.HotelRequestDTO;
import com.keisar.Hotel.Management.dto.request.HotelUpdateAddressDTO;
import com.keisar.Hotel.Management.dto.response.HotelResponseDTO;
import com.keisar.Hotel.Management.repository.HotelRepository;
import com.keisar.Hotel.Management.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotelmanagement")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelResponseDTO> createHotel(@RequestBody HotelRequestDTO hotelRequestDTO){
        return ResponseEntity.status(201).body(hotelService.createHotel(hotelRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id,@RequestBody HotelUpdateAddressDTO updateAddressDTO){
        return ResponseEntity.ok(hotelService.updateHotel(id, updateAddressDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        return ResponseEntity.status(204).build();
    }

}
