package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductHandler implements IJsonHandler<Product>{
    private final String PRODUCTS_PATH = DEFAULT_PATH.concat("products.json");
    private final File PRODUCTS = new File(PRODUCTS_PATH);
    private ObjectMapper objectMapper;
    private List<Product> products = new ArrayList<>();

    public ProductHandler() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Product> read() {
        try {
            return objectMapper.readValue(PRODUCTS, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(List<Product> list) {
        try {
            objectMapper.writeValue(PRODUCTS, list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
