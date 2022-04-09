package product;

import java.util.*;

public class ProductList {
    private final Map<Integer,Product> productMap = new HashMap<>();
    int id =0;

    public List<Product> getAllProducts() {
        for (int i=0;i<productMap.size();i++) {
            String resp = productMap.get(i).getName() + " " + productMap.get(i).getPrice();
        }
        return new ArrayList<>(productMap.values());

    }

    public void createProduct(Product product) {
        if (product.getId()== 0) {
            product.setId(id);
            id++;

        }
        productMap.put(product.getId(),product);

    }


}
