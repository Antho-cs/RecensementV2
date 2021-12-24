package fr.epsi.b3.recensement;

import java.io.IOException;
import java.util.*;


public class Departement {

//    TODO Méthodes pour la recherche des 10 départements les plus peuplées

    private List<Ville> villes = new ArrayList<>();
    public List<Ville> getVilles() {
        return villes;
    }

    /** code du Département */
    private String code_dpt;

    /** Population totale */
    private Integer population_tot;

    public Departement() {
    }

    public Departement(String code_dpt, Integer population_tot) {
        this.code_dpt = code_dpt;
        this.population_tot = population_tot;
    }

    public String getCode_dpt() {
        return code_dpt;
    }

    public void setCode_dpt(String code_dpt) {
        this.code_dpt = code_dpt;
    }

    public Integer getPopulation_tot() {
        return population_tot;
    }

    public void setPopulation_tot(Integer population_tot) {
        this.population_tot = population_tot;
    }

    public Integer popDept(String codeDept) throws IOException {
        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        Integer i = 0;

        for (Ville ville : toutesLesVilles) {
            if (Objects.equals(ville.getCode_dpt(), codeDept)) {
                i = i + ville.getPopulation_tot();

            }
        }
        return i;
    }


// Objectif : récuperer tous les départements avec leurs populations
    public List<Ville> recenseDept() throws IOException {

        Recensement recensement = new Recensement();
        List<Ville> toutesLesVilles = recensement.RecenseVille();
        List<Ville> sommeDep = new ArrayList<>();
        Departement monDept = new Departement();

        Integer i = 0;
        String tampon = "";

        for ( Ville ville : toutesLesVilles  ){

            if (ville.getCode_region() != tampon) {
                tampon = ville.getCode_region();
                i = i + ville.getPopulation_tot();

                monDept.getVilles().add(ville);
            }
            else {
                monDept.getVilles().add(ville);
            }

        }
        return sommeDep;
    }

    // Méthodes pour la recherche des 10 régions les plus peuplées
    public ArrayList<Departement> topTenDept() throws IOException {

        Recensement recensement = new Recensement();
        List<Ville> sommeVille=  recensement.RecenseVille();
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


    public ArrayList<Ville> topTenVillesDept(String code_dpt) throws IOException {

        Recensement recensement = new Recensement();
        List<Ville> sommeVille = recensement.RecenseVille();
        List<Ville> tabVilleDuDept = new ArrayList<>();
        List<Departement> populationDept = new ArrayList<>();
        ArrayList<Ville> tab10VilleDuDept = new ArrayList<>();
        final Integer top10 = 10;

        // Récupere toutes les villes avec le Code du département
        for (int i=0; i < sommeVille.size(); i++) {

            if ( sommeVille.get(i).getCode_dpt() == code_dpt )  {
                tabVilleDuDept.add(sommeVille.get(i));            }

        }
        System.out.println(tab10VilleDuDept);

        return tab10VilleDuDept;
    }





}
