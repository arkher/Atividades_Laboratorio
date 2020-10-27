package com.example.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EquationDTO {
    double x;
    double y;
}
