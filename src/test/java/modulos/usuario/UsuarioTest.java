package modulos.usuario;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioPojo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo de Usuarios")
public class UsuarioTest {

    @BeforeEach
    public void BeforeEach(){
        // configurando os dados da api
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";
    }

    @Test
    @DisplayName("Cadastro de usuario bem sucedido")
    public void deveCadastrarUsuarioComSucesso(){
        // tentativa de cadastrar um usuario sem passar senha
        // deve disparar a validacao e status code 400

        UsuarioPojo usuario = new UsuarioPojo("Victor Minto Charao", "vcharao5", "vcharao");

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/v2/usuarios")
        .then()
                .assertThat()
                .body("message", equalTo("Usuário adicionado com sucesso"))
                .statusCode(201);
    }

    @Test
    @DisplayName("Cadastro de usuario sem Login")
    public void naoDeveriaPermitirCadastrarUsuarioSemLogin(){
        // tentativa de cadastrar um usuario sem passar um login
        // deve disparar a validacao e status code 400

        UsuarioPojo usuario = new UsuarioPojo("Victor Minto Charao", null, "123456");

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/v2/usuarios")
        .then()
                .assertThat()
                .body("error", equalTo("usuarioNome, usuarioLogin e usuarioSenha são atributos obrigatórios"))
                .statusCode(400);
    }

    @Test
    @DisplayName("Cadastro de usuario sem Senha")
    public void naoDeveriaPermitirCadastrarUsuarioSemSenha(){
        // tentativa de cadastrar um usuario sem passar senha
        // deve disparar a validacao e status code 400

        UsuarioPojo usuario = new UsuarioPojo("Victor Minto Charao", "vcharao2", null);

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/v2/usuarios")
        .then()
                .assertThat()
                .body("error", equalTo("usuarioNome, usuarioLogin e usuarioSenha são atributos obrigatórios"))
                .statusCode(400);
    }

    @Test
    @DisplayName("Cadastro de usuario sem Nome")
    public void naoDeveriaPermitirCadastrarUsuarioSemNome(){
        // tentativa de cadastrar um usuario sem passar nome
        // deve disparar a validacao e status code 400

        UsuarioPojo usuario = new UsuarioPojo(null, "vcharao2", "vcharao2");

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/v2/usuarios")
        .then()
                .assertThat()
                .body("error", equalTo("usuarioNome, usuarioLogin e usuarioSenha são atributos obrigatórios"))
                .statusCode(400);
    }

}
