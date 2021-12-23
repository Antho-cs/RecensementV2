package fr.epsi.b3.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Departement {

//    TODO Méthodes pour la recherche des 10 départements les plus peuplées

    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }


    public List<Ville> RecenseVille() throws IOException {
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

// Objectif : récuperer tout les départmeent avec leurs population
    public List<Ville> recenseDept() throws IOException {

        List<Ville> toutesLesVilles = RecenseVille();
        List<Ville> sommeDep = new ArrayList<>();
        Departement monDept = new Departement();

        Integer i = 0;
        String tampon = "";

        for ( Ville ville : toutesLesVilles  ){

            if (ville.getCode_region() != tampon) {
                tampon = ville.getCode_region();
                i = i + ville.getPopulation_tot();

                monDept.getVilles().add(ville);
            }
            else {
                monDept.getVilles().add(ville);
            }

        }
        return sommeDep;
    }




}
