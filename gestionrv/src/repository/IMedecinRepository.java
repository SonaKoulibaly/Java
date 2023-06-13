package repository;

import model.Medecin;

public interface IMedecinRepository extends IRepository <Medecin> {

    Medecin findByNci(String nci);
    
}
