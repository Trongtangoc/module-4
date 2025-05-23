package service;

import java.util.List;

public interface GeneralDAO <E> {
    List<E> getAll();
    public E findCustomerById(int id);
    void add(E entity);
    boolean updateCustomer(E entity);

    void delete(int id);

}
