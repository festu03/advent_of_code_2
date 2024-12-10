import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creazione variabili
        String nomeFile = "input.txt";
        ArrayList<ArrayList<Integer>> numeriRiga = new ArrayList<>();

        try {
            Scanner in = new Scanner(new File(nomeFile));

            //Lettura delle righe
            while (in.hasNextLine()) {
                String linea = in.nextLine();
                Scanner rigaScanner = new Scanner(linea);
                ArrayList<Integer> riga = new ArrayList<>();
                //Inserimento dei numeri nelle righe
                while (rigaScanner.hasNextInt()) {
                    riga.add(rigaScanner.nextInt());
                }
                //Inserimento delle righe nell'ArrayList
                numeriRiga.add(riga);
                rigaScanner.close();
            }
            in.close();

            //Stampa i numeri mantenendo la struttura
            for (ArrayList<Integer> riga : numeriRiga) {
                for (int numero : riga) {
                    System.out.print(numero + " ");
                }
                System.out.println();  // A capo dopo ogni riga
            }



        } catch (FileNotFoundException e) {
            System.out.println("Errore nella lettura del file");
        }
    }
}
