package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.home.models.products.ProductDto;
import org.home.services.products.ProductService;

import java.util.List;

public class ProductGetSteps extends BaseSteps{
    private ProductService productService;

    @Given("I get Products with offset {int} and limit {int}")
    public void iGetProductsWithOffsetOffsetAndLimitLimit(int offset, int limit) {
        productService = new ProductService();
        List<ProductDto> products =  productService.getWithPagination(offset, limit);
        getContext().setContext("productsWithPagination", products);
    }

    @Then("I receive {int} products")
    public void iReceiveAmountOfProducts(int expProductsAmount) {
        List<ProductDto> products = (List<ProductDto>) context.getContext("productsWithPagination");
        Assertions.assertThat(products.size())
                .describedAs(String.format("Products amount in response is not correct, got {%s}, should be {%s}", products.size(), expProductsAmount))
                .isEqualTo(expProductsAmount);
    }
}
