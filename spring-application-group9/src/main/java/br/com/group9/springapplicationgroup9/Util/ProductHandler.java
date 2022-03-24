package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IJsonHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class ProductHandler implements IJsonHandler<Product> {
    private final String PRODUCTS_PATH = DEFAULT_PATH.concat("products.json");
    private final File PRODUCTS_FILE = new File(PRODUCTS_PATH);
    private ObjectMapper objectMapper;

    public ProductHandler() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Product> read() {
        try {
            return objectMapper.readValue(PRODUCTS_FILE, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(List<Product> list) {
        try {
            objectMapper.writeValue(PRODUCTS_FILE, list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
