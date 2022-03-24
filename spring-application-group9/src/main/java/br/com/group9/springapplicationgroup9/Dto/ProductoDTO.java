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
public class ProductoDTO {

    private Long productId;
    private String name;
    private BigDecimal price;
    private Boolean freeShipping;
    private String prestige;

    public ProductoDTO converte(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.freeShipping = product.getFreeShipping();
        this.prestige = product.getPrestige();
        return this;
    }

    public static List<ProductoDTO> converte(List<Product> products) {
        return products.stream().map(
                p -> new ProductoDTO(p.getProductId(), p.getName(), p.getPrice(), p.getFreeShipping(), p.getPrestige())
        ).collect(Collectors.toList());
    }
}