package com.keisar.Hotel.Management.dto.request;

import lombok.Data;


@Data
public class HotelUpdateAddressDTO {

    private String city;
    private String address;
    private Long postalCode;
}
