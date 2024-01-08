package lst.tpjava.phase_ArrayList.services;

import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.models.Enseignant;
import lst.tpjava.phase_ArrayList.services.DB;
import java.util.ArrayList;
import  lst.tpjava.phase_ArrayList.services.DB;
public class EnseignantServices {

    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement... dept){
        Enseignant enseignant =new Enseignant();
        enseignant.setEmail(email);
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setGrade(grade);
        enseignant.setId(DB.getEnsId());
        enseignant.setDept(dept[0]);

        DB.enseignants.add(enseignant);
        return   enseignant;
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){
        for(Enseignant enseignant :DB.enseignants)
        {
            if(enseignant.getId()==id)
            {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDept(dept);

                return enseignant;
            }
        }
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){

        DB.enseignants.remove(getEnsById(id));
        return DB.enseignants;
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignant();
    }

    public static ArrayList<Enseignant> getAllEns(){
        return  DB.enseignants;
    }
}


