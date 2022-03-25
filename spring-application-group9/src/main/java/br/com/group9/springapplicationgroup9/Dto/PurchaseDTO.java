package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**Classe para DTO que será retornado na requisição post no controle de purchases.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    public static int purchaseCount = 1;
    private int purchaseId;
    private BigDecimal total;
    private List<Product> products;

    /**Método construtor chamado pelo controller após checagem das regras de negócios pelo service. Responsável por
     * formar o DTO da compra que será retornado no caso de uma inserção bem sucedida

     * @param products List<Product> - Recebe a lista de produtos que o cliente deseja persistir.
     * @param total BigDecimal - Recebe a lista de produtos que o cliente deseja persistir.
     * @return PurchaseDTO - Retorna o DTO da compra com a lista de produtos, o total e o id, incrementa o atributo
     * estático purchaseCount para inserção como id da próxima compra.
     */

    public PurchaseDTO(List<Product> products, BigDecimal total){
        this.products = products;
        this.total = total;
        this.purchaseId = purchaseCount;
        purchaseCount++;
    }

}
