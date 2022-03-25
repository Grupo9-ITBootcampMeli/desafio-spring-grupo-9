package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FreeShippingFilter implements IFilter<Product> {
    @Override
    public List<Product> apply(List<Product> products, String value) {
        if(!value.equalsIgnoreCase("false") && !value.equalsIgnoreCase("true"))
            return products;
        return products.stream().filter(p -> p.getFreeShipping() == Boolean.valueOf(value)).collect(Collectors.toList());
    }

    @Override
    public Stream<Product> applyStream(Stream<Product> products, String value) {
        if(!value.equalsIgnoreCase("false") && !value.equalsIgnoreCase("true"))
            return products;
        return products.filter(p -> p.getFreeShipping() == Boolean.valueOf(value));
    }
}
