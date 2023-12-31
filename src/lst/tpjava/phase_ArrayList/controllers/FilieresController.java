package lst.tpjava.phase_ArrayList.controllers;

import lst.tpjava.phase_ArrayList.Main;
import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.services.DB;
import lst.tpjava.phase_ArrayList.services.DepartementServices;
import lst.tpjava.phase_ArrayList.services.EnseignantServices;
import lst.tpjava.phase_ArrayList.models.Filiere;
import lst.tpjava.phase_ArrayList.services.FiliereServices;

public class FilieresController {



    public static void showMenu(){
        System.out.println("-------------------------[ Filieres ]---------------------------");


        System.out.println("1: Pour ajouter un Filiere");
        System.out.println("2: Pour afficher les Filieres");
        System.out.println("3: Pour modifier un Filiere");
        System.out.println("4: Pour supprimer un Filiere");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner votre choix : ");
        switch(option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFilieres(){
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitulé : " + filiere.getIntitule());
            if (! Main.isNull(filiere.getChef().getEmail())) {
                System.out.print(" | Enseignant : " + filiere.getChef().getNom() + " " + filiere.getChef().getPrenom());
            }
            System.out.println(" ");
        }
        showMenu();
    }
    public static void createFiliere(){
        System.out.println("");
        System.out.println("Veuillez entrer les informations de nouveau FILIERE");
        System.out.println("--.......................--");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        //EnseignantsController.showEnseignants();
        //DepartementsController.showDepartements();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        int idd = Main.getIntInput("Sélecionnez un Departement par id :");
        FiliereServices.addFiliere(intitule, EnseignantServices.getEnsById(id),DepartementServices.getDeptById(idd));

        showFilieres();
        showMenu();


    }

    public static void editFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélecionnez un filiere par id pour modifier :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        DepartementsController.showDepartements();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        int iddpr = Main.getIntInput("Sélecionnez un departement par id :");

       FiliereServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(idEns),DepartementServices.getDeptById(iddpr));

        showFilieres();
        showMenu();
    }
    public static void destroyFiliere(){
        showFilieres();
        int id = Main.getIntInput("Sélecionnez un filiere par id pour supprimer :");
        FiliereServices.deleteFiliereById(id);
        showFilieres();

    }
}






