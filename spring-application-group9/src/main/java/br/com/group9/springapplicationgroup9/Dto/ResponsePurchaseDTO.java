package br.com.group9.springapplicationgroup9.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePurchaseDTO {
    private List<PurchaseDTO> purchaseList;
    private BigDecimal totalPurchase;

}
