package service;

import model.Antecedant;

public interface IAntecedantService extends IService<Antecedant> {
    Antecedant rechercherParLibelle(String libelle);

    Antecedant rechercherParId(int id);
}
