package br.com.group9.springapplicationgroup9.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**Classe para DTO que será usado para parametrizar os objetos recebidos na requisição post no controle de purchases.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPurchaseDTO {

    private String name;
    private Long productId;
    private String brand;
    private Integer quantity;

}
