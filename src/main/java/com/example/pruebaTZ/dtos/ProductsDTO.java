package com.example.pruebaTZ.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {

    private String id;
    @NotBlank(message = "El nombre es requerido")
    private String name;
    @Min(value = 0, message = "EL inventario no puede ser negativo")
    private Integer inventory;
    private Boolean enabled;
    @Min(value = 0, message = "EL mínimo no puede ser negativo")
    private Integer min;
    @Min(value = 0, message = "EL máximo no puede ser negativo")
    private Integer max;
}
