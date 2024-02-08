package steps.verifications;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.home.models.products.ProductDto;
import steps.BaseSteps;

import java.util.List;

public class ProductGetVerificationSteps extends BaseSteps {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<ProductDto> products;

    @Then("I verify that all products has price more than {int}")
    public void iVerifyThatAllProductsHasPriceMoreThan(int price) {
        products = context().getContext("products");
        Assertions.assertThat(products)
                .describedAs("All prices should be more than %s", price)
                .allMatch(product -> product.getPrice() > price);
    }

    @Then("I verify that I receive {int} products")
    public void iReceiveAmountOfProducts(int expProductsAmount) {
        products = context().getContext("productsWithPagination");
        Assertions.assertThat(products.size())
                .describedAs("Products amount in response is not correct, got %s, should be %s",
                        products.size(), expProductsAmount)
                .isEqualTo(expProductsAmount);
    }

    @Then("I verify that I receive products in the selected price range {int} to {int}")
    public void iVerifyThatIReceiveProductsInTheSelectedPriceRangeMinPriceMaxPrice(int minPrice, int maxPrice) {
        products = context().getContext("productsInPriceRange");
        if (!products.isEmpty()) {
            Assertions.assertThat(products)
                    .describedAs("Products price should be more than %s and lower than %s", minPrice, maxPrice)
                    .extracting(ProductDto::getPrice)
                    .allMatch(product -> product >= minPrice && product <= maxPrice);
        } else {
            LOGGER.info(
                    String.format("Product list is empty, there are no products with price in range from %s to %s",
                            minPrice,
                            maxPrice));
        }
    }
}
