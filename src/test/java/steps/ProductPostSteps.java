package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.home.models.products.ProductDto;
import org.home.services.products.ProductService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductPostSteps extends BaseSteps {
    private ProductService productService;
    private final Faker FAKER = new Faker();

    @Before
    public void init() {
        productService = new ProductService();
    }

    @Given("I send POST to create valid product")
    public void iSendPOSTToCreateValidProduct() {
        ProductDto product = new ProductDto()
                .setId(FAKER.random().nextInt(100))
                .setDescription(FAKER.book().genre())
                .setTitle(FAKER.book().title())
                .setPrice(5)
                .setCategoryId(1)
                .setImages(List.of("https://placeimg.com/640/480/any"));

        ProductDto createdProduct = productService.create(product);
        context().setContext("createdProduct", createdProduct);
    }

    @Then("I verify that product created successfully")
    public void iVerifyThatProductCreatedSuccessfully() {
        ProductDto createdProduct = (ProductDto) context().getContext("createdProduct");
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
