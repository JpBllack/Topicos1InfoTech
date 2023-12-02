package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.AuthUsuarioDTO;
import org.acme.dto.ItemVendaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ItemVendaResourceTest {

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
                .when().get("/itemvenda")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        Long testeId = 1L; // Substitua pelo ID de um item de venda válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/itemvenda/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertTest() {
        ItemVendaDTO itemVendaDTO = new ItemVendaDTO(10, 1L); // Substitua com dados válidos

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(itemVendaDTO)
                .when().post("/itemvenda")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        Long testeId = 1L; // Substitua pelo ID de um item de venda válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/itemvenda/" + testeId)
                .then()
                .statusCode(200);
    }
}
