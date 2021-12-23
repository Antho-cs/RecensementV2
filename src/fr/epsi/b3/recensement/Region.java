package fr.epsi.b3.recensement;

import java.util.Arrays;
import java.util.Collections;

public class Region {



// TODO Méthodes pour la recherche des 10 régions les plus peuplées
public void topTenRegions() {

    Integer array[] = { 8, 77, 15, 24, 46, 13, 10 , 65 , 2, 99 };

    //        Calcul de la population de chaque Régions

    //        Comparaison

    //        Tri
    Arrays.sort(array, Collections.reverseOrder());
    //        Affichage
    System.out.println("Les 10 Régions les plus peuplés sont :");

    for (int i = 0; array.length > i  ; i++ )
        System.out.println("numéro "+ (i+1) +" : " + array[i]);
}

}
