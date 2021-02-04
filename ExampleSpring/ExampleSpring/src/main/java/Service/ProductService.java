package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findById(long id);

    boolean isProductExist(Product product);

    void saveProduct(Product product);
}
