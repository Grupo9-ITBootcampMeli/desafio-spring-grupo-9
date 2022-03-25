package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderBy<T> {
    private T tipo;

    public OrderBy(T tipo) {
        this.tipo = tipo;
    }

    public OrderBy() {

    }

    public List<Product> orderProducts(ArrayList<Product> productList, int typeOfOrder) {
        List<Product> returnList = Collections.emptyList();

        Comparator<Product> nameComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        Comparator<Product> priceComparator = (h1, h2) -> h1.getPrice().compareTo(h2.getPrice());

        switch (typeOfOrder) {
            case 0:
                returnList = productList.stream().sorted(nameComparator).collect(Collectors.toList());
                break;

            case 1:
                returnList = productList.stream().sorted(nameComparator.reversed()).collect(Collectors.toList());
                break;

            case 2:
                returnList = productList.stream().sorted(priceComparator).collect(Collectors.toList());
                break;

            case 3:
                returnList = productList.stream().sorted(priceComparator.reversed()).collect(Collectors.toList());
                break;
        }
        return returnList;
    }
}
