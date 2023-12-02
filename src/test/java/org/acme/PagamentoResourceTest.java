package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.AuthUsuarioDTO;
import org.acme.dto.PagamentoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PagamentoResourceTest {

    private String token;

    @BeforeEach
    public void setAuth() {
        AuthUsuarioDTO auth = new AuthUsuarioDTO("joaojoao", "123");

        Response response = given()
                .contentType("application/json")
                .body(auth)
                .when().post("/auth")
                .then()
                .statusCode(200)
                .extract().response();

        token = response.header("Authorization");
    }

    @Test
    public void getAllTeste() {
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/pagamento")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        Long testeId = 4L; // Substitua pelo ID de um pagamento válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/pagamento/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void getTipoTeste() {
        String tipoPagamento = "boleto"; // Substitua pelo tipo de pagamento válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/pagamento/tipo/" + tipoPagamento)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertTest() {
        PagamentoDTO pagamentoDTO = new PagamentoDTO("Cartao", 100.0); // Substitua com dados válidos

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(pagamentoDTO)
                .when().post("/pagamento")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        Long testeId = 4L; // Substitua pelo ID de um pagamento válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/pagamento/" + testeId)
                .then()
                .statusCode(200);
    }
}
