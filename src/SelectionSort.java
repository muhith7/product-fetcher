import java.util.List;

public class SelectionSort {
    public static void sort(List<Product> products) {
        int n = products.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (products.get(j).getRating() < products.get(minIndex).getRating()) {
                    minIndex = j;
                }
            }

            Product temp = products.get(minIndex);
            products.set(minIndex, products.get(i));
            products.set(i, temp);
        }
    }
}
