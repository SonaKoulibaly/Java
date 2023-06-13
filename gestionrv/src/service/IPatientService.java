package service;

import model.Patient;

public interface IPatientService extends IService <Patient> {
    Patient rechercherParNumero(String numero);
}
