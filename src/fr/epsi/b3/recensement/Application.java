package fr.epsi.b3.recensement;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Application {

    public static void main (String[] args) throws Exception {
        Scanner saisie = new Scanner(System.in);
        String MENU =
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
                        Recensement recenseVille = new Recensement();
                        recenseVille.popVille(nomVille);
                        break;

                    case "2":
                        System.out.println("Population d'un département");
                        System.out.println("------------------------------");
                        System.out.println("Quelle est le code du Département recherché ? ");
                        System.out.println("------------------------------");
                        String codeDpt = saisie.nextLine();
                        Recensement recenseDpt = new Recensement();
                        recenseDpt.popDept(codeDpt);
                        break;

                    case "3":
                        System.out.println("Population d'une région");
                        System.out.println("------------------------------");
                        System.out.println("Quel est le nom de la Région recherché ? ");
                        System.out.println("------------------------------");
                        String nomRegion = saisie.nextLine();
                        Recensement recenseDept = new Recensement();
                        recenseDept.popRegion(nomRegion);
                        break;

                    case "4":
                        System.out.println("10 Regions ");
                        System.out.println("------------------------------");
                        System.out.println("Population des 10 région les plus peuplé");
                        System.out.println("------------------------------");
                        Recensement region10 = new Recensement();
                        region10.topTenRegions();

                        break;

                    case "5":
                        System.out.println("10 Departmeents ");
                        System.out.println("------------------------------");
                        System.out.println("Population des 10 Départements les plus peuplé");
                        System.out.println("------------------------------");
                        Departement monDept = new Departement();
                        System.out.println(monDept.recenseDept());
                        break;

                    case "6":
                        System.out.println("10 villes d'un département ");
                        break;

                    case "7":
                        System.out.println("10 villes d'une région ");
                        break;

                    case "8":
                        System.out.println("10 villes  + peuplé de France ");
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
