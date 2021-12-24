package fr.epsi.b3.recensement;

import java.util.Comparator;

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
