package projeto.api.inmetrics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class delete {
	
	@Test
	public void deletarEmpregado() {
		
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type","application/json");
		
		Response response = request.delete("https://inm-test-api.herokuapp.com/empregado/deletar/3169");
		assertEquals(202, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}

}
