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

    private List<Ville> RecenseVille() throws IOException {
        // Colonnes du fichiers CSV ( index correspondant )
        final int ind_codeRegion = 0;
        final int ind_nomRegion = 1;
        final int ind_codeDepartement = 2;
        final int ind_codeCommune = 5;
        final int ind_nomCommune = 6;
        final int ind_population = 7;

        // Lecture du fichier CSV
        String filePath = "./src/recensement_2016.csv";
        String line = "";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        Recensement recense = new Recensement();
//        Lecture de la premiere ligne pour évité de récuperer l'entete
        reader.readLine();
        while ((line = reader.readLine()) != null) {
//           Séparation des éléments entre ";" en les ajoutant dans un tableau
            String[] morceaux = line.split(";");
//            Récupération de chaque éléments suivant sont index
            String codeRegion = morceaux[ind_codeRegion];
            String nomRegion = morceaux[ind_nomRegion];
            String codeDepartement = morceaux[ind_codeDepartement];
            String codeCommune = morceaux[ind_codeCommune];
            String nomCommune = morceaux[ind_nomCommune];
            Integer population = Integer.parseInt( morceaux[ind_population].trim().replace(" ","") );
//          Ajout des éléments dans mon instance de ville
            Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, population);
//           Ajout de chaque ville dans mon instance de Recensement
            recense.getVilles().add(ville);
        }
//      Retourne une liste de villes
        return recense.getVilles();
    }


    public void popVille(String nomVille) throws IOException {

       List<Ville> sommeVilles =  RecenseVille();
       String chaine = "";

       for (Ville ville : sommeVilles) {
            if (Objects.equals(ville.getNom_commune(), nomVille)) {
                chaine = "La population de la ville '" + nomVille + "' est de : " + ville.getPopulation_tot();
            }
        }
       if ( chaine.isEmpty() ) {
           System.out.println("Le nom de la ville saisie est introuvable");
       }
       else {
           System.out.println(chaine);
       }
    }

    public void popRegion(String nomRegion) throws IOException {

        List<Ville> sommeRegions =  RecenseVille();
        String chaine = "";
        Integer i = 0;

        for (Ville ville : sommeRegions) {
            if (Objects.equals(ville.getNom_region(), nomRegion)) {
                i = i + ville.getPopulation_tot();
                chaine = "La population de la ville '" + nomRegion + "' est de : " + i;
            }
        }
        if ( chaine.isEmpty() ) {
            System.out.println("Le nom de la Régions saisie est introuvable");
        }
        else {
            System.out.println(chaine);
        }
    }

    public void popDept(String codeDept) throws IOException {

        List<Ville> sommeDept =  RecenseVille();
        String chaine = "";
        Integer i = 0;

        for (Ville ville : sommeDept) {
            if (Objects.equals(ville.getCode_dpt(), codeDept)) {
                i = i + ville.getPopulation_tot();
                chaine = "La population du Département '" + codeDept  + "' est de : " + i;
            }
        }
        if ( chaine.isEmpty() ) {
            System.out.println("Le nom de la Régions saisie est introuvable");
        }
        else {
            System.out.println(chaine);
        }
    }



    @Override
    public String toString() {
        return "Recensement{" +
                "villes=" + villes +
                '}';
    }
}




