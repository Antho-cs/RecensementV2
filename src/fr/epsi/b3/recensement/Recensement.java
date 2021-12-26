package fr.epsi.b3.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe de Recensement
 * @author Anthony Cornilleau
 */
public class Recensement {

    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    /**
     * Recense l'ensemble des villes du fichiers
     * @return Un tableaux de villes
     */
    public List<Ville> RecenseVille() throws IOException {
        // Colonnes du fichiers CSV (index correspondant)
        final int ind_codeRegion = 0;
        final int ind_nomRegion = 1;
        final int ind_codeDepartement = 2;
        final int ind_codeCommune = 5;
        final int ind_nomCommune = 6;
        final int ind_population = 7;

        // Lecture du fichier CSV
        String filePath = "./src/recensement_2016.csv";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";


        Recensement recense = new Recensement();
        // Lecture de la premiere ligne pour éviter de récupérer l'entête
        reader.readLine();
        while (( line = reader.readLine()) != null) {
            // Séparation des éléments entre ";" en les ajoutant dans un tableau
            String[] morceaux = line.split(";");
            // Récupération de chaque élément suivant sont index
            String codeRegion = morceaux[ind_codeRegion];
            String nomRegion = morceaux[ind_nomRegion];
            String codeDepartement = morceaux[ind_codeDepartement];
            String codeCommune = morceaux[ind_codeCommune];
            String nomCommune = morceaux[ind_nomCommune];
            // Conversion de l'élément population en Entier pour les comparaisons et les calculs
            Integer population = Integer.parseInt( morceaux[ind_population].trim().replace(" ","") );
            // Ajout des éléments dans une instance de ville
            Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, population);
            // Ajout de chaque ville dans l'instance de Recensement
            recense.getVilles().add(ville);
        }
        // Retourne la liste de villes que contient notre fichier.
        return recense.getVilles();
    }

    @Override
    public String toString() {
        return "Recensement{" +
                "villes=" + villes +
                '}';
    }
}




