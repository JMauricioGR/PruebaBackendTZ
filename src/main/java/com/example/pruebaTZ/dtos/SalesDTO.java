package com.example.pruebaTZ.dtos;

import com.example.pruebaTZ.collections.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDTO {

    private String id;
    @NotBlank(message = "Se debe incluir la fecha de la venta")
    private String date;
    private String idType;
    private String idNumber;
    private String clientName;
    private List<Products> products;
}
