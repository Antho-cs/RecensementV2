package fr.epsi.b3.recensement.comparateur;

import fr.epsi.b3.recensement.Ville;

import java.util.Comparator;
/**
 * Classe de Comparaison d'une Ville.
 * @author Anthony Cornilleau
 */
public class PopulationVilleComparateur implements Comparator<Ville> {

    @Override
    public int compare(Ville Ville1, Ville Ville2) {

        return Ville1.getPopulation_tot() - Ville2.getPopulation_tot();
    }

    @Override
    public Comparator<Ville> reversed() {
        return Comparator.super.reversed();
    }
}
