package br.com.group9.springapplicationgroup9.Controller;


import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.RequestPurchaseDTO;


import br.com.group9.springapplicationgroup9.Dto.ResponsePurchaseDTO;
import br.com.group9.springapplicationgroup9.Service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PurchaseController {

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseDTO> post(@RequestBody List<RequestPurchaseDTO> purchaseList) {
        PurchaseService purchaseService = new PurchaseService();
        PurchaseDTO contains = new PurchaseDTO();

        try {
            contains = purchaseService.createPurchase(purchaseList);
            return ResponseEntity.ok(contains);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/purchase/total")
    public BigDecimal getTotal() {
        PurchaseService purchaseService = new PurchaseService();
        ResponsePurchaseDTO retorno;
        try {
            retorno = purchaseService.listAll();
            return retorno.getTotalPurchase();
        } catch (Exception e) {
            e.printStackTrace();
            return BigDecimal.ZERO;

        }
    }
}
