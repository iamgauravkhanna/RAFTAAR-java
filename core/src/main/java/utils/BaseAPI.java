package utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This is base class for api tests containing all the methods possible.
 *
 * @author Gaurav.Khanna
 *
 */
public class BaseAPI {

	public void verifyResponseCode(String URL, int responseCode) {

		RestAssured.baseURI = URL;

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, URL);

		int statusCode = response.getStatusCode();

		System.out.println("Response Code : " + statusCode);

		if (statusCode == responseCode) {

			System.out.println("Response Code is 200 OK");

		} else {

			System.out.println("Oops !! Response Code is not 200 Ok. It's is : " + statusCode);

		}

	}

	public void verifyStatus(String BaseURI, int statusCode) {

		RestAssured.baseURI = BaseURI;

		if (RestAssured.given().expect().statusCode(statusCode).when().get(RestAssured.baseURI) != null) {

			System.out.println("Response Code is " + statusCode);
		} else {

			try {
				throw new Exception("Response Code " + statusCode + " not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}