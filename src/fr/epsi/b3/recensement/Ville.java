package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.comparateur.PopulationVilleComparateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe de Ville
 * @author Anthony Cornilleau
 */
public class Ville {
    /********* Variables *********/
    // code de la région
    private String code_region;
    // nom de la région
    private String nom_region;
    // code du Département
    private String code_dpt;
    // code de la commune
    private String code_commune;
    // nom de la commune
    private String nom_commune;
    // Population totale
    private Integer population_tot;

    /********* Constructeurs *********/
    // Constructeur vide pour appeler les méthodes de la classe.
    public Ville() {
    }
    // Constructeur avec tous les attributs correspondant pour instancier une ville.
    public Ville(String code_region, String nom_region, String code_dpt, String code_commune, String nom_commune, Integer population_tot) {
        this.code_region = code_region;
        this.nom_region = nom_region;
        this.code_dpt = code_dpt;
        this.code_commune = code_commune;
        this.nom_commune = nom_commune;
        this.population_tot = population_tot;
    }
    /********* Getter / Setter *********/

    public String getCode_region() { return code_region; }

    public String getNom_region() { return nom_region; }

    public String getCode_dpt() { return code_dpt; }

    public String getCode_commune() { return code_commune; }

    public String getNom_commune() { return nom_commune; }

    public Integer getPopulation_tot() { return population_tot; }


    /********* Méthodes de la Classe Ville *********/

    /**
     * Méthodes de recherches d'une population pour une ville donnée
     * @param nomVille nom de la ville recherché
     * @return un entier correspondant à la population ou 0 si la ville n'est pas recensé
     * @throws IOException
     */
    public Integer popVille(String nomVille) throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichiers
        Recensement recensement = new Recensement();
        List<Ville> sommeVilles =  recensement.RecenseVille();
        // Pour chaque ville si le nom d'une commune correspond renvoi sa population.
        for (Ville ville : sommeVilles) {
            if (Objects.equals(ville.getNom_commune(), nomVille)) {
                return ville.getPopulation_tot();
            }
        }
        return 0;
    }

    /**
     * Méthodes de recherches des 10 Villes les plus peuplées de France.
     * @return un tableau de ville trié par population de façon décroissante.
     * @throws IOException
     */
    public ArrayList<Ville> topTenVillesFr() throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichiers
        Recensement recensement = new Recensement();
        List<Ville> sommeVille = recensement.RecenseVille();
        // Tableaux contenant les villes suivant le critéres
        ArrayList<Ville> tabVilleFR = new ArrayList<>();
        // Tableaux contenant les 10 Villes les plus peuplées de France.
        ArrayList<Ville> tab10VilleFr = new ArrayList<>();
        // Limitation à 10 villes
        final int top10 = 10;

        // Récupere toutes les villes qui sont Françaises (exceptions DOM-TOM  : La réunion (974), Guyane(973), Martinique (972), Guadeloupe (971) )
        for (int i=0; i < sommeVille.size(); i++) {
            if (!Objects.equals(sommeVille.get(i).getCode_dpt(), "974") || !Objects.equals(sommeVille.get(i).getCode_dpt(), "973") || !Objects.equals(sommeVille.get(i).getCode_dpt(), "972") || !Objects.equals(sommeVille.get(i).getCode_dpt(), "971"))  {
                tabVilleFR.add(sommeVille.get(i));
            }
        }
        // Méthodes de comparaison et de tri de la population d'une Villes de façon décroissante.
        tabVilleFR.sort(new PopulationVilleComparateur().reversed());
        // Récuperer seulement les 10 premiers.
        for( int i = 0; i < top10 ; i++ ) {
            tab10VilleFr.add(tabVilleFR.get(i));
        }
        return tab10VilleFr;
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
