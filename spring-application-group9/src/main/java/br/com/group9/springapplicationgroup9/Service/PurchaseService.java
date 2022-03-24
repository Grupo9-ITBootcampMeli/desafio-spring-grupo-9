package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;
import br.com.group9.springapplicationgroup9.Dto.RequestPurchaseDTO;
import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseService {

    private ProductRepository repository;

    public Boolean createPurchase(List<RequestPurchaseDTO> listProducts) {
//        return purchasedto
        List<Product> repositoryProducts = repository.getAll();
        System.out.println(repositoryProducts);
        Boolean contains = listProducts.stream().allMatch(product -> repositoryProducts.contains(product.getProductId()));
        if (contains == null) {
            contains = false;
        }
        return contains;
    };

//    check if product exists
//    private boolean checkExists

//    check if stock > purchase quantity bonus


//    add PurchaseId and total to purchase


//    add purchase to repository


//    call to DTO
}
