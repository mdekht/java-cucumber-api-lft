package steps.verifications;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.home.models.products.ProductDto;
import org.home.services.products.ProductService;
import steps.BaseSteps;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductPostVerificationSteps extends BaseSteps {
    private ProductService productService;
    private final Faker FAKER = new Faker();

    @Before
    public void init() {
        productService = new ProductService();
    }

    @Then("I verify that product created successfully")
    public void iVerifyThatProductCreatedSuccessfully() {
        ProductDto createdProduct = context().getContext("createdProduct");
        ProductDto productFromResponse = productService.getById(String.valueOf(createdProduct.getId()));

        Assertions.assertThat(createdProduct)
                .describedAs("Product %s is not equal to product %s", createdProduct, productFromResponse)
                .isEqualTo(productFromResponse);
    }

    @Given("Verify that it's impossible to create product without required fields")
    public void verifyThatItSImpossibleToCreateProductWithoutRequiredFields() {
        ProductDto invalidProduct = new ProductDto().setTitle(FAKER.book().title());

        assertThatThrownBy(() -> productService.create(invalidProduct))
                .isInstanceOf(AssertionError.class);
    }
}
