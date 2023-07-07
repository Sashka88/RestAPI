package framework;

import com.google.gson.Gson;
import framework.services.PropertyReader;

import static io.restassured.RestAssured.given;

public class Requests {

    public PropertyReader confgReader = new PropertyReader("config.properties");
    public String baseUrl = confgReader.getProperty("APIUrl");
    public Gson gson = new Gson();

    protected String get(String uri, int statusCode) {
        return given().
                header("Content-Type", "application/json").
                when().
                get(baseUrl + uri).
                then().
                assertThat().statusCode(statusCode).
                extract().body().asString();
    }

    protected void post(String entity, String uri, int statusCode) {
        given().
                header("Content-Type", "application/json").
                body(entity).
                when().
                post(baseUrl + uri).
                then().assertThat().statusCode(statusCode).
                extract().body().asString();
    }
}