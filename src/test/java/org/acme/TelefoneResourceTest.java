package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dto.AuthUsuarioDTO;
import org.acme.dto.TelefoneDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TelefoneResourceTest {

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
                .when().get("/telefone")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        Long testeId = 1L; // Substitua pelo ID de um telefone válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/telefone/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void getCodigoAreaTeste() {
        String codigoArea = "011"; // Substitua pelo código de área válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/telefone/codigo/" + codigoArea)
                .then()
                .statusCode(200);
    }

    @Test
    public void insertTest() {
        TelefoneDTO dto = new TelefoneDTO("011", "12345678"); // Substitua com dados válidos

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(dto)
                .when().post("/telefone")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        Long testeId = 1L; // Substitua pelo ID de um telefone válido
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/telefone/" + testeId)
                .then()
                .statusCode(200);
    }

    @Test
    public void updateTest() {
        Long testeId = 1L; // Substitua pelo ID de um telefone válido
        TelefoneDTO dto = new TelefoneDTO("021", "87654321"); // Substitua com dados válidos

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(dto)
                .when().put("/telefone/" + testeId)
                .then()
                .statusCode(200);
    }

    // Testes adicionais para outros endpoints podem ser adicionados aqui
}
