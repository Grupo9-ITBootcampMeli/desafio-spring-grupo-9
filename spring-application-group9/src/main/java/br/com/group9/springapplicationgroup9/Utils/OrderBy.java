package br.com.group9.springapplicationgroup9.Utils;

import java.util.ArrayList;

public class OrderBy<T> {
    private T tipo;

    public OrderBy(T tipo) {
        this.tipo = tipo;
    }

    public OrderBy() {

    }

    public ArrayList<Product> orderProducts(ArrayList<Product> productList, int typeOfOrder) {
        ArrayList<Product> returnList;

        if (typeOfOrder == 0) {
            Comparator<Product> nameComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
            returnList = productList.stream().sorted(nameComparator).collect(Collectos.toList());
        }
        return productList;
    }
}
