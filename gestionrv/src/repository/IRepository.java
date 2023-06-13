package repository;

import java.util.List;

public interface IRepository<A> {
    public void add(A obj);
    public List<A> findAll();
    public void update(A obj);
    public void delete (A obj);
}
