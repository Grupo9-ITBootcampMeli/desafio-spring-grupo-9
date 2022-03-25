package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriceFilter implements IFilter<Product> {
    @Override
    public List<Product> apply(List<Product> products, String value) {
        try {
            BigDecimal parsedValue = new BigDecimal(value);
            return products.stream().filter(p -> p.getPrice().compareTo(parsedValue) < 1).collect(Collectors.toList());
        } catch (NumberFormatException ex) {
//        throw new HttpClientErrorException.BadRequest()
        }
        return products;
    }

    @Override
    public Stream<Product> applyStream(Stream<Product> products, String value) {
        try {
            BigDecimal parsedValue = new BigDecimal(value);
            return products.filter(p -> p.getPrice().compareTo(parsedValue) < 1);
        } catch (NumberFormatException ex) {
//        throw new HttpClientErrorException.BadRequest()
        }
        return products;
    }
}
