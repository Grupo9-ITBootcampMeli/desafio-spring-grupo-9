package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseDTO {

    private Long id;
    private BigDecimal total;
    private List<Product> products;
}
