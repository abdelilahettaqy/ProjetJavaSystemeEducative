package lst.tpjava.phase_ArrayList.services;

import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.models.Enseignant;
import lst.tpjava.phase_ArrayList.models.Filiere;

import java.util.ArrayList;

public class FiliereServices {

    public static Filiere addFiliere(String intitule, Enseignant chef, Departement dept) {
        Filiere filiere =new Filiere();
        filiere.setId(DB.getFlrId());
        filiere.setIntitule(intitule);
        filiere.setChef(chef);
        filiere.setDept(dept);

        DB.filieres.add(filiere);

        return  filiere;
    }

    public static Filiere updateFiliere(int id , String intitule, Enseignant chef, Departement dept){
        for(Filiere filiere :DB.filieres)
        {
            if(filiere.getId()==id)
            {
                filiere.setIntitule(intitule);
                filiere.setChef(chef);
                filiere.setDept(dept);
                return filiere;
            }
        }
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        DB.filieres.remove(getFiliereById(id));
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) return  filiere;
        }
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }
}


