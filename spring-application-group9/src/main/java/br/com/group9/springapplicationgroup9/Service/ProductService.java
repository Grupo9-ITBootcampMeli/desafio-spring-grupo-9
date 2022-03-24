package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Repository.ProductRepository;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;
import br.com.group9.springapplicationgroup9.Util.FilterEnum;
import br.com.group9.springapplicationgroup9.Util.ProductHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

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

    public List<Product> listProducts(Map<String, String> params) {
        Map<IFilter, String> filters = validateParams(params);
        List<Product> allProducts = repository.getAll();
        Stream<Product> filteredProducts = allProducts.stream();
        for (Map.Entry<IFilter, String> param : filters.entrySet()) {
            IFilter filter = param.getKey();
            filteredProducts = filter.applyStream(filteredProducts, param.getValue());
        }
        return filteredProducts.collect(Collectors.toList());
    }
}
