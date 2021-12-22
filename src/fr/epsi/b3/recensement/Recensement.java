package fr.epsi.b3.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


        // Recherche une ville suivant son nom
        while (( line = reader.readLine()) != null) {
            String[] morceaux = line.split(";");

            String nomRegion = morceaux[1];
            String population = morceaux[7];
//            int nbPop = Integer.parseInt(population);
//            int population = (char) Integer.parseInt(morceaux[7]);
//            int population = Integer.parseInt(morceaux[7].replace(" ",""));
//            System.out.println(nbPop);

// TODO COMPTER LES ELEMENTS CONTENANT LA REGION
            if (Objects.equals(nomRegion, nameRegion)) {
                String i = "";
                i = i + population;
//                Ville ville1 = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, population);
                System.out.println("La population de la Région '" + nameRegion + "' est de : " + i);
                break;
            }

        }

    }



    @Override
    public String toString() {
        return "Recensement{" +
                "villes=" + villes +
                '}';
    }
}




