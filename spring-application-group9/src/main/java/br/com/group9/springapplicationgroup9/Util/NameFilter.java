package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IFilter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameFilter implements IFilter<Product> {

    @Override
    public List<Product> apply(List<Product> t, String value) {
        return t.stream().filter(x -> x.getName().equalsIgnoreCase(value)).collect(Collectors.toList());
    }

    @Override
    public Stream<Product> applyStream(Stream<Product> t, String value) {
        return t.filter(x -> x.getName().equalsIgnoreCase(value));
    }
}
