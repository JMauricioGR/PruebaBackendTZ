package com.example.pruebaTZ.useCases.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.mapper.SalesMapper;
import com.example.pruebaTZ.repositories.ISalesReository;
import com.example.pruebaTZ.useCases.sales.interfaces.UpdateSale;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdateSaleUseCase implements UpdateSale {
    private final ISalesReository repository;
    private final SalesMapper mapper;

    @Override
    public Mono<SalesDTO> apply(String id, SalesDTO salesDTO) {
        return repository
                .findById(id)
                .flatMap(sale -> {
                    salesDTO.setId(sale.getId());

                    return repository
                            .save(mapper
                                    .dtoToSale()
                                    .apply(salesDTO))
                            .map(result -> mapper.saleToDTO().apply(result));
                }).switchIfEmpty(Mono.just(new SalesDTO()));
    }
}
