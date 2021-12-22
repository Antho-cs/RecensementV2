package fr.epsi.b3.recensement;

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
    private String population_tot;

    public Ville(String code_region, String nom_region, String code_dpt, String code_commune, String nom_commune, String population_tot) {
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

    public void setCode_region(String code_region) {
        this.code_region = code_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public String getCode_dpt() {
        return code_dpt;
    }

    public void setCode_dpt(String code_dpt) {
        this.code_dpt = code_dpt;
    }

    public String getCode_commune() {
        return code_commune;
    }

    public void setCode_commune(String code_commune) {
        this.code_commune = code_commune;
    }

    public String getNom_commune() {
        return nom_commune;
    }

    public void setNom_commune(String nom_commune) {
        this.nom_commune = nom_commune;
    }

    public String getPopulation_tot() {
        return population_tot;
    }

    public void setPopulation_tot(String population_tot) {
        this.population_tot = population_tot;
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
