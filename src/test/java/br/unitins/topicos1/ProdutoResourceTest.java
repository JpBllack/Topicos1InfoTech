package br.unitins.topicos1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ProdutoDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ProdutoResourceTest {

    @Test
    public void testInsertEndpoint() {

        ProdutoDTO produtoDTO = new ProdutoDTO("Mouse gamer Pro", "O mouse mais gamer do planeta terra", 19.99);

        given()
            .contentType(ContentType.JSON)
            .body(produtoDTO)
            .when()
            .post("/produtos")
            .then()
            .statusCode(201) 
            .body("nome", equalTo("Mouse gamer Pro"))
            .body("descricao", equalTo("O mouse mais gamer do planeta terra"))
            .body("preco", closeTo(19.99, 0.01)); 
    }

    @Test
    
    public void testUpdateEndpoint() {
        
        ProdutoDTO produtoDTO = new ProdutoDTO("Novo Produto", "descricção top", 29.99);
        given()
            .contentType(ContentType.JSON)
            .body(produtoDTO)
            .when()
            .put("/produtos/{id}", 1) 
            .then()
            .statusCode(200) 
            .body("nome", equalTo("Novo Produto"))
            .body("descricao", equalTo("descricção top"))
            .body("preco", closeTo(29.99, 0.01)); 
    }

    @Test
    
    public void testDeleteEndpoint() {
       
        given()
            .when()
            .delete("/produtos/{id}", 1) 
            .then()
            .statusCode(204); 
    }

}
