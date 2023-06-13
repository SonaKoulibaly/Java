package repository;

import model.Antecedant;

public interface  IAntecedantRepository extends IRepository <Antecedant> {
    Antecedant findByLibelle(String libelle);

    Antecedant findById(int id);

}
