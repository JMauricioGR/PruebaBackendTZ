package com.example.pruebaTZ.mapper;

import com.example.pruebaTZ.collections.Sales;
import com.example.pruebaTZ.dtos.SalesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SalesMapper {

    private ModelMapper mapper;

    public SalesMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Function<Sales, SalesDTO> saleToDTO(){
        return sale -> mapper.map(sale, SalesDTO.class);
    }

    public Function<SalesDTO, Sales> dtoToSale(){
        return saleDTO -> mapper.map(saleDTO, Sales.class);
    }
}
