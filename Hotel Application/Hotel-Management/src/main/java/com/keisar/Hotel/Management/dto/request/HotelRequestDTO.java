package com.keisar.Hotel.Management.dto.request;

import lombok.Data;


@Data
public class HotelRequestDTO {
    private String name;
    private String city;
    private String address;
    private Long postalCode;
    private double rating;
    private boolean available;
}
