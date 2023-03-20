import java.util.ArrayList;
import java.util.List;

public class SelectionSorter implements SortAlgorithm {



    @Override
    public void sort(List<Integer> lista) {
        List<Integer> temp = new ArrayList<>(lista);
        List<Integer> listaSortata = new ArrayList<>();



        while (true)
        {
            int iMin = 0;

            if(temp.size() == 1)
            {
                listaSortata.add(temp.get(0));
                temp.remove(0);
                break;
            }

            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) <= temp.get(iMin)) {
                    iMin = i;
                }
            }

            listaSortata.add(temp.get(iMin));
            temp.remove(iMin);
        }


        listaSortata.forEach(System.out::println);

    }
}
