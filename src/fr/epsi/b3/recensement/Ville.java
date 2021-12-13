package fr.epsi.b3.recensement;

public class Ville {

    /** nom de la région */
    private String nom_region;
    /** code de la région */
    private Integer code_region;

    /** nom de la commune */
    private String nom_commune;
    /** code de la commune */
    private Integer code_commune;

    /** code du Département */
    private Integer code_dpt;

    /** Population totale */
    private Integer population_tot;

    public Ville(String nom_region, Integer code_region, String nom_commune, Integer code_commune, Integer code_dpt, Integer population_tot) {
        this.nom_region = nom_region;
        this.code_region = code_region;
        this.nom_commune = nom_commune;
        this.code_commune = code_commune;
        this.code_dpt = code_dpt;
        this.population_tot = population_tot;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public Integer getCode_region() {
        return code_region;
    }

    public void setCode_region(Integer code_region) {
        this.code_region = code_region;
    }

    public String getNom_commune() {
        return nom_commune;
    }

    public void setNom_commune(String nom_commune) {
        this.nom_commune = nom_commune;
    }

    public Integer getCode_commune() {
        return code_commune;
    }

    public void setCode_commune(Integer code_commune) {
        this.code_commune = code_commune;
    }

    public Integer getCode_dpt() {
        return code_dpt;
    }

    public void setCode_dpt(Integer code_dpt) {
        this.code_dpt = code_dpt;
    }

    public Integer getPopulation_tot() {
        return population_tot;
    }

    public void setPopulation_tot(Integer population_tot) {
        this.population_tot = population_tot;
    }
}
