package modulos.produto;

import dataFactory.ProdutoDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testes de API Rest do modulo de Produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach(){

        // configurando os dados da API
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";

        // obter o token do usuario admin
         this.token =
                 given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "  \"usuarioLogin\": \"vcharao\",\n" +
                            "  \"usuarioSenha\": \"vcharao\"\n" +
                            "}")
                .when()
                    .post("/v2/login")
                .then()
                    .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("Validar que a insercao do Produto com valor zero é proibida")
    public void testValidarLimitesZeradoProibidoValorProduto(){

        //tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada
        // status code = 422
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body("{\n" +
                        "  \"produtoNome\": \"PlayStation 5\",\n" +
                        "  \"produtoValor\": 0.00,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"preto\", \"branco\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
        .when()
            .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);

    }

    @Test
    @DisplayName("Validar que a insercao do Produto com valor que ultrapassa o limite é proibida")
    public void testValidarLimitesUltrapassandoValorPermitidoProduto() {

        //tentar inserir um produto com valor 7001.00 e validar que a mensagem de erro foi apresentada
        // status code = 422
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7001.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }
}
