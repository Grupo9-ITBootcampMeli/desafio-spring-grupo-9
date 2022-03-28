package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.ProductRepository;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;
import br.com.group9.springapplicationgroup9.Util.FilterEnum;
import br.com.group9.springapplicationgroup9.Util.OrderBy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Classe para o Service da Aplicação Springboot que lida com as requisições para os recursos associados a entidade
 * de produto, onde serão contidos, valores e métodos para o mesmo.
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    /**Método que recebe os RequestParams utilizados para listar produtos da persistência de um arquivo Json.
     * Ele checa os parâmetros recebidos validando e convertendo-os para as classes cadastradas em um Enum,
     * aplicando assim o filtro e/ou ordenação correspondentes.

     * @param params Map<String, String> - Hashmap com o filtro e ordenação escolhida.
     * @return Map<IFilter, String> - Retorna o filtro e ordenação a serem aplicados na função listProducts.
     */

    // Método para receber RequestParams e validar/converter para a classe cadastrada no Enum
    // Entrada: Map<String, String>
    // Saída:   Map<Filter, String>
    // OBS: Mantém o "value" informado pela RequestParam.
    private Map<IFilter, String> validateParams(Map<String, String> params) {
        return params.entrySet().stream()
            .filter(param -> FilterEnum.get(param.getKey()) != null)
            .map(param -> Map.entry(FilterEnum.get(param.getKey()).getFilter(), param.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**Método que recebe o corpo da requisição para registro de produtos na persistência e manda a mensagem
     * para o repositório prosseguir com o processo de inserção.

     * @param products List<Product> - Lista com os produtos a serem inseridos no repositório de produtos.
     */

    public void registerProducts(List<Product> products) {
        repository.addAll(products);
    }

    /**Método encarregado de filtrar e ordenar a consulta do cliente no repositório através do filtro e ordenação
     * solicitados.

     * @param params Map<String, String> - Hashmap com o filtro e ordenação escolhida.
     * @return List<Product> - Retorna a lista filtrada e com a ordenação escolhida pelo cliente.
     */

    public List<Product> listProducts(Map<String, String> params, Integer order) {
        Map<IFilter, String> filters = validateParams(params);
        List<Product> allProducts = repository.getAll();
        Stream<Product> productsToBeFiltered = allProducts.stream();
        for (Map.Entry<IFilter, String> param : filters.entrySet()) {
            IFilter filter = param.getKey();
            productsToBeFiltered = filter.applyStream(productsToBeFiltered, param.getValue());
        }
        OrderBy<Product> orderBy = new OrderBy(Product.class);
        ArrayList<Product> productsToBeOrdered = productsToBeFiltered.collect(Collectors.toCollection(ArrayList::new));
        if (order == null)
            return productsToBeOrdered;
        else
            return orderBy.orderProducts(productsToBeOrdered, order);
    }
}
