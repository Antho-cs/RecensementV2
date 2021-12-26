package fr.epsi.b3.recensement.comparateur;

import fr.epsi.b3.recensement.Departement;

import java.util.Comparator;
/**
 * Classe de Comparaison d'un Département
 * @author Anthony Cornilleau
 */
public class PopulationDeptComparateur implements Comparator<Departement> {

    @Override
    public int compare(Departement dept1, Departement dept2) {

        return dept1.getPopulation_tot() - dept2.getPopulation_tot();
    }

    @Override
    public Comparator<Departement> reversed() {
        return Comparator.super.reversed();
    }
}
