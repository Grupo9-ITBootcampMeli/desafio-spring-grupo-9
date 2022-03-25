package br.com.group9.springapplicationgroup9.Util.Interfaces;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

public interface IFilter<T> {
    List<T> apply(List<T> t, String value);
    Stream<T> applyStream(Stream<T> t, String value);
}
