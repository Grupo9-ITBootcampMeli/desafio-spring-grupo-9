package br.com.group9.springapplicationgroup9.Controller;

/**Classe para o Controller da Aplicação Springboot que lida com as requisições para os recursos associados a entidade
 * de purchases (compras), onde serão contidos, valores e métodos para a mesma.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

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

    /**Método post para inserir uma compra na persistência de um arquivo Json.
     * Ele chama o Service de purchases que detêm as regras de negócio e retorna uma ResponseEntity com o DTO das informações da compra.

     * @param purchaseList @RequestBody List<RequestPurchaseDTO> - Payload que o client manda pelo RequestBody e que deseja inserir a persistência.
     * @return ResponseEntity<PurchaseDTO>> - Entidade de resposta que carrega o statuscode e DTO com a lista de produtos adquirida, o valor do pedido e o id.
     */

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

    /**Método get para consultar o valor total de todos os pedidos presentes na persistência.
     * Ele chama o Service de purchases que detêm as regras de negócio e retorna uma ResponseEntity com o valor total.
     * @return retorno BigDecimal - Valor total das compras na persistência.
     */

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
