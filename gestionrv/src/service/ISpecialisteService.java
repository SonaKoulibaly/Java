package service;

import model.Specialiste;

public interface ISpecialisteService extends IService<Specialiste>{

    Specialiste rechercherParLibelle(String libelle);

    Specialiste rechercherParId(int id);
    
}
