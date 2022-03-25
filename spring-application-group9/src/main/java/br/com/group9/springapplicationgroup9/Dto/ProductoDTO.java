package br.com.group9.springapplicationgroup9.Dto;

import br.com.group9.springapplicationgroup9.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**Classe para DTO que será retornado na requisição getArticles no controle de produto.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
// DTO para o endpoint de GET
public class ProductoDTO {

    private Long productId;
    private String name;
    private BigDecimal price;
    private Boolean freeShipping;
    private String prestige;

    /**Método usado no controller para enviar a consulta ao cliente quando o mesmo realiza uma requisição get.

     * @param products List<Product> - Recebe a lista de produtos que estão no repositório.
     * @return List<ProductoDTO> - Retorna a lista de produtos em forma Dto.
     */


    public static List<ProductoDTO> converte(List<Product> products) {
        return products.stream().map(
                p -> new ProductoDTO(p.getProductId(), p.getName(), p.getPrice(), p.getFreeShipping(), p.getPrestige())
        ).collect(Collectors.toList());
    }
}