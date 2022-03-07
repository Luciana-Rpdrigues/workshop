package com.luciana.desafio.workshop.dto.request;

import com.luciana.desafio.workshop.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
