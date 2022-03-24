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
public class ProductRepository implements IRepository<Product, Long> {

    @Autowired
    private ProductHandler jsonFile;

    @Override
    public void add(Product o) {
        // TODO: Validar regra de negócio sobre ID único
        List<Product> products = jsonFile.read();
        products.add(o);
        jsonFile.save(products);
    }

    @Override
    public Product get(Long id) {
        return jsonFile.read().stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return jsonFile.read();
    }
}
