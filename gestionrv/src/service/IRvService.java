package service;

import java.util.List;

import model.Medecin;
import model.Patient;
import model.Rv;
import model.Statut;

public interface IRvService extends IService <Rv>{

    Rv rechercherParNumero(String numero);

    List<Rv> lister(Statut valider);

    List<Rv> lister(Medecin m);

    List<Rv> lister(Patient p);
    
}
