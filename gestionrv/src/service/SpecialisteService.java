package service;

import java.util.List;

import model.Specialiste;
import repository.ISpecialisteRepository;

public class SpecialisteService implements ISpecialisteService{
    
    public SpecialisteService(ISpecialisteRepository specialisteRepository) {
        this.specialisteRepository = specialisteRepository;
    }

    private ISpecialisteRepository specialisteRepository;


    @Override
    public void ajouter(Specialiste obj) {
        specialisteRepository.add(obj);
    }

    @Override
    public List<Specialiste> lister() {
        return  specialisteRepository.findAll();
    }

    @Override
    public void modifier(Specialiste obj) {
        specialisteRepository.update(obj);   
        
    }

    @Override
    public void supprimer(Specialiste obj) {
       specialisteRepository.delete(obj);
        
    }

    @Override
    public Specialiste rechercherParLibelle(String libelle) {
        
        return specialisteRepository.findByLibelle(libelle);
    }

    @Override
    public Specialiste rechercherParId(int id) {
        
        return specialisteRepository.findById(id);
    }
    
}
