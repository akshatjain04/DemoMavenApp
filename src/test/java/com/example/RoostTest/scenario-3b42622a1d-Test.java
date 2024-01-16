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

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class CreatePetWithParametersGivenTheApiRunningAtHttpPetstoreSwaggerIoV2WhenAPostRequestToPetIsMadeAndNameIsDoggiesAndStatusIsAvailableThenA200ResponseIsReturnedWithin50MsTest {

  @Test
  public void createPetWithParametersTest() {

    String csvFile = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"example"+File.separator+"RoostTest"+File.separator+"scenario-3b42622a1d-Test.csv";
    BufferedReader csvReader = null;

    try {
      csvReader = new BufferedReader(new FileReader(csvFile));
      String row;
      csvReader.readLine(); // skip header

      while ((row = csvReader.readLine()) != null) {
        String[] urlData = row.split("\\^\\|\\^");

        String apiMethod = urlData[0]; 
        String url = urlData[1]; 
        String requestHeaders = urlData[2];
        String requestBody = urlData[3];
        int expectedResponseCode = Integer.parseInt(urlData[4]);
        String expectedResponseBody = urlData[5];

        given()
          .headers("Authorization", requestHeaders)
          .body(requestBody)
          .when()
          .request(apiMethod, url)
          .then()
          .statusCode(expectedResponseCode)
          .body("name", equalTo("doggies"))
          .body("status", equalTo("available"))
          .time(lessThan(50L));
      }
    } catch(IOException e){
      e.printStackTrace();
    } finally {
      try {
        if (csvReader != null) {
            csvReader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
