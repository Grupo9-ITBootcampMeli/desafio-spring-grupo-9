package br.com.group9.springapplicationgroup9.Repository.Interfaces;

import java.util.List;

/**Interface implementada pela abstração na forma de Repositório de compras responsável por gerenciar as leituras e
 * inserções de purchases (compras).
 * @author Amanda Zara, André Veziane, Antônio Schappo, Guilherme Pereira, Joan Davi, Vinicius Clemente
 * @version 1.00
 * @since Release 01 da aplicação
 */

public interface IPurchaseRepository<T> {
    void add(T t);
    List<T> getAll();
}

