package service;

import java.util.List;

public interface IService<A> {
    public void ajouter(A obj);
    public List<A> lister();
    public void modifier(A obj);
    public void supprimer (A obj);
}
