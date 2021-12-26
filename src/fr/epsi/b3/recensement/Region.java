package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.comparateur.PopulationRegionComparateur;
import fr.epsi.b3.recensement.comparateur.PopulationVilleComparateur;
import java.io.IOException;
import java.util.*;
/**
 * Classe de Région
 * @author Anthony Cornilleau
 */
public class Region {
    /********* Variables *********/
    // code de la région
    private String code_region;
    // nom de la région
    private String nom_region;
    // Population totale
    private Integer population_tot;

    /********* Constructeurs *********/
    // Constructeur vide pour appeler les méthodes de la classe.
    public Region() {
    }
    // Constructeur avec tous les attributs utiles correspondant pour instancier une Région.
    public Region(String nom_region, Integer population_tot) {
        this.nom_region = nom_region;
        this.population_tot = population_tot;
    }

    /********* Getter / Setter *********/
    public String getCode_region() { return code_region; }
    public void setCode_region(String code_region) { this.code_region = code_region; }
    public String getNom_region() { return nom_region; }
    public void setNom_region(String nom_region) { this.nom_region = nom_region; }
    public Integer getPopulation_tot() { return population_tot; }
    public void setPopulation_tot(Integer population_tot) { this.population_tot = population_tot; }


    /********* Méthodes de la Classe Région *********/

    /**
     * Méthode de calcul de population suivant une Région donnée.
     * @param nomRegion le nom de la Région recherché.
     * @return un entier correspondant à la somme de toutes les villes d'une Région.
     * @throws IOException
     */
    public Integer popRegion(String nomRegion) throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichier
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        int i = 0;

        for (Ville ville : toutesLesVilles) {
            if (Objects.equals(ville.getNom_region(), nomRegion)) {
                i = i + ville.getPopulation_tot();
            }
        }
        return i;
    }

    /**
     * Méthodes pour la recherche des 10 régions les plus peuplées.
     * @return un tableau de 10 Régions trié par leur population de façon décroissante.
     * @throws IOException
     */
    public ArrayList<Region> topTenRegions() throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichier
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        // Tableaux contenant les noms de chaque région.
        ArrayList<String> tabNom = new ArrayList<>();
        // Tableaux de Régions
        ArrayList<Region> tabRegion = new ArrayList<>();
        ArrayList<Region> tab10Region = new ArrayList<>();
        final int limit = 10;

        // Récupere le nom de chaque régions tout en évitant les doublons.
        for (int i=0; i < toutesLesVilles.size(); i++) {

            if (tabNom.contains( toutesLesVilles.get(i).getNom_region() ) ) {
                // Oui c'est vide car il ne faut rien faire
            }
            else {
                tabNom.add(toutesLesVilles.get(i).getNom_region());
            }
        }

        // Calcul de la population de chaque Régions
        for(int i=0; i< tabNom.size(); i++) {
            Region maRegion = new Region(tabNom.get(i),popRegion(tabNom.get(i)));
            tabRegion.add(maRegion);
        }
        System.out.println(tabRegion);
        // Méthodes de comparaison de la population d'une Région et de tri de façon décroissante.
        tabRegion.sort(new PopulationRegionComparateur().reversed());
        System.out.println(tabRegion);

        // Ajoute les 10 Régions les plus peuplés dans un tableau.
        for( int i = 0; i < limit ; i++ ) {
            tab10Region.add(tabRegion.get(i));
        }
        return tab10Region;
    }

    /**
     * Méthodes de recherche des 10 Villes les plus peuplées d'une Région donnée.
     * @param nom_region nom de la région recherché.
     * @return un tableau de 10 Villes trié par leur population de façon décroissante.
     * @throws IOException
     */
    public ArrayList<Ville> topTenVillesRegion(String nom_region) throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichiers
        Recensement recensement = new Recensement();
        List<Ville> sommeVille = recensement.RecenseVille();
        // Tableau de Villes d'une Région
        List<Ville> tabVilleReg = new ArrayList<>();
        // Tableau des 10 Villes les plus peuplées d'une Région.
        ArrayList<Ville> tab10VilleReg = new ArrayList<>();
        // Limitation à 10 Villes
        final int limit = 10;

        // Récupere toutes les villes avec le meme nom de Région.
        for (int i=0; i < sommeVille.size(); i++) {

            if (Objects.equals(sommeVille.get(i).getNom_region(), nom_region))  {
                tabVilleReg.add(sommeVille.get(i));
            }
        }
        // Méthodes de comparaison de la population d'une Villes de façon décroissante.
        tabVilleReg.sort(new PopulationVilleComparateur().reversed());
        // Récuperer seulement les 10 premiers
        for( int i = 0; i < limit ; i++ ) {
            tab10VilleReg.add(tabVilleReg.get(i));
        }
        return tab10VilleReg;
    }

    @Override
    public String toString() {
        return "Region{" +
                "nom_region='" + nom_region + '\'' +
                ", population_tot=" + population_tot +
                '}';
    }
}
