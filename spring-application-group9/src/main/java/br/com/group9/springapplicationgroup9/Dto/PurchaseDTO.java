package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    public static int purchaseCount = 1;
    private int purchaseId;
    private BigDecimal total;
    private List<Product> products;

    public PurchaseDTO(List<Product> products, BigDecimal total){
        this.products = products;
        this.total = total;
        this.purchaseId = purchaseCount;
        purchaseCount++;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "purchaseId=" + purchaseId +
                ", total=" + total +
                ", products=" + products +
                '}';
    }
}
