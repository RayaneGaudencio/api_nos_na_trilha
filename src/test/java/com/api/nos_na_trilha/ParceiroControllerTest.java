package com.api.nos_na_trilha;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ParceiroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String requestBody = "{\n" +
            "  \"parceiroDados\": {\n" +
            "    \"nome\": \"Parceiro  9\",\n" +
            "    \"email\": \"email@345exemplo.com\",\n" +
            "    \"numeroTelefone\": \"123456789\",\n" +
            "    \"identificador\": \"identificador\",\n" +
            "    \"porte\": 1,\n" +
            "    \"senha\": \"senha123\",\n" +
            "\t\t\"tipoAssinatura\": \"SILVER\"\n" +
            "  },\n" +
            "  \"dadosEndereco\": {\n" +
            "    \"logradouro\": \"Rua Exemplo\",\n" +
            "    \"bairro\": \"Bairro Exemplo\",\n" +
            "    \"cep\": \"12345-678\",\n" +
            "    \"numero\": \"123\",\n" +
            "    \"complemento\": \"Complemento Exemplo\",\n" +
            "    \"cidade\": \"Cidade Exemplo\",\n" +
            "    \"uf\": \"UF\"\n" +
            "  }\n" +
            "}\n";

    @Test
    @DisplayName("CT01 - Deveria retornar status 400 quando os dados são inválidos.")
    @Transactional
    void testRequisicaoComDadosInvalidos() throws Exception {

        var response = mockMvc.perform(post("/parceiro"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("CT02 - Deve cadastrar Parceiro com dados corretos e retornar 201")
    @Transactional
    void testRequisicaoComDadosValidos() throws Exception {
        var response = mockMvc.perform(post("/parceiro")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("CT03 - Deve retornar status 409 pois o email já existe")
    @Transactional
    void testRequisicaoComEmailExistente() throws Exception {
        testRequisicaoComDadosValidos();

        var response = mockMvc.perform(post("/parceiro")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
    }

}
