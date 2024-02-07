package org.home.models.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.home.models.categories.CategoryDto;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class ProductDto {

    @JsonProperty(value = "images", access = JsonProperty.Access.READ_WRITE)
    private List<String> images;
    @JsonProperty(value = "price", access = JsonProperty.Access.READ_WRITE)
    private int price;
    @JsonProperty(value = "description", access = JsonProperty.Access.READ_WRITE)
    private String description;
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    private int id;
    @JsonProperty(value = "title", access = JsonProperty.Access.READ_WRITE)
    private String title;
    @JsonProperty(value = "category", access = JsonProperty.Access.READ_WRITE)
    private CategoryDto category;
    @JsonProperty(value = "creationAt", access = JsonProperty.Access.READ_WRITE)
    private String creationAt;
    @JsonProperty(value = "updatedAt", access = JsonProperty.Access.READ_WRITE)
    private String updatedAt;

    public List<String> getImages() {
        return images;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public ProductDto setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public ProductDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductDto setId(int id) {
        this.id = id;
        return this;
    }

    public ProductDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductDto setCategory(CategoryDto category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return price == that.price && id == that.id && Objects.equals(images, that.images) && Objects.equals(description, that.description) && Objects.equals(title, that.title) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(images, price, description, id, title, category);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "images=" + images +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                '}';
    }
}

