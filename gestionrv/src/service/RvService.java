package service;

import java.util.List;

import model.Medecin;
import model.Patient;
import model.Rv;
import model.Statut;
import repository.IRvRepository;

public class RvService implements IRvService {

    
    public RvService(IRvRepository rvRepository) {
        this.rvRepository = rvRepository;
    }

    private IRvRepository rvRepository;

    @Override
    public void ajouter(Rv rv) {
        rvRepository.add(rv);  
        
    }

    @Override
    public List<Rv> lister() {
        
        return rvRepository.findAll();
    }

    @Override
    public void modifier(Rv rv) {
        rvRepository.update(rv);
        
    }

    @Override
    public void supprimer(Rv obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Rv rechercherParNumero(String numero) {
      
        return rvRepository.findByNumero(numero);
    }

    @Override
    public List<Rv> lister(Statut statut) {
        
        return rvRepository.findByStatut(statut);
    }

    @Override
    public List<Rv> lister(Medecin m) {
        
        return rvRepository.findByMedecin(m);
    }

    @Override
    public List<Rv> lister(Patient p) {
        
        return rvRepository.findByPatient(p);
    }
    
}
