package repository;

import java.util.List;

import model.Medecin;
import model.Patient;
import model.Rv;
import model.Statut;

public interface IRvRepository extends IRepository <Rv> {

	Rv findByNumero(String numero);

    List<Rv> findByMedecin(Medecin m);

    List<Rv> findByPatient(Patient p);

    List<Rv> findByStatut(Statut statut);
    
}
