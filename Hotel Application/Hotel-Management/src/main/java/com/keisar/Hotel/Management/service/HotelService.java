package com.keisar.Hotel.Management.service;

import com.keisar.Hotel.Management.dto.response.HotelResponseDTO;
import com.keisar.Hotel.Management.dto.request.HotelRequestDTO;
import com.keisar.Hotel.Management.dto.request.HotelUpdateAddressDTO;
import com.keisar.Hotel.Management.exception.ResourceNotFoundException;
import com.keisar.Hotel.Management.model.Hotel;
import com.keisar.Hotel.Management.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    public HotelResponseDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = modelMapper.map(hotelRequestDTO, Hotel.class);
        return modelMapper.map(hotelRepository.save(hotel), HotelResponseDTO.class);
    }

    public List<HotelResponseDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotel-> modelMapper.map(hotel, HotelResponseDTO.class))
                .collect(Collectors.toList());
    }

    public HotelResponseDTO updateHotel(Long id, HotelUpdateAddressDTO updateAddressDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Nenhum hotel encontrado, com o Id passado"));
        modelMapper.map(updateAddressDTO, hotel);
        return modelMapper.map(hotelRepository.save(hotel), HotelResponseDTO.class);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new ResourceNotFoundException("Nenhum hotel encontrado, com o Id passado");
        }
        hotelRepository.deleteById(id);
    }






}
