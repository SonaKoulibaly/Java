package service;

import java.util.List;

import model.Medecin;
import repository.IMedecinRepository;

public class MedecinService implements IMedecinService {
    
    public MedecinService(IMedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    private IMedecinRepository medecinRepository;



    @Override
    public void ajouter(Medecin m) {
        medecinRepository.add(m);  
        
    }

    @Override
    public List<Medecin> lister() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void modifier(Medecin obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void supprimer(Medecin obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Medecin rechercherParNci(String nci) {
        
        return medecinRepository.findByNci(nci);

    }
    
}
