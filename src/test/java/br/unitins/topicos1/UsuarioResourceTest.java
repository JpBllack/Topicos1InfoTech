// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;

// import org.junit.jupiter.api.Test;


// import br.unitins.topicos1.dto.TelefoneDTO;
// import br.unitins.topicos1.dto.UsuarioDTO;
// import br.unitins.topicos1.dto.UsuarioResponseDTO;
// import br.unitins.topicos1.service.UsuarioService;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.notNullValue;
// import static org.hamcrest.MatcherAssert.assertThat;

// import java.util.ArrayList;
// import java.util.List;

// @QuarkusTest
// public class UsuarioResourceTest {

//     @Inject
//     UsuarioService usuarioService;

//     @Test
//     public void testFindAll() {
//         given()
//           .when().get("/usuarios")
//           .then()
//              .statusCode(200);
//     }

//     @Test
//     public void testInsert() {
//         List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//         telefones.add(new TelefoneDTO("63", "5555-5555"));

//         UsuarioDTO dto = new UsuarioDTO(
//             "Jhon Wick Insert",
//             "jhonwick",
//             "333",
//             telefones
//         );

//         UsuarioResponseDTO responseDTO = given()
//             .contentType(ContentType.JSON)
//             .body(dto)
//             .when().post("/usuarios")
//             .then()
//             .statusCode(201)
//             .body(
//                 "id", notNullValue(),
//                 "nome", is("Jhon Wick Insert"),
//                 "login", is("jhonwick")
//             )
//             .extract()
//             .as(UsuarioResponseDTO.class);

//         // Verificar se o usuário foi inserido corretamente
//         assertThat(responseDTO.getNome(), is("Jhon Wick Insert"));
//         assertThat(responseDTO.getLogin(), is("jhonwick"));
//     }

//     @Test
//     public void testUpdate() {
//         List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//         telefones.add(new TelefoneDTO("63", "5555-5555"));

//         UsuarioDTO dto = new UsuarioDTO(
//             "Jhon Wick Update",
//             "jhonwick",
//             "333",
//             telefones
//         );

//         // Inserindo um usuário
//         UsuarioResponseDTO usuarioTest = usuarioService.insert(dto);
//         Long id = usuarioTest.getId();

//         UsuarioDTO dtoUpdate = new UsuarioDTO(
//             "Jhon Wick",
//             "wick",
//             "555",
//             telefones
//         );

//         given()
//             .contentType(ContentType.JSON)
//             .body(dtoUpdate)
//             .when().put("/usuarios/"+ id)
//             .then()
//             .statusCode(204);

//         // Verificando a alteração
//         UsuarioResponseDTO updatedUser = usuarioService.findById(id);
//         assertThat(updatedUser.getNome(), is("Jhon Wick"));
//         assertThat(updatedUser.getLogin(), is("wick"));
//     }

//     @Test
// public void testDelete() {
//     List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//     telefones.add(new TelefoneDTO("63", "5555-5555"));

//     UsuarioDTO dto = new UsuarioDTO(
//         "Jhon Wick Delete",
//         "jhonwickdelete",
//         "333",
//         telefones
//     );

//     // Inserindo um usuário
//     UsuarioResponseDTO usuarioTest = usuarioService.insert(dto);
//     Long id = usuarioTest.getId();

//     given()
//         .when()
//         .delete("/usuarios/{id}", id) // Substitua {id} pelo ID válido
//         .then()
//         .statusCode(204);

//     // Verificando se o usuário foi excluído
//     UsuarioResponseDTO deletedUser = usuarioService.findById(id);
//     assertThat(deletedUser, is(nullValue())); // Deve retornar nulo, pois o usuário foi excluído
// }

// }
