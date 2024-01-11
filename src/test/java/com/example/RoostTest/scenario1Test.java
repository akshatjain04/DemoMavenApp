/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: null,
  rule: null,
  scenario: 'Find pet by tags","    Given the API running at http://petstore.swagger.io/v2","    When a GET request to /pet/findByTags is made","    And the tags parameter is test","    And the request expects json","    Then a 200 response is returned within 50ms","","',
  title: 'Find pet by tags","    Given the API running at http://petstore.swagger.io/v2","    When a GET request to /pet/findByTags is made","    And the tags parameter is test","    And the request expects json","    Then a 200 response is returned within 50ms","","'
}

*/
package com.example.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class scenario1Test {

    @Test
    public void findPetByTagsTest() throws IOException {
        String csvFile = "scenario1Test.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line = "";
        String csvSplitBy = "^|^";

        reader.readLine(); // Skipping the header

        while((line = reader.readLine()) != null) {
            String[] payload = line.split(csvSplitBy);

            String method = payload[0];
            String url = payload[1];
            String reqHeaders = payload[2];
            String reqBody = payload[3];
            int responseCode = Integer.parseInt(payload[4]);
            String responseBody = payload[5];

            if(method.equals("GET")) {
                RestAssured.baseURI = System.getenv("API_HOST");
                Response request = RestAssured.given()
                        .header("Content-Type", "application/json")
                        .body(reqBody)
                        .when()
                        .get(url);

                request.then().assertThat()
                        .statusCode(responseCode)
                        .body("tags[0]", equalTo("test"))
                        .body("[0].id", equalTo("integer(format: int64)"))
                        .body("[0].category.id", equalTo("integer(format: int64)"))
                        .body("[0].category.name", equalTo("string"))
                        .body("[0].name", equalTo("string"))
                        .body("[0].photoUrls", equalTo("array"))
                        .body("[0].photoUrls.0", equalTo("string"))
                        .body("[0].tags", equalTo("array"))
                        .body("[0].tags.0", equalTo("object"))
                        .body("[0].status", equalTo("string(enum: available,pending,sold)"));
            }
        }
        reader.close();
    }
}
