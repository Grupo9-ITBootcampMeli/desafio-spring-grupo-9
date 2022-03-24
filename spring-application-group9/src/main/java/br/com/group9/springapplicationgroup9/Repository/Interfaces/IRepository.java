package br.com.group9.springapplicationgroup9.Repository.Interfaces;

import java.util.List;

public interface IRepository<T, U> {
    boolean add(T t);
    boolean addAll(List<T> t);
    T get(U id);
    List<T> getAll();
}
