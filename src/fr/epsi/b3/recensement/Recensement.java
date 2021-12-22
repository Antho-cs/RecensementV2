package fr.epsi.b3.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Recensement {

    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public void popVille(String nomVille) throws IOException {

        String filePath = "./src/recensement_2016.csv";
        String line = "";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);


        // Recherche une ville suivant son nom
        while (( line = reader.readLine()) != null) {
            String[] morceaux = line.split(";");
            String codeRegion = morceaux[0];
            String nomRegion = morceaux[1];
            String codeDepartement = morceaux[2];
            String codeCommune = morceaux[5];
            String nomCommune = morceaux[6];
            String population = morceaux[7];

            if (Objects.equals(nomCommune, nomVille)) {
//                Ville ville1 = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, population);
                System.out.println("La population de la ville '" + nomCommune + "' est de : " + population);
                break;
            }

        }

    }

    public void popRegion(String nameRegion) throws IOException {

        String filePath = "./src/recensement_2016.csv";
        String line = "";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        // Lecture de la 1ere ligne pour éliminer l'entete
        reader.readLine();
        Integer i = 0;

        while (( line = reader.readLine()) != null) {
            String[] morceaux = line.split(";");
            String nomRegion = morceaux[1];
            String population = morceaux[7].trim().replace(" ","");
            int nbPop = Integer.parseInt(population);
            if (Objects.equals(nomRegion, nameRegion)) {
                i = i + nbPop;
            }
        }
        System.out.println("La population de la Région '" + nameRegion + "' est de : " + i);
    }

    public void popDept(String codeDpt) throws IOException {

        String filePath = "./src/recensement_2016.csv";
        String line = "";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        // Lecture de la 1ere ligne pour éliminer l'entete
        reader.readLine();
        Integer i = 0;

        while (( line = reader.readLine()) != null) {
            String[] morceaux = line.split(";");
            String codeDptmt = morceaux[2];
            String population = morceaux[7].trim().replace(" ","");
            int nbPop = Integer.parseInt(population);
            if (Objects.equals(codeDpt, codeDptmt)) {
                i = i + nbPop;
            }
        }
        System.out.println("La population du code Département '" + codeDpt + "' est de : " + i);
    }

    public void topTenRegions() {

        Integer array[] = { 8, 77, 15, 24, 46, 13, 10 , 65 , 2, 99 };


        //        Calcul de la population de chaque Régions

//        Comparaison

//        Tri
        Arrays.sort(array, Collections.reverseOrder());
        //        Affichage
        System.out.println("Les 10 Régions les plus peuplés sont :");

        for (int i = 0; array.length > i  ; i++ )
            System.out.println("numéro "+ (i+1) +" : " + array[i]);
    }


    @Override
    public String toString() {
        return "Recensement{" +
                "villes=" + villes +
                '}';
    }
}




