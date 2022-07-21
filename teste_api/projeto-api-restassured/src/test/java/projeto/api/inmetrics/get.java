package projeto.api.inmetrics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get {
	@Test
	public void consultarEmpregadoId() {
		
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type","application/json");
		
		Response response = request.get("https://inm-test-api.herokuapp.com/empregado/list/3171");
		assertEquals(202, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}

}
