package fr.epsi.b3.recensement;

import java.io.IOException;
import java.util.*;

public class Region {

    /** code de la région */
    private String code_region;

    /** nom de la région */
    private String nom_region;

    /** Population totale */
    private Integer population_tot;

    public Region() {
    }

    public Region(String code_region, String nom_region, Integer population_tot) {
        this.code_region = code_region;
        this.nom_region = nom_region;
        this.population_tot = population_tot;
    }

    public Region(String nom_region, Integer population_tot) {
        this.nom_region = nom_region;
        this.population_tot = population_tot;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public Integer getPopulation_tot() {
        return population_tot;
    }

    public void setPopulation_tot(Integer population_tot) {
        this.population_tot = population_tot;
    }

    public Integer popRegion(String nomRegion) throws IOException {
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        Integer i = 0;

        for (Ville ville : toutesLesVilles) {
            if (Objects.equals(ville.getNom_region(), nomRegion)) {
                i = i + ville.getPopulation_tot();
            }
        }
        return i;
    }

    // Méthodes pour la recherche des 10 régions les plus peuplées
    public ArrayList<Region> topTenRegions() throws IOException {
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        List<String> tabNom = new ArrayList<>();
        List<Region> populationRegion = new ArrayList<>();
        ArrayList<Region> tab10Region = new ArrayList<>();
        final Integer top10 = 10;

        // Evite les doublons et récupere le nom de chaque régions
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

    @Override
    public String toString() {
        return "Region{" +
                "nom_region='" + nom_region + '\'' +
                ", population_tot=" + population_tot +
                '}';
    }
}
