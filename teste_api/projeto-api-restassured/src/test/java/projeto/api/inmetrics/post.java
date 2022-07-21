package projeto.api.inmetrics;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post {
	
	@Test
	 public void statusCodeCadastroEmpregado() {
		 RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		 request.header("Content-Type","application/json");
		 JSONObject json = new JSONObject();
		 json.put("admissao", "21/07/2021");
		 json.put("cargo", "Analista de Qualidade");
		 json.put("comissao", "1.000,00");
		 json.put("cpf", "123.456.789-00");
		 json.put("departamentoId","1");
		 json.put("nome", "Nome de Teste");
		 json.put("salario", "2.000,00");
		 json.put("sexo", "m");
		 json.put("tipoContratacao", "clt");
		 
		 request.body(json.toJSONString());
		 Response response = request.post("https://inm-test-api.herokuapp.com/empregado/cadastrar");
		 assertEquals(202, response.getStatusCode());
		 System.out.println(response.asPrettyString());
	 }

}
