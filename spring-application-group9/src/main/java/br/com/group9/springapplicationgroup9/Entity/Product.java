package br.com.group9.springapplicationgroup9.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;

    // Construtor de produto para compra
    public Product(Product product, int purchaseQty) {
        productId = product.getProductId();
        name = product.getName();
        category = product.getCategory();
        brand = product.getBrand();
        price = product.getPrice();
        quantity = purchaseQty;
        freeShipping = product.getFreeShipping();
        prestige = product.getPrestige();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", freeShipping=" + freeShipping +
                ", prestige='" + prestige + '\'' +
                '}';
    }
}
