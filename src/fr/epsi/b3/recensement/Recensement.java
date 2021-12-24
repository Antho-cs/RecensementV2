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


    public Integer popVille(String nomVille) throws IOException {

        List<Ville> sommeVilles =  RecenseVille();
        String chaine = "";

        for (Ville ville : sommeVilles) {
            if (Objects.equals(ville.getNom_commune(), nomVille)) {
                return ville.getPopulation_tot();
            }

        }
        return 0;
    }

    public Integer popRegion(String nomRegion) throws IOException {

        List<Ville> sommeRegions =  RecenseVille();
        Integer i = 0;

        for (Ville ville : sommeRegions) {
            if (Objects.equals(ville.getNom_region(), nomRegion)) {
                i = i + ville.getPopulation_tot();
            }
        }
        return i;
    }

    public Integer popDept(String codeDept) throws IOException {

        List<Ville> sommeDept =  RecenseVille();
        Integer i = 0;

        for (Ville ville : sommeDept) {
            if (Objects.equals(ville.getCode_dpt(), codeDept)) {
                i = i + ville.getPopulation_tot();

            }
        }
        return i;
    }

    // Méthodes pour la recherche des 10 régions les plus peuplées
    public ArrayList<Region> topTenRegions() throws IOException {

        List<Ville> sommeVille=  RecenseVille();
        List<String> tabNom = new ArrayList<>();
        List<Region> populationRegion = new ArrayList<>();
        ArrayList<Region> tab10Region = new ArrayList<>();
        final Integer top10 = 10;

        // Evite les doublons et récupere le nom de chaque régions
        for (int i=0; i < sommeVille.size(); i++) {

            if (tabNom.contains( sommeVille.get(i).getNom_region() ) ) {
                // Oui c'est vide car il ne faut rien faire
            }
            else {
                tabNom.add(sommeVille.get(i).getNom_region());
            }
        }

        // Calcul de la population de chaque Régions
        for(int i=0; i< tabNom.size(); i++) {
            Region maRegion = new Region(tabNom.get(i),popRegion(tabNom.get(i)));
            populationRegion.add(maRegion);
        }
        // Méthodes de comparaison de la population d'une Régions de façon décroissante.
        Collections.sort(populationRegion, new PopulationRegionComparateur().reversed() );
        // N'afficher que les 10 Régions les plus peuplés

        for( int i = 0; i < top10 ; i++ ) {
            tab10Region.add(populationRegion.get(i));
        }
        return tab10Region;
    }

    // Méthodes pour la recherche des 10 régions les plus peuplées
    public ArrayList<Departement> topTenDept() throws IOException {

        List<Ville> sommeVille=  RecenseVille();
        List<String> tabNom = new ArrayList<>();
        List<Departement> populationDept = new ArrayList<>();
        ArrayList<Departement> tab10Dept = new ArrayList<>();
        final Integer top10 = 10;

        // Evite les doublons et récupere le nom de chaque régions
        for (int i=0; i < sommeVille.size(); i++) {

            if (tabNom.contains( sommeVille.get(i).getCode_dpt() ) ) {
                // Oui c'est vide car il ne faut rien faire
            }
            else {
                tabNom.add(sommeVille.get(i).getCode_dpt());
            }
        }

        // Calcul de la population de chaque Régions
        for(int i=0; i< tabNom.size(); i++) {
            // On instancie un nouvel Objet avec son nom et la méthodes de calcul de population suivant son nom
            Departement monDept = new Departement(tabNom.get(i),popDept(tabNom.get(i)));
            populationDept.add(monDept);
        }
        // Méthodes de comparaison de la population d'une Régions de façon décroissante.
        Collections.sort(populationDept, new PopulationDeptComparateur().reversed() );
        // N'afficher que les 10 Régions les plus peuplés

        for( int i = 0; i < top10 ; i++ ) {
            tab10Dept.add(populationDept.get(i));
        }
        return tab10Dept;
    }


    @Override
    public String toString() {
        return "Recensement{" +
                "villes=" + villes +
                '}';
    }
}




