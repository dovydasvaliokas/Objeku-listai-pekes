import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PagrindinePrograma {
    public static void main(String[] args) {

        Scanner skaitytuvas = new Scanner(System.in);
        ArrayList<Preke> prekes = nuskaitoPrekesIsFailo("prekes.csv");

        isvestiListaAtskiraiEilutemis(prekes);

        System.out.println("----------------------------------- ");

        ArrayList<Preke> esanciosPrekes = rastiPrekesSandelyje(prekes);
        isvestiListaAtskiraiEilutemis(esanciosPrekes);

        System.out.println("----------------------------------- ");

        System.out.println("Prekiu kiekis sandelyje = " + prekiuKiekisSandelyje(prekes));

        System.out.println("----------------------------------- ");

        System.out.println("Brangiausia preke  = " + brangiausiaPreke(prekes));


    }

    public static ArrayList<Preke> nuskaitoPrekesIsFailo(String nuskaitomasFailas) {
        ArrayList<Preke> prekes = new ArrayList<>();
        try {
            File failoObjektas = new File(nuskaitomasFailas);
            Scanner skaitytuvas = new Scanner(failoObjektas);
            skaitytuvas.nextLine();
            while (skaitytuvas.hasNextLine()) {
                String eilute = skaitytuvas.nextLine();
                String[] stulpeliai = eilute.split(",");
                Preke laikinaPreke = new Preke(Integer.parseInt(stulpeliai[0]), stulpeliai[1], stulpeliai[2], Double.parseDouble(stulpeliai[3]), Integer.parseInt(stulpeliai[4]), stulpeliai[5], stulpeliai[6]);
                prekes.add(laikinaPreke);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nėra tokio failo.");
        }
        return prekes;
    }

    public static void isvestiListaAtskiraiEilutemis(ArrayList<Preke> prekes) {
        for (Preke preke : prekes) {
            System.out.println("preke = " + preke);
        }
    }

    public static ArrayList<Preke> rastiPrekesSandelyje(ArrayList<Preke> visosPrekes) {
        ArrayList<Preke> esanciosPrekes = new ArrayList<>();
        for (Preke preke : visosPrekes) {
            if (preke.arYraSandelyje()) {
                esanciosPrekes.add(preke);
            }
        }
        return esanciosPrekes;
    }

    public static double prekiuKiekisSandelyje(List<Preke> prekes) {
        double kiekis = 0;
        for (Preke preke : prekes) {
            kiekis += preke.getKiekis();
        }
        return kiekis;
    }

    public static double brangiausiaPreke(List<Preke> prekes) {
        double laikinasMax = 0 ;
        for (Preke preke : prekes){
            if(laikinasMax < preke.getKaina()){
                laikinasMax = preke.getKaina();
            }
        }
        return  laikinasMax;
    }

    public static ArrayList<Preke> brangiausiaPrekeSarase(List<Preke> prekes) {
        ArrayList<Preke> brangiausia = new ArrayList<>() ;
        for (Preke preke : prekes){
            if(brangiausiaPreke()){
              brangiausia.add(preke);
           }
        }
        return  brangiausia;
    }




}