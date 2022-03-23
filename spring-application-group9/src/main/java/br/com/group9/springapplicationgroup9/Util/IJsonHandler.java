package br.com.group9.springapplicationgroup9.Util;

import java.util.List;

public interface IJsonHandler<T>{
    String DEFAULT_PATH = "src/main/java/br/com/group9/springapplicationgroup9/Repository/";
    List<T> read();
    boolean save(List<T> list);
}
