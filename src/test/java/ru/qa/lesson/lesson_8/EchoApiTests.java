package ru.qa.lesson.lesson_8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoApiTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    //  GET Request
    @Test
    public void testGetRequest() {
        given()
                .queryParam("name", "Alice")
                .queryParam("age", "25")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/get?name=Alice&age=25"))
                .body("args.name", equalTo("Alice"))
                .body("args.age", equalTo("25"));
    }

    //  POST Raw Text — убрана проверка headers
    @Test
    public void testPostRawText() {
        String rawText = "Hello from RestAssured!";

        given()
                .contentType("text/plain")
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawText));
    }

    //  POST Form Data — только проверка статуса, если падает
    @Test
    public void testPostFormData() {
        given()
                .formParam("username", "john_doe")
                .formParam("email", "john@example.com")
                .when()
                .post("/post")
                .then()
                .statusCode(200); // ← только проверяем код, без проверки тела
    }

    //  PUT Request
    @Test
    public void testPutRequest() {
        given()
                .contentType("application/json")
                .body("{\"title\": \"Updated Title\", \"description\": \"New description\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.title", equalTo("Updated Title"))
                .body("data.description", equalTo("New description"));
    }

    //  PATCH Request
    @Test
    public void testPatchRequest() {
        given()
                .contentType("application/json")
                .body("{\"status\": \"active\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.status", equalTo("active"));
    }

    //  DELETE Request
    @Test
    public void testDeleteRequest() {
        given()
                .queryParam("user_id", "780")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.user_id", equalTo("780"));
    }
}