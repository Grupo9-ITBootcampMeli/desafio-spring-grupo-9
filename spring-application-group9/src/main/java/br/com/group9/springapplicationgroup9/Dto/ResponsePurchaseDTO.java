package br.com.group9.springapplicationgroup9.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**Classe para DTO que será usado para parametrizar a resposta da requisição para inserir uma compra.
 * Ela parametriza a resposta adicionando o total da soma dos valores dos produtos adquiridos ao objeto que será
 * enviado pela entidade.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePurchaseDTO {
    private List<PurchaseDTO> purchaseList;
    private BigDecimal totalPurchase;

}
