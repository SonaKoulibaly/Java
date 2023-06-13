package service;

import model.Medecin;

public interface IMedecinService extends IService <Medecin> {

    Medecin rechercherParNci(String nci);
    
}
