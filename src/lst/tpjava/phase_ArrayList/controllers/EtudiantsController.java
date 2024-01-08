
package lst.tpjava.phase_ArrayList.controllers;

import lst.tpjava.phase_ArrayList.Main;
import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.services.DB;
import lst.tpjava.phase_ArrayList.services.DepartementServices;
import lst.tpjava.phase_ArrayList.services.EnseignantServices;
import lst.tpjava.phase_ArrayList.services.*;
import lst.tpjava.phase_ArrayList.models.Etudiant;
import lst.tpjava.phase_ArrayList.models.Filiere;
public class EtudiantsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Etudiant ]---------------------------");


        System.out.println("1: Pour ajouter un Etudiant");
        System.out.println("2: Pour afficher les Etudiants");
        System.out.println("3: Pour modifier un Etudiant");
        System.out.println("4: Pour supprimer un Etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
               showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }



    public static void showEtudiants(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | nom : " + etudiant.getNom());
            if (! Main.isNull(etudiant.getId())) {
                System.out.print(" | Etudiant : " +etudiant.getId()+" "+ etudiant.getPrenom()+ " " + etudiant.getNom()+" "+
                        etudiant.getEmail()+" "+etudiant.getApogee());
            }
            System.out.println(" ");
        }

        showMenu();
    }

    public static void createEtudiant(){
        System.out.println("");
        System.out.println("Veuillez entrer les informations de nouveau ETUDIANT");
        System.out.println("--.......................--");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez apogee :");
       //FilieresController.showFilieres();

        int id = Main.getIntInput("choisez un filiere par id :");
        EtudiantServices.addEtd(nom,prenom,email,apogee,FiliereServices.getFiliereById(id));
        showEtudiants();
        showMenu();


    }


    public static void editEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un departement par id pour modifier :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'emal :");
        int apogee = Main.getIntInput("Entrez apogee :");
       FilieresController.showFilieres();
        int idEns = Main.getIntInput("Sélecionnez un Filiere par id :");

        EtudiantServices.updateEtd(id, nom,prenom,email,apogee,FiliereServices.getFiliereById(id));

        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un departement par id pour supprimer :");
        EtudiantServices.deleteEtdById(id);
        showEtudiants();

    }
}





