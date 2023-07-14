import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductFetcher {
    private static final String URL_STRING = "https://dummyjson.com/products";

    public List<Product> fetchProducts() throws IOException {
        URL url = new URL(URL_STRING);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-Cons-ID", "1234567");
        connection.setRequestProperty("user_key", "faY7385H");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return parseProducts(response.toString());
    }

    private List<Product> parseProducts(String json) {
        List<Product> products = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("products");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productObj = jsonArray.getJSONObject(i);
            int id = productObj.getInt("id");
            String title = productObj.getString("title");
            String description = productObj.getString("description");
            double price = productObj.getDouble("price");
            double discountPercentage = productObj.getDouble("discountPercentage");
            double rating = productObj.getDouble("rating");

            Product product = new Product(id, title, description, price, discountPercentage, rating);
            products.add(product);
        }

        return products;
    }
}
