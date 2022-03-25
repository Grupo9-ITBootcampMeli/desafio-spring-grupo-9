package br.com.group9.springapplicationgroup9.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Purchase {
    protected int purchaseId = 1;
    private List<Product> products;
    private BigDecimal total;

    public Purchase(List<Product> products, BigDecimal total){
        this.products = products;
        this.total = total;
        this.purchaseId = this.getPurchaseId();
        this.setPurchaseId(this.getPurchaseId() + 1);
    }
}
