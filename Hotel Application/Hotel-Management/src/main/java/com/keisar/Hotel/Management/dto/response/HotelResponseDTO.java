package com.keisar.Hotel.Management.dto.response;

import lombok.Data;

@Data
public class HotelResponseDTO {
    private Long id;
    private String name;
    private String city;
    private String address;
    private Long postalCode;
    private double rating;
    private boolean available;
}
