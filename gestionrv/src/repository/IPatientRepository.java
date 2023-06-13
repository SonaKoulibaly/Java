package repository;

import model.Patient;

public interface IPatientRepository extends IRepository <Patient>{

    Patient findByNumero(String numero);
    
}
