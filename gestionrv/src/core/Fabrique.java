package core;

import repository.AntecedantRepository;
import repository.IAntecedantRepository;
import repository.IDataBase;
import repository.IMedecinRepository;
import repository.IPatientRepository;
import repository.IRvRepository;
import repository.ISpecialisteRepository;
import repository.MedecinRepository;
import repository.MySql;
import repository.PatientRepository;
import repository.RvRepository;
import repository.SpecialisteRepository;
import service.AntecedantSercice;
import service.IAntecedantService;
import service.IMedecinService;
import service.IPatientService;
import service.IRvService;
import service.ISpecialisteService;
import service.MedecinService;
import service.PatientService;
import service.RvService;
import service.SpecialisteService;

public class Fabrique {

     private static  ISpecialisteService specialisteService ;

    public static ISpecialisteService getSpecialisteService(){

        IDataBase mySql= new MySql();

        ISpecialisteRepository specialisteRepository=new SpecialisteRepository(mySql);
       
        specialisteService =new SpecialisteService(specialisteRepository);

        return specialisteService;
    }

    private static  IAntecedantService antecedantService ;

    public static IAntecedantService getAntecedantService(){

        IDataBase mySql= new MySql();

        IAntecedantRepository antecedantRepository=new AntecedantRepository(mySql);
       
        antecedantService =new AntecedantSercice(antecedantRepository);

        return antecedantService;
    }
    
    private static  IPatientService patientService ;

    public static IPatientService getPatientService(){

        IDataBase mySql= new MySql();

        IPatientRepository patientRepository=new PatientRepository(mySql);
       
        patientService =new PatientService(patientRepository);

        return patientService;
    }

    private static  IMedecinService medecinService ;

    public static IMedecinService getMedecinService(){

        IDataBase mySql= new MySql();

        IMedecinRepository medecinRepository=new MedecinRepository(mySql);
       
        medecinService =new MedecinService(medecinRepository);

        return medecinService;
    }

    private static  IRvService rvService ;

    public static IRvService getRvService(){

        IDataBase mySql= new MySql();

        IRvRepository rvRepository=new RvRepository(mySql);
       
        rvService =new RvService(rvRepository);

        return rvService;
    }
}

