package fr.epsi.b3.recensement;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Ville {
    /** code de la région */
    private String code_region;

    /** nom de la région */
    private String nom_region;

    /** code du Département */
    private String code_dpt;

    /** code de la commune */
    private String code_commune;

    /** nom de la commune */
    private String nom_commune;

    /** Population totale */
    private Integer population_tot;

    public Ville(String code_region, String nom_region, String code_dpt, String code_commune, String nom_commune, Integer population_tot) {
        this.code_region = code_region;
        this.nom_region = nom_region;
        this.code_dpt = code_dpt;
        this.code_commune = code_commune;
        this.nom_commune = nom_commune;
        this.population_tot = population_tot;
    }

    public String getCode_region() {
        return code_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public String getCode_dpt() {
        return code_dpt;
    }

    public String getCode_commune() {
        return code_commune;
    }

    public String getNom_commune() {
        return nom_commune;
    }

    public Integer getPopulation_tot() {
        return population_tot;
    }

    public Ville() {
    }

    public Integer popVille(String nomVille) throws IOException {

        Recensement recensement = new Recensement();
        List<Ville> sommeVilles =  recensement.RecenseVille();

        for (Ville ville : sommeVilles) {
            if (Objects.equals(ville.getNom_commune(), nomVille)) {
                return ville.getPopulation_tot();
            }

        }
        return 0;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "code_region='" + code_region + '\'' +
                ", nom_region='" + nom_region + '\'' +
                ", code_dpt='" + code_dpt + '\'' +
                ", code_commune='" + code_commune + '\'' +
                ", nom_commune='" + nom_commune + '\'' +
                ", population_tot='" + population_tot + '\'' +
                '}';
    }
}
