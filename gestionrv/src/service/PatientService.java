package service;

import java.util.List;

import model.Patient;
import repository.IPatientRepository;

public class PatientService implements IPatientService {

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private IPatientRepository patientRepository;

    @Override
    public void ajouter(Patient p) {
        patientRepository.add(p);  
        
    }

    @Override
    public List<Patient> lister() {
        
        return patientRepository.findAll();
    }

    @Override
    public void modifier(Patient obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void supprimer(Patient obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Patient rechercherParNumero(String numero) {
        
        return patientRepository.findByNumero(numero);
    }
    
}
