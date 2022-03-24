package br.com.group9.springapplicationgroup9.Controller;


import br.com.group9.springapplicationgroup9.Dto.RequestPurchaseDTO;

import br.com.group9.springapplicationgroup9.Service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @PostMapping("/purchase")
    public ResponseEntity<Boolean> post (@RequestBody List<RequestPurchaseDTO> purchaseDTO){
        Boolean contains = new Boolean(PurchaseService.createPurchase(purchaseDTO));
        return ResponseEntity.ok(contains);
    }
}
