package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoryFilter implements IFilter<Product> {
    @Override
    public List<Product> apply(List<Product> products, String value) {
        return products.stream().filter(p -> p.getCategory().contains(value)).collect(Collectors.toList());
    }

    @Override
    public Stream<Product> applyStream(Stream<Product> products, String value) {
        return products.filter(p -> p.getCategory().contains(value));
    }
}
