package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**Classe para DTO que será retornado na requisição insertArticles no controle de produto.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */
public class NewProductsDTO {
    private Long productId;
    private String name;
    private Integer quantity;


    /**Método usado no controller para converter a lista de produtos recebida pelo client em uma lista de Dtos de produto
     * a ser enviada na response.

     * @param products List<Product> - Recebe a lista de produtos que o cliente deseja persistir.
     * @return List<NewProductsDTO> - Retorna a lista de produtos para response após a inserção ser realizada.
     */


    public static List<NewProductsDTO> converte(List<Product> products) {
        return products.stream().map(
                p -> new NewProductsDTO(p.getProductId(), p.getName(), p.getQuantity())
        ).collect(Collectors.toList());
    }
}