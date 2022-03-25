package br.com.group9.springapplicationgroup9.Controller;

/**Classe para o Controller da Aplicação Springboot que lida com as requisições para os recursos associados a entidade
 * de produto, onde serão contidos, valores e métodos para o mesmo.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

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

/**Método post para inserir produtos na persistência de um arquivo Json.
            * Ele chama o Service de produto que detêm as regras de negócio e retorna uma ResponseEntity com o DTO dos novos produtos.

 * @param product @RequestBody List<Product> - Payload que o client manda pelo RequestBody e que deseja inserir a persistência.
 * @return ResponseEntity<List<NewProductsDTO>> - Entidade de resposta que carrega o statuscode e DTO com a lista de produtos inserida.
 */

    @PostMapping("/v1/insert-articles")
    public ResponseEntity<List<NewProductsDTO>> insertArticles(@RequestBody List<Product> product){
        productService.registerProducts(product);
        List<NewProductsDTO> result = NewProductsDTO.converte(product);
        return ResponseEntity.ok(result);
    }

    /**Método get para consultar a lista de produtos na persistência de um arquivo Json.
     * Ele chama o Service de produto que detêm as regras de negócio e retorna uma ResponseEntity a lista de produtos filtrada.
     * e ordenada de acordo com os RequestParams informados.
     * @param params @RequestParam Map<String, String> - Filtros que o cliente deseja aplicar a consulta.
     * @param order @RequestParam Integer - Integer que dita a ordenação desejada pelo client.
     * @return ResponseEntity<List<ProductoDTO>> - Entidade de resposta que carrega o statuscode e DTO com a lista dos produtos.
     */

    @GetMapping("/v1/articles")
    public ResponseEntity<List<ProductoDTO>> getArticles(
            @RequestParam Map<String, String> params,
            @RequestParam (name = "order", required = false) Integer order
    ) {
        List<ProductoDTO> result = ProductoDTO.converte(productService.listProducts(params, order));
        return ResponseEntity.ok(result);
    }

}
