package fr.epsi.b3.recensement;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


//        1. Population d’une ville donnée
//        2. Population d’un département donné
//        3. Population d’une région donnée
//        4. Afficher les 10 régions les plus peuplées
//        5. Afficher les 10 départements les plus peuplés
//        6. Afficher les 10 villes les plus peuplées d’un département
//        7. Afficher les 10 villes les plus peuplées d’une région
//        8. Afficher les 10 villes les plus peuplées de France
//        9. Sortir

public class Application {

/*
 * Ce code nécessite la bibliothèque OpenCV.
 * Cliquez sur le lien ci-dessus pour la télécharger.
 *
 **/

    public static void main (String[] args) throws Exception
    {

        String filePath = "./src/recensement_2016.csv";

//        File getCSVFiles = new File(filePath);
//
//        Scanner sc = new Scanner(getCSVFiles);
//        sc.useDelimiter(",");
//        while (sc.hasNext()) {
//            System.out.println(sc.next() + " | ");
//        }

        String line = "";
        final String delimiter = ";";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);


        while ((line = reader.readLine()) != null)   //loops through every line until null found
        {


            String[] token = line.split(delimiter);    // separate every token by comma
            System.out.println(
                    token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3] + token[4]
                            + " | "+ token[5]+ " | "+ token[6]+ " | " + token[7] + token[8] + " | "+ token[9]);
//            System.out.println(reader.readLine());
        }




    }
}
