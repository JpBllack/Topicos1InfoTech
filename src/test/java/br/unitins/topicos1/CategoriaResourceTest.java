package br.unitins.topicos1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CategoriaDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class CategoriaResourceTest {

    @Test
    public void testInsertEndpoint() {

        CategoriaDTO categoriaDTO = new CategoriaDTO("Categoria de Teste");

       
        given()
            .contentType(ContentType.JSON)
            .body(categoriaDTO)
            .when()
            .post("/categorias")
            .then()
            .statusCode(201) // Deve retornar o código 201 Created
            .body("nome", equalTo("Categoria de Teste"));
    }

    @Test
    public void testFindByIdEndpoint() {
       
        given()
            .when()
            .get("/categorias/{id}", 1) 
            .then()
            .statusCode(200)
            .body("nome", notNullValue());
    }

    @Test
    public void testUpdateEndpoint() {
       
        CategoriaDTO categoriaDTO = new CategoriaDTO("Nova Categoria");

        given()
            .contentType(ContentType.JSON)
            .body(categoriaDTO)
            .when()
            .put("/categorias/{id}", 1) 
            .then()
            .statusCode(200) 
            .body("nome", equalTo("Nova Categoria"));
    }

    @Test
    public void testDeleteEndpoint() {
        
        given()
            .when()
            .delete("/categorias/{id}", 1) 
            .then()
            .statusCode(204); 
    }
}
