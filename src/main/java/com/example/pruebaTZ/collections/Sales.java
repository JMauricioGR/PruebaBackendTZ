package com.example.pruebaTZ.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "sales")
public class Sales {
    @Id
    private String id;
    private String date;
    private String name;
    private String idType;
    private String idNumber;
    private String clientName;
    private List<Products> products;
}
