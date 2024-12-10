import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creazione variabili
        String nomeFile = "input.txt";
        ArrayList<ArrayList<Integer>> arrayRighe = new ArrayList<>();
        int report = 0;

        try {
            Scanner in = new Scanner(new File(nomeFile));

            // Lettura delle righe
            while (in.hasNextLine()) {
                String linea = in.nextLine();
                Scanner rigaScanner = new Scanner(linea);
                ArrayList<Integer> rigaNumeri = new ArrayList<>();
                // Inserimento dei numeri nelle righe
                while (rigaScanner.hasNextInt()) {
                    rigaNumeri.add(rigaScanner.nextInt());
                }
                // Inserimento delle righe nell'ArrayList
                arrayRighe.add(rigaNumeri);
                rigaScanner.close();
            }
            in.close();

            // Stampa i numeri per ogni riga
            for (ArrayList<Integer> riga : arrayRighe) {
                for (int numero : riga) {
                    System.out.print(numero + " ");
                }
                System.out.println();
            }

            // Verifica se i report sono sicuri
            for (ArrayList<Integer> riga : arrayRighe) {
                boolean crescente = true;  // Variabile per verificare se i numeri sono crescenti
                boolean decrescente = true;  // Variabile per verificare se i numeri sono decrescenti
                boolean distanza = true;  // Variabile per verificare le differenze

                // Calcolo delle distanze tra i numeri
                for (int i = 0; i < riga.size() - 1; i++) {
                    int diff = Math.abs(riga.get(i) - riga.get(i + 1));

                    // Verifica se la distanza è tra 1 e 3
                    if (diff < 1 || diff > 3) {
                        distanza = false;
                    }

                    // Verifica se la riga di numeri è crescente o decrescente
                    if (riga.get(i) < riga.get(i + 1)) {
                        decrescente = false;
                    } else if (riga.get(i) > riga.get(i + 1)) {
                        crescente = false;
                    }
                }

                // Verifica delle condizioni per avere un report sicuro
                if ((crescente == true || decrescente == true) && distanza == true) {
                    report++;
                }
            }

            System.out.println("\nCi sono " + report + " report sicuri");

        } catch (FileNotFoundException e) {
            System.out.println("Errore nella lettura del file");
        }
    }
}


