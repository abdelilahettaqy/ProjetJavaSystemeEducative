
package lst.tpjava.phase_ArrayList.services;

import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.models.Enseignant;
import lst.tpjava.phase_ArrayList.models.Etudiant;
import lst.tpjava.phase_ArrayList.models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {

    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere... filiere){
        Etudiant etudiant=new Etudiant();
        etudiant.setId(DB.getEtdId());
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setFiliere(filiere[0]);

        DB.etudiants.add(etudiant);
        return  etudiant;
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        for(Etudiant etudiant :DB.etudiants)
        {
            if(etudiant.getId()==id)
            {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setApogee(apogee);
                etudiant.setFiliere(filiere);

                return etudiant;
            }
        }
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){


        DB.etudiants.remove(getEtdById(id));
        return  DB.etudiants;
    }

    public static Etudiant getEtdById(int id){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) return  etudiant;
        }

        return  new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiants;
    }

}



