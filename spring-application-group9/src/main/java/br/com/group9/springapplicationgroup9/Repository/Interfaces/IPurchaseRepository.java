package br.com.group9.springapplicationgroup9.Repository.Interfaces;

import java.util.List;

public interface IPurchaseRepository<T> {
    void add(T t);
    List<T> getAll();
}

