package br.com.group9.springapplicationgroup9.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPurchaseDTO {

    private String name;
    private Long productId;
    private String brand;
    private Integer quantity;

    public static List<RequestPurchaseDTO> converte(List<RequestPurchaseDTO> purchase) {
        return purchase.stream().map(a -> new RequestPurchaseDTO(a.getName(), a.getProductId(), a.getBrand(), a.getQuantity())).collect(Collectors.toList());
    }
}
