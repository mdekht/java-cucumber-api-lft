package org.home.services.products;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.home.common.enums.HttpStatus;
import org.home.models.products.ProductDto;
import org.home.services.common.AbstractWebService;

import java.util.List;

public class ProductService extends AbstractWebService {


    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PRODUCTS_END = "/products";
    private static final String PRODUCTS_END_CREATE = "/products/";
    private static final String PRODUCTS_RESOURCE_END = "/products/{id}";


    public ProductDto create(ProductDto userDto) {
        return create(userDto, HttpStatus.CREATED).extract().as(ProductDto.class);
    }

    public ValidatableResponse create(ProductDto userDto, HttpStatus status) {
        LOGGER.info("Create new User");
        return post(PRODUCTS_END_CREATE, userDto).statusCode(status.getCode());
    }


    public ProductDto getById(String id) {
        return getById(id, HttpStatus.OK).extract().as(ProductDto.class);
    }

    public ValidatableResponse getById(String id, HttpStatus status) {
        LOGGER.info("Get Product by id [{}]", id);
        return get(specification, PRODUCTS_RESOURCE_END, id).statusCode(status.getCode());
    }

    public List<ProductDto> getWithPagination(int offset, int limit) {
        LOGGER.info("Get products with offset:{offset} and limit:{limit}");
        specification.param("offset", offset).and().param("limit", limit);
        return List.of(getAll(specification, HttpStatus.OK).extract().as(ProductDto[].class));
    }

    public List<ProductDto> getWithPriceRange(int minPrice, int maxPrice) {
        LOGGER.info("Get products with min price:{minPrice} and max price:{maxPrice}");
        specification.param("price_min", minPrice).and().param("price_max", maxPrice);
        return List.of(getAll(specification, HttpStatus.OK).extract().as(ProductDto[].class));
    }

    public List<ProductDto> getAll() {
        return List.of(getAll(specification, HttpStatus.OK).extract().as(ProductDto[].class));
    }

    public ValidatableResponse getAll(RequestSpecification specification, HttpStatus status) {
        LOGGER.info("Get all products");
        ValidatableResponse response = get(specification, PRODUCTS_END);
        response.statusCode(status.getCode());
        return response;
    }
}
