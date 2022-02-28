package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saleProduct(long id, int amount){
        Product foundProduct = productRepository.findProductById(id);
        if (foundProduct.getStock()>=amount) {
            productRepository.updateProductStock(id,amount);
        }
        else {
            throw new IllegalArgumentException("Sorry, try smaller amount");
        }
    }

}
