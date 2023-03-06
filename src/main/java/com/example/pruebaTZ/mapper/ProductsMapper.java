package com.example.pruebaTZ.mapper;

import com.example.pruebaTZ.collections.Products;
import com.example.pruebaTZ.dtos.ProductsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductsMapper {

    private ModelMapper mapper;

    public ProductsMapper(ModelMapper mapper){this.mapper = mapper;}

    public Function<Products, ProductsDTO> productsToDTO() {
        return products -> mapper.map(products, ProductsDTO.class);
    }

    public Function<ProductsDTO, Products> dtoTOProducts(){
        return productsDTO -> mapper.map(productsDTO,Products.class);
    }
}
