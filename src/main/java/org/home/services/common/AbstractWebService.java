package org.home.services.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.home.common.environment.PropertiesParser;

public abstract class AbstractWebService {

    protected RequestSpecification specification;
    private final String BASE_URL = ConfigFactory.create(PropertiesParser.class).apiUrl();

    public AbstractWebService() {
        this.specification = getDefaultSpecification();
    }

    public ValidatableResponse get(RequestSpecification specification, String path) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(specification);
        return RestAssured.given()
                .spec(specBuilder.build())
                .when()
                .get(path)
                .then();
    }

    public ValidatableResponse get(RequestSpecification specification, String path, String... pathParams) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(specification);
        return RestAssured.given()
                .spec(specBuilder.build())
                .when()
                .get(path, pathParams)
                .then();
    }

    public ValidatableResponse post(String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(specification);
        if (bodyPayload != null) {
            specBuilder.setBody(bodyPayload);
        }
        return RestAssured.given()
                .spec(specBuilder.build())
                .when()
                .post(path, pathParams)
                .then();
    }

    protected RequestSpecification getDefaultSpecification() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL);
        specBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ErrorLoggingFilter());

        return specBuilder.build();
    }
}
