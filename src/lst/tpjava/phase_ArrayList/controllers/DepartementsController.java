package lst.tpjava.phase_ArrayList.controllers;

import lst.tpjava.phase_ArrayList.Main;
import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.services.DB;
import lst.tpjava.phase_ArrayList.services.DepartementServices;
import lst.tpjava.phase_ArrayList.services.EnseignantServices;
import lst.tpjava.phase_ArrayList.controllers.EnseignantsController;
public class DepartementsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement departement : DB.departements) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getChef())) {
                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println(" ");
        }
        showMenu();
    }
    public static void createDepartement(){
        System.out.println("");
        System.out.println("Veuillez entrer les informations de nouvelle DEPARTEMENT");
        System.out.println("--.......................--");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        //EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();


    }

    public static void editDepartement() {
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id pour modifier :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id pour supprimer :");
        DepartementServices.deleteDeptById(id);
        showDepartements();

    }
}



