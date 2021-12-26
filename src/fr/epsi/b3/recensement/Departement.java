package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.comparateur.PopulationDeptComparateur;
import fr.epsi.b3.recensement.comparateur.PopulationVilleComparateur;
import java.io.IOException;
import java.util.*;

/**
 * Classe de Département
 * @author Anthony Cornilleau
 */
public class Departement {

    /********* Variables *********/
    // code du Département
    private String code_dpt;
    // Population totale
    private Integer population_tot;

    /********* Constructeurs *********/
    // Constructeur vide pour appeler les méthodes de la classe.
    public Departement() {
    }
    // Constructeur avec tous les attributs pour instancier un Département.
    public Departement(String code_dpt, Integer population_tot) {
        this.code_dpt = code_dpt;
        this.population_tot = population_tot;
    }

    /********* Getter / Setter *********/
    public String getCode_dpt() { return code_dpt; }
    public void setCode_dpt(String code_dpt) { this.code_dpt = code_dpt; }
    public Integer getPopulation_tot() { return population_tot; }
    public void setPopulation_tot(Integer population_tot) { this.population_tot = population_tot; }

    /********* Méthodes de la Classe Département *********/

    /**
     * Méthode de calcul de population suivant un code Département donnée.
     * @param codeDept  le numéro du code recherché.
     * @return un entier correspondant à la somme de toutes les villes d'un Département.
     * @throws IOException
     */
    public Integer popDept(String codeDept) throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichier.
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        // Initialisation du montant.
        int i = 0;
        // Pour chaque Ville comparé si le code Département est identique si c'est le cas on additionne la population de la ville au montant.
        for (Ville ville : toutesLesVilles) {
            if (Objects.equals(ville.getCode_dpt(), codeDept)) {
                i = i + ville.getPopulation_tot();
            }
        }
        return i;
    }

    /**
     * Méthodes pour la recherche des 10 Département les plus peuplées.
     * @return un tableau de 10 Département trié par leur population de façon décroissante.
     * @throws IOException
     */
    public ArrayList<Departement> topTenDept() throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichier
        Recensement recensement = new Recensement();
        List<Ville> sommeVille=  recensement.RecenseVille();
        // Tableau contenant les codes des départements.
        List<String> tabCodeDpt = new ArrayList<>();
        // Tableau contenant tout les Département
        List<Departement> populationDept = new ArrayList<>();
        // Tableau contenant les 10 Département les plus peuplées.
        ArrayList<Departement> tab10Dept = new ArrayList<>();
        // Limitation à 10.
        final int top10 = 10;

        // Evite les doublons et récupere le code de chaque départements.
        for (int i=0; i < sommeVille.size(); i++) {

            if (tabCodeDpt.contains( sommeVille.get(i).getCode_dpt() ) ) {
                // Oui c'est vide car il ne faut rien faire
            }
            else {
                tabCodeDpt.add(sommeVille.get(i).getCode_dpt());
            }
        }

        // Calcul de la population de chaque Département
        for(int i=0; i< tabCodeDpt.size(); i++) {
            // On instancie un nouvel Objet avec son code et sa population suivant son nom
            Departement monDept = new Departement(tabCodeDpt.get(i),popDept(tabCodeDpt.get(i)));
            populationDept.add(monDept);
        }
        // Méthodes de comparaison de la population d'un Département de façon décroissante.
        populationDept.sort(new PopulationDeptComparateur().reversed());
        // N'afficher que les 10 Régions les plus peuplés.
        for( int i = 0; i < top10 ; i++ ) {
            tab10Dept.add(populationDept.get(i));
        }
        return tab10Dept;
    }

    /**
     * Méthodes de recherche des 10 villes les plus peuplées suivant un code Département donnée.
     * @param code_dpt le code département recherché.
     * @return un tableau de villes trié par leur population de façon décroissante.
     * @throws IOException
     */
    public ArrayList<Ville> topTenVillesDept(String code_dpt) throws IOException {
        // Création d'une instance de Recensement pour récupérer toutes les villes du fichier
        Recensement recensement = new Recensement();
        List<Ville> sommeVille = recensement.RecenseVille();
        // Tableau contenant les villes du département choisi.
        List<Ville> tabVilleDuDept = new ArrayList<>();
        // Tableau des 10 Villes les plus peuplées.
        ArrayList<Ville> tab10VilleDuDept = new ArrayList<>();
        // Limitation à 10.
        final int limit = 10;

        // Récupere toutes les villes avec le Code du département
        for (int i=0; i < sommeVille.size(); i++) {

            if (Objects.equals(sommeVille.get(i).getCode_dpt(), code_dpt))  {
                tabVilleDuDept.add(sommeVille.get(i));
            }
        }

        // Méthodes de comparaison de la population d'une Villes de façon décroissante.
        tabVilleDuDept.sort(new PopulationVilleComparateur().reversed());
        // Récuperer seulement les 10 premiers
        for( int i = 0; i < limit ; i++ ) {
            tab10VilleDuDept.add(tabVilleDuDept.get(i));
        }
        return tab10VilleDuDept;
    }

}
