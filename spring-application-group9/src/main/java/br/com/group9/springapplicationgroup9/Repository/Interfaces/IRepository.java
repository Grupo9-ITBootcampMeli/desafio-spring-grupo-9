package br.com.group9.springapplicationgroup9.Repository.Interfaces;

import java.util.List;

public interface IRepository<T, U> {
    void add(T t);
    void addAll(List<T> t);
    T get(U id);
    List<T> getAll();
}
