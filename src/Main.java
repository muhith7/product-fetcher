import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductFetcher productFetcher = new ProductFetcher();
            List<Product> products = productFetcher.fetchProducts();

            System.out.println("Data sebelum diurutkan:");
            for (Product product : products) {
                System.out.println(product);
            }

            SelectionSort.sort(products);

            System.out.println("\nData setelah diurutkan berdasarkan rating:");
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
