package repository;

import model.Specialiste;

public interface ISpecialisteRepository extends IRepository<Specialiste>{

    Specialiste findByLibelle(String libelle);

    Specialiste findById(int id);

   
    
}
