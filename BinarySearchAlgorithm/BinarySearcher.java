import java.util.List;

public class BinarySearcher {



    static void find(List<Integer> lista, int numar) {
        int stepsNO = 0;
        int n = lista.size();
        int i = (n -1 ) /2 ;

        while (true) {
            if(lista.get(i) == numar) {
                System.out.println("Numar pasi = "  + stepsNO);
                System.out.println("i = " + i);
                break;
            }

            if(lista.get(i) > numar) {
                n = i;
                i = n / 2;
            }
            else  {
                i += (n - i) / 2;
            }

            stepsNO++;

            if(stepsNO >= lista.size() / 2 + 1)
            {
                System.out.println("Numarul de pasi maxim a fost depasit: " + stepsNO);
                System.out.println("Numarul nu se afla in lista");
                break;
            }
        }


    }
}
