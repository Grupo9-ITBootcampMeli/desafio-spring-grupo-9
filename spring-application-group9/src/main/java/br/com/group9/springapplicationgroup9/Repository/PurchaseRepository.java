package br.com.group9.springapplicationgroup9.Repository;


import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;

import br.com.group9.springapplicationgroup9.Repository.Interfaces.IPurchaseRepository;
import br.com.group9.springapplicationgroup9.Util.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Repository
/**Classe que implementa a abstração na forma de Repositório de compras responsável por gerenciar as leituras e
 * inserções de purchases (compras).
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

public class PurchaseRepository implements IPurchaseRepository<PurchaseDTO> {

/**Ferramenta utilizada para encapsular os métodos de leitura e escrita nos arquivos Json para o repositório de compras.
 * inserções de purchases (compras).
 */
    @Autowired
    private PurchaseHandler jsonFile;

    /**Método responsável por adicionar uma instância de uma compra recebida como parâmetro ao arquivo .json utilizando
     * a função save do handler para fazê-lo.
     * @param newPurchase PurchaseDTO - Instância do produto a ser persistido no arquivo.
     */

    @Override
    public void add(PurchaseDTO newPurchase) {
        List<PurchaseDTO> purchases = jsonFile.read();
        purchases.add(newPurchase);
        jsonFile.save(purchases);
    }


    /**Método responsável por retornar uma as persistências das compras presentes arquivo .json utilizando
     * a função read do handler para fazê-lo.
     * @return  List<PurchaseDTO> - Lista com as instâncias das compras persistidas no arquivo .json.
     */
    @Override
    public List<PurchaseDTO> getAll() {
        return jsonFile.read();
    }

}
