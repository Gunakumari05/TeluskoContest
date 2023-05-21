package StreamApi;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ProductService {
	List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsByPlace(String place) {
        return products.stream()
                .filter(p -> p.getPlace().equalsIgnoreCase(place))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByWarranty(int warranty) {
        return products.stream()
                .filter(p -> p.getWarranty() == warranty)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPlaceAndWarranty(String place, int warranty) {
        return products.stream()
                .filter(p -> p.getPlace().equalsIgnoreCase(place) && p.getWarranty() == warranty)
                .collect(Collectors.toList());
    }
}


