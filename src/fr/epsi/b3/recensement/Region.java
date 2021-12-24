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

    public Region(String code_region, String nom_region, Integer population_tot) {
        this.code_region = code_region;
        this.nom_region = nom_region;
        this.population_tot = population_tot;
    }

    public Region(String nom_region, Integer population_tot) {
        this.nom_region = nom_region;
        this.population_tot = population_tot;
    }

    public List<Region> popRegions(Recensement sommeRegions) throws IOException {

        List<Ville> mesVilles = sommeRegions.RecenseVille();
        List<Region> maListeDeRegion = null;

        Integer i = 0;
        String tampon = "";

        for (Ville ville : mesVilles) {

            if (ville.getCode_region() != tampon) {
                tampon = ville.getCode_region();
                i = i + ville.getPopulation_tot();
                Region Regions = new Region(ville.getCode_region(), ville.getNom_region(), i);
                maListeDeRegion.add(Regions);
            }
        }
        return maListeDeRegion;
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


    @Override
    public String toString() {
        return "Region{" +
                "nom_region='" + nom_region + '\'' +
                ", population_tot=" + population_tot +
                '}';
    }
}
