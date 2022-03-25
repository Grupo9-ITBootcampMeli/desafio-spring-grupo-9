package br.com.group9.springapplicationgroup9.Repository;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.Interfaces.IRepository;
import br.com.group9.springapplicationgroup9.Util.ProductHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Repository

/**Classe que implementa a abstração na forma de Repositório de produtos responsável por gerenciar as leituras e
 * inserções de produtos.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

public class ProductRepository implements IRepository<Product, Long> {


    /**Ferramenta utilizada para encapsular os métodos de leitura e escrita nos arquivos Json para o repositório de produtos.
     * inserções de purchases (compras).
     */
    @Autowired
    private ProductHandler jsonFile;

    /**Método responsável por adicionar uma instância de um produto recebida como parâmetro ao arquivo .json utilizando
     * a função save do handler para fazê-lo.
     * @param newProduct Product - Instância do produto a ser persistido no arquivo.
     */
    @Override
    public void add(Product newProduct) {
        List<Product> products = jsonFile.read();
        products.add(newProduct);
        jsonFile.save(products);
    }

    /**Método responsável por adicionar as instâncias de produtos recebidas como parâmetro ao arquivo .json utilizando
     * a função save do handler para fazê-lo.
     * @param newProducts List<Product> - Lista das instâncias dos produtos a serem persistidos no arquivo .json.
     */

    @Override
    public void addAll(List<Product> newProducts) {
        List<Product> products = jsonFile.read();
        products.addAll(newProducts);
        jsonFile.save(products);
    }

    @Override
    public Product get(Long id) {
        return jsonFile.read().stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }

    /**Método responsável por retornar uma as persistências dos produtos presentes arquivo .json utilizando
     * a função read do handler para fazê-lo.
     * @return  List<Product> - Lista com as instâncias dos produtos persistidos no arquivo .json.
     */

    @Override
    public List<Product> getAll() {
        return jsonFile.read();
    }
}
