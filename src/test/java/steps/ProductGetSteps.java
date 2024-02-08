package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.home.models.products.ProductDto;
import org.home.services.products.ProductService;

import java.util.List;

public class ProductGetSteps extends BaseSteps {
    private ProductService productService;
    private List<ProductDto> products;

    @Before
    public void init() {
        productService = new ProductService();
    }

    @Given("I send GET to receive Products with offset {int} and limit {int}")
    public void iGetProductsWithOffsetOffsetAndLimitLimit(int offset, int limit) {
        products = productService.getWithPagination(offset, limit);
        context().setContext("productsWithPagination", products);
    }

    @Given("I send GET to receive all the products")
    public void iSendGETToReceiveAllTheProducts() {
        products = productService.getAll();
        context().setContext("products", products);
    }

    @Given("I send GET to receive Products with min price {int} and max price {int}")
    public void iSendGETToReceiveProductsWithMinPriceMinPriceAndMaxPriceMaxPrice(int minPrice, int maxPrice) {
        products = productService.getWithPriceRange(minPrice, maxPrice);
        context().setContext("productsInPriceRange", products);
    }
}
