package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.BoletoBancarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.acme.dto.AuthUsuarioDTO;

@QuarkusTest
public class BoletoBancarioResourceTest {

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
                .when().get("/boleto")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        Long testeId = 4L; // Substitua pelo ID de um boleto válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/boleto/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertTest() {
        BoletoBancarioDTO boletoBancarioDTO = new BoletoBancarioDTO("Banco Teste", "12345", 100.0);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(boletoBancarioDTO)
                .when().post("/boleto")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        Long testeId = 4L; // Substitua pelo ID de um boleto válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/boleto/delete/" + testeId)
                .then()
                .statusCode(200);
    }
}
