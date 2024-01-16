/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: null,
  rule: null,
  scenario: 'Create pet with parameters","    Given the API running at http://petstore.swagger.io/v2","    When a POST request to /pet is made","    And name is doggies","    And status is available","    Then a 200 response is returned within 50ms","","',
  title: 'Create pet with parameters","    Given the API running at http://petstore.swagger.io/v2","    When a POST request to /pet is made","    And name is doggies","    And status is available","    Then a 200 response is returned within 50ms","","'
}

*/
package com.example.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class CreatePetWithParametersGivenTheApiRunningAtHttpPetstoreSwaggerIoV2WhenAPostRequestToPetIsMadeAndNameIsDoggiesAndStatusIsAvailableThenA200ResponseIsReturnedWithin50MsTest {

    @Test
    public void createPetTest() {
        String filePath = Paths.get("src", "test", "java", "com", "example",
                "RoostTest", "scenario-3b42622a1d-Test.csv").toString();
        List<String[]> apiTestConfigList = fetchApiTestingData(filePath);
        apiTestConfigList.stream().forEach(apiTestConfigRow -> {
            String methodType = apiTestConfigRow[0];
            String url = apiTestConfigRow[1];
            String reqHeaders = apiTestConfigRow[2];
            String reqBody = apiTestConfigRow[3];
            Integer responseCode = Integer.parseInt(apiTestConfigRow[4]);
            String responseBody = apiTestConfigRow[5];

            RestAssured.baseURI = System.getenv("API_HOST");
            Response response = 
            given()
                .contentType(ContentType.JSON)
                .header("reqHeaders", reqHeaders)
                .body(reqBody)
            .when()
                .post(url)
            .then()
                .statusCode(responseCode)
                .body("message", is("Pet added successfully"))
                .body("status", is("OK"))
                .extract()
                .response();

            assert(response.getTime() < 50);
        });
    }

    private List<String[]> fetchApiTestingData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String[]> content = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                content.add(line.split("\\^\\|\\^"));
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
