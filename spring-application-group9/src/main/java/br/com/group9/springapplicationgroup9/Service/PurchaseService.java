package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.RequestPurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.ResponsePurchaseDTO;
import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.ProductRepository;
import br.com.group9.springapplicationgroup9.Repository.PurchaseRepository;
import br.com.group9.springapplicationgroup9.Util.ProductHandler;
import br.com.group9.springapplicationgroup9.Util.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseService {
    private ProductRepository productRepository = new ProductRepository(new ProductHandler());
    private PurchaseRepository purchaseRepository = new PurchaseRepository(new PurchaseHandler());



    public PurchaseDTO createPurchase(List<RequestPurchaseDTO> purchaseList) throws Exception {
        List<Product> productList = productRepository.getAll();
        List<Product> returnList = new ArrayList<Product>();
        BigDecimal total = BigDecimal.ZERO;
        boolean contains = false;

        for (int i = 0; i < purchaseList.size(); i++) {
            contains = false;
            for (int j = 0; j < productList.size(); j++) {
                if (purchaseList.get(i).getProductId() == productList.get(j).getProductId()) {
                    if (purchaseList.get(i).getQuantity() > productList.get(j).getQuantity()) {
                        throw new Exception("O produto: " + productList.get(j).getName() + " não possuí essa quantidade em estoque");
                    }
                    contains = true;
                    Product product = new Product(productList.get(j), purchaseList.get(i).getQuantity());
                    returnList.add(product);
                    BigDecimal subTotal = productList.get(j).getPrice().multiply(BigDecimal.valueOf(purchaseList.get(i).getQuantity()));
                    total = total.add(subTotal);
                    break;
                }
            }
            if (!contains) {
                throw new Exception("O produto: " + purchaseList.get(i).getName() + " não existe na base de dados");
            }
        }
        PurchaseDTO purchase = new PurchaseDTO(returnList, total);
        purchaseRepository.add(purchase);
        return purchase;
    }

    public ResponsePurchaseDTO listAll() throws Exception {
        List<PurchaseDTO> purchaseList = purchaseRepository.getAll();
        if (purchaseList.size() == 0) {
            throw new Exception("Não há compras realizadas");
        }
        BigDecimal totalPurchase = purchaseList.stream().map(a -> a.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
        ResponsePurchaseDTO responsePurchaseDTO = new ResponsePurchaseDTO(purchaseList, totalPurchase);
        return responsePurchaseDTO;
    }

}
