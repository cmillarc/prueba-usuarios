package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @NotBlank
    private String number;

    @NotBlank
    private String cityCode;

    @NotBlank
    private String countryCode;
}
