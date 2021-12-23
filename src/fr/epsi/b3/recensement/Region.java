package fr.epsi.b3.recensement;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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



}
