import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Tests {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://195.38.164.139:6677";
    }

    @Test
    @Order(1)
    public void testPostRequest(){
        Tutorial tutorial = new Tutorial("Title", "OAP222", false);

        RestAssured
                .given().body(tutorial).contentType(ContentType.JSON)
                .when()
                .post("/api/tutorials")
                .then().log().all().statusCode(201);
    }

    @Test
    @Order(2)
    public void testGetRequest(){
         RestAssured
                .given().contentType(ContentType.JSON)
                .when()
                    .get("/api/tutorials")
                .then().log().all().statusCode(200);
    }

    @Test
    @Order(3)
    public void testGetRequestByID(){
        RestAssured
                .given()
                .when()
                .get("/api/tutorials/510")
                .then().log().all().statusCode(200);
    }

    @Test
    @Order(4)
    public void testPutRequestByID(){
        Tutorial tutorial = new Tutorial("Title", "OAP", false);

        RestAssured
                .given().body(tutorial).contentType(ContentType.JSON)
                .when().put("/api/tutorials/510")
                .then().log().all().statusCode(200);
    }

    @Test
    @Order(5)
    public void testDeleteRequestByID(){
        RestAssured
                .given()
                .when().delete("/api/tutorials/500")
                .then().log().all().statusCode(204);
    }

    @Test
    public void testDeleteRequestAll(){
        RestAssured
                .given()
                .when().delete("/api/tutorials")
                .then().log().all().statusCode(204);
    }

    public void testGetAllTutorialByKeyword(){
         RestAssured.
               given()
                .when().get("")
               .then().log().all();
    }
}
