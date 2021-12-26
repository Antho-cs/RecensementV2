package fr.epsi.b3.recensement;

import java.util.*;

/**
 * Classe Application
 * Sert à construire toute l'application.
 * @author Anthony Cornilleau
 */
public class Application {

    public static void main (String[] args) throws Exception {
        Scanner saisie = new Scanner(System.in);
        String MENU =
                "-----------------------------------------------------------------------\n" +
                "Faites votre choix\n" +
                        "        1. Population d’une ville donnée\n" +
                        "        2. Population d’un département donné\n" +
                        "        3. Population d’une région donnée\n" +
                        "        4. Afficher les 10 régions les plus peuplées\n" +
                        "        5. Afficher les 10 départements les plus peuplés\n" +
                        "        6. Afficher les 10 villes les plus peuplées d’un département\n" +
                        "        7. Afficher les 10 villes les plus peuplées d’une région\n" +
                        "        8. Afficher les 10 villes les plus peuplées de France\n" +
                        "        9. Sortir\n" +
                        "Quelle est votre choix ? ";

        boolean restart = true;

        while (restart) {

            System.out.println(MENU);
            String str = saisie.nextLine();
            System.out.println("Vous avez saisi : " + str);

            String[] choixPossible = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

            List<String> list = Arrays.asList(choixPossible);

            if (list.contains(str)) {

                switch (str) {
                    case "1":
                        System.out.println("Population d'une ville");
                        System.out.println("------------------------------");
                        System.out.println("Quelle est le nom de la Ville recherché ? ");
                        System.out.println("------------------------------");
                        String nomVille = saisie.nextLine();
                        Ville recenseVille = new Ville();
                        Integer popVille = recenseVille.popVille(nomVille);
                        if (popVille != 0) {
                            System.out.println("La population de la ville '" + nomVille + "' est de : " + popVille);
                        }
                        else {
                            System.out.println("Aucune ville ne correspond a votre saisie");
                        }
                        break;

                    case "2":
                        System.out.println("Population d'un département");
                        System.out.println("------------------------------");
                        System.out.println("Quel est le code du Département recherché ? ");
                        System.out.println("------------------------------");
                        String codeDpt = saisie.nextLine();
                        Departement recenseDpt = new Departement();
                        Integer resultat = recenseDpt.popDept(codeDpt);

                        if (resultat != 0) {
                            System.out.println("La population du Département code '" + codeDpt + "' est de : " + resultat);
                        }
                        else {
                            System.out.println("Aucun Département ne correspond a votre saisie");
                        }
                        break;

                    case "3":
                        System.out.println("Population d'une région");
                        System.out.println("------------------------------");
                        System.out.println("Quel est le nom de la Région recherché ? ");
                        System.out.println("------------------------------");
                        String nomRegion = saisie.nextLine();
                        Region recenseDept = new Region();
                        Integer popRegion = recenseDept.popRegion(nomRegion);

                        if (popRegion != 0) {
                            System.out.println("La population de la Régions '" + nomRegion + "' est de : " + popRegion);
                        }
                        else {
                            System.out.println("Aucune Régions ne correspond a votre saisie");
                        }
                        break;

                    case "4":
                        System.out.println("------------------------------");
                        System.out.println("Population des 10 région les plus peuplées");
                        System.out.println("------------------------------");
                        Region region10 = new Region();
                        ArrayList<Region> top10Regions = region10.topTenRegions();

                        for( int i = 0; i < top10Regions.size() ; i++ ) {
                            System.out.println("La région la plus peuplée numéro "+ (i + 1) +" : "+ top10Regions.get(i).getNom_region()+ " avec une population de "+ top10Regions.get(i).getPopulation_tot());
                        }
                        break;

                    case "5":
                        System.out.println("------------------------------");
                        System.out.println("Population des 10 Départements les plus peuplées");
                        System.out.println("------------------------------");
                        Departement Dept10 = new Departement();
                        ArrayList<Departement> top10Dept = Dept10.topTenDept();

                        for( int i = 0; i < top10Dept.size() ; i++ ) {
                            System.out.println("Le Département le plus peuplé numéro "+ (i + 1) +" à le code Département numéro : "+ top10Dept.get(i).getCode_dpt()+ " avec une population de "+ top10Dept.get(i).getPopulation_tot());
                        }
                        break;

                    case "6":
                        System.out.println("10 villes d'un département ");
                        System.out.println("------------------------------");
                        System.out.println("Quel est le code du Département recherché ? ");
                        System.out.println("------------------------------");
                        String codeDpt10 = saisie.nextLine();
                        Departement ville10Dept = new Departement();
                        ArrayList<Ville> top10VilleDept = ville10Dept.topTenVillesDept(codeDpt10);
                        if (!top10VilleDept.isEmpty()) {
                        for( int i = 0; i < top10VilleDept.size() ; i++ ) {
                            System.out.println("La Ville la plus peuplée numéro "+ (i + 1) +" est : "+ top10VilleDept.get(i).getNom_commune()+ " avec une population de "+ top10VilleDept.get(i).getPopulation_tot());
                        } }
                        else {
                            System.out.println("Le code Département "+ codeDpt10 + "n'est pas référencé dans nos fichiers");
                        }
                        break;

                    case "7":
                        System.out.println("10 villes  d'une région ");
                        System.out.println("------------------------------");
                        System.out.println("Quel est la Région recherché ? ");
                        System.out.println("------------------------------");
                        String codeRg10 = saisie.nextLine();
                        Region ville10Region = new Region();
                        ArrayList<Ville> top10VilleReg = ville10Region.topTenVillesRegion(codeRg10);
                        if (!top10VilleReg.isEmpty()) {
                            for( int i = 0; i < top10VilleReg.size() ; i++ ) {
                                System.out.println("La Ville la plus peuplé numéro "+ (i + 1) +" est : "+ top10VilleReg.get(i).getNom_commune()+ " avec une population de "+ top10VilleReg.get(i).getPopulation_tot());
                            } }
                        else {
                            System.out.println("Le code Département "+ codeRg10 + "n'est pas référencé dans nos fichiers");
                        }
                        break;

                    case "8":
                        System.out.println("------------------------------");
                        System.out.println("Les 10 villes les plus peuplées de France ");
                        System.out.println("------------------------------");
                        Ville top10Villes = new Ville();
                        ArrayList<Ville> top10VilleFR = top10Villes.topTenVillesFr();
                        if (!top10VilleFR.isEmpty()) {
                            for( int i = 0; i < top10VilleFR.size() ; i++ ) {
                                System.out.println("La Ville la plus peuplée numéro "+ (i + 1) +" est : "+ top10VilleFR.get(i).getNom_commune()+ " avec une population de "+ top10VilleFR.get(i).getPopulation_tot());
                            } }
                        else {
                            System.out.println("Aucune ville n'est présente dans le fichier.");
                        }
                        break;

                    case "9":
                        System.out.println("Sortie de l'application");
                        restart = false;
                        break;

                }
            } else {
                System.out.println("Votre saisie est incorect recommmencer");
            }

        }

    }
}
