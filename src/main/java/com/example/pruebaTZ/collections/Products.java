package com.example.pruebaTZ.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Products {
    @Id
    private String id;
    private String name;
    private Boolean enabled;
    private Integer min;
    private Integer max;
    private Integer inventory;
}
