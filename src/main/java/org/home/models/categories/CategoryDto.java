package org.home.models.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class CategoryDto {

    @JsonProperty(value = "image", access = JsonProperty.Access.READ_WRITE)
    private String image;
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    private int id;
    @JsonProperty(value = "creationAt", access = JsonProperty.Access.READ_WRITE)
    private String creationAt;
    @JsonProperty(value = "updatedAt", access = JsonProperty.Access.READ_WRITE)
    private String updatedAt;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public CategoryDto setImage(String image) {
        this.image = image;
        return this;
    }

    public CategoryDto setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryDto setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return id == that.id && Objects.equals(image, that.image) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name, id);
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}