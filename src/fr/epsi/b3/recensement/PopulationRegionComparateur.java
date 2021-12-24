package fr.epsi.b3.recensement;

import java.util.Comparator;

// Tuto Youtube de comparator
// https://www.youtube.com/watch?v=Q8C1upe6rw0&ab_channel=Graven-D%C3%A9veloppement

public class PopulationRegionComparateur implements Comparator<Region> {

    @Override
    public int compare(Region region1, Region region2) {

        return region1.getPopulation_tot() - region2.getPopulation_tot();
    }

    @Override
    public Comparator<Region> reversed() {
        return Comparator.super.reversed();
    }
}

