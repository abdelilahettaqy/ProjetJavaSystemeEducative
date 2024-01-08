
package lst.tpjava.phase_ArrayList.controllers;

import lst.tpjava.phase_ArrayList.Main;
import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.services.*;
import lst.tpjava.phase_ArrayList.models.Module;
import lst.tpjava.phase_ArrayList.services.FiliereServices;

public class ModulesController {

    public static void showMenu(){
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un Module");
        System.out.println("2: Pour afficher les Modules");
        System.out.println("3: Pour modifier un Module");
        System.out.println("4: Pour supprimer un Module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez choisez une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModules(){
        for (Module module : DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            if (! Main.isNull(module.getChef())) {
                System.out.print(" | Chef : " + module.getChef().getNom() + " " + module.getChef().getPrenom());
                System.out.print(" | Filiere : " + module.getFiliere().getId() + " " + module.getFiliere().getIntitule());
            }
            System.out.println(" ");
        }

    }
    public static void createModule(){
        System.out.println("");
        System.out.println("Veuillez entrer les informations de nouveau MODULE");
        System.out.println("--.......................--");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        //EnseignantsController.showEnseignants();
        FilieresController.showFilieres();
        int id = Main.getIntInput("Sélecionnez un enseignant et filiere par id :");
        int idt = Main.getIntInput("Sélecionnez un filiere et filiere par id :");
        ModuleServices.addModule(intitule, EnseignantServices.getEnsById(id), FiliereServices.getFiliereById(idt));

        showModules();
        showMenu();


    }

    public static void editModule() {
        showModules();
        int id = Main.getIntInput("Sélecionnez un filiere par id pour modifier :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        FilieresController.showFilieres();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        int idflr = Main.getIntInput("Sélecionnez un filiere par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns)/*,FiliereServices.getFiliereById(id)*/);

        showModules();
        showMenu();
    }
    public static void destroyModule(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un Module par id pour supprimer :");
        DepartementServices.deleteDeptById(id);
        showModules();

    }

}

