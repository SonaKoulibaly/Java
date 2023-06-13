package service;

import java.util.List;

import model.Antecedant;
import repository.IAntecedantRepository;

public class AntecedantSercice implements IAntecedantService{

    public AntecedantSercice(IAntecedantRepository antecedantRepository) {
        this.antecedantRepository = antecedantRepository;
    }

    private IAntecedantRepository antecedantRepository;


    @Override
    public void ajouter(Antecedant obj) {
        antecedantRepository.add(obj);
    }

    @Override
    public List<Antecedant> lister() {
        return  antecedantRepository.findAll();
    }

    @Override
    public void modifier(Antecedant obj) {
        antecedantRepository.update(obj);   
        
    }

    @Override
    public void supprimer(Antecedant obj) {
       antecedantRepository.delete(obj);
        
    }

    @Override
    public Antecedant rechercherParLibelle(String libelle) {
        
        return antecedantRepository.findByLibelle(libelle);
    }

    @Override
    public Antecedant rechercherParId(int id) {
        
        return antecedantRepository.findById(id);
    }
    
}
