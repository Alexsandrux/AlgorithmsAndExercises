import java.util.List;

public class BubbleSorter {


    static void sort(List<Integer> lista) {

        boolean esteSortat = false;
        while (true) {
            esteSortat = true;

            for (int i = 0; i < lista.size() - 1; i++) {
                if(lista.get(i).equals(lista.get(i + 1))) continue;
                if (lista.get(i) > lista.get(i + 1)) {
                    int temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);
                    esteSortat = false;
                }
            }

            if(esteSortat) break;

            for (int elem : lista
            ) {
                System.out.printf(elem + " ");
            }

            System.out.println();
        }

    }
}
