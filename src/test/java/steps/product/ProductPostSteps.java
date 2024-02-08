package steps.product;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.home.models.products.ProductDto;
import org.home.services.products.ProductService;
import steps.BaseSteps;

import java.util.List;

public class ProductPostSteps extends BaseSteps {
    private final Faker FAKER = new Faker();

    @Given("I send POST to create valid product")
    public void iSendPOSTToCreateValidProduct() {
        ProductService productService = new ProductService();
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
}
