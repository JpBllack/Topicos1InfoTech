package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.AuthUsuarioDTO;
import org.acme.dto.CartaoCreditoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CartaoCreditoResourceTest {

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
                .when().get("/cartao")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        Long testeId = 5L; // Substitua pelo ID de um cartão válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/cartao/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertTest() {
        CartaoCreditoDTO cartaoCreditoDTO = new CartaoCreditoDTO("1234567890123456", "12/24", "123", "Visa", 500.0);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(cartaoCreditoDTO)
                .when().post("/cartao")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        Long testeId = 5L; // Substitua pelo ID de um cartão válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/cartao/delete/" + testeId)
                .then()
                .statusCode(200);
    }
}
