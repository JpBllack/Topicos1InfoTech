package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class VendaResourceTest {

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
    public void getAllTest() {
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/venda")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTest() {
        Long vendaId = 1L; // Substituir pelo ID de uma venda válida
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/venda/" + vendaId)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertPagamentoTest() {
        VendaPagamentoDTO vendaPagamentoDTO = new VendaPagamentoDTO(4L, 4L);
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(vendaPagamentoDTO)
                .when().patch("/venda/pagamento")
                .then()
                .statusCode(200);
    }

    @Test
    public void insertVendaTest() {
        List<Long> lista = new ArrayList<>();
        VendaDTO vendaDTO = new VendaDTO(lista, 1L);
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(vendaDTO)
                .when().post("/venda")
                .then()
                .statusCode(200);
    }


}
