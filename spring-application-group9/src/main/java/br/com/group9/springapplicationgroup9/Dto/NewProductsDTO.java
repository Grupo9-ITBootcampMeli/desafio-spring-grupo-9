package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
// DTO para o endpoint de GET
public class NewProductsDTO {
    private Long productId;
    private String name;
    private Integer quantity;


    public NewProductsDTO converte(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        return this;
    }

    public static List<NewProductsDTO> converte(List<Product> products) {
        return products.stream().map(
                p -> new NewProductsDTO(p.getProductId(), p.getName(), p.getQuantity())
        ).collect(Collectors.toList());
    }
}