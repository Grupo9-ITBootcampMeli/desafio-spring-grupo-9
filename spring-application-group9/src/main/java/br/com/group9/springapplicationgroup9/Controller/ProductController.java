package br.com.group9.springapplicationgroup9.Controller;

import br.com.group9.springapplicationgroup9.Dto.NewProductsDTO;
import br.com.group9.springapplicationgroup9.Dto.ProductoDTO;
import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/v1/insert-articles")
    public ResponseEntity<List<NewProductsDTO>> insertArticles(@RequestBody List<Product> product){
        productService.registerProducts(product);
        List<NewProductsDTO> result = NewProductsDTO.converte(product);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/v1/articles")
    public ResponseEntity<List<ProductoDTO>> getArticles(
            @RequestParam Map<String, String> params,
            @RequestParam (name = "order", required = false) Integer order
    ) {
        List<ProductoDTO> result = ProductoDTO.converte(productService.listProducts(params, order));
        return ResponseEntity.ok(result);
    }

}
