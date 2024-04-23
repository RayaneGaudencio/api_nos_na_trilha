package com.api.nos_na_trilha;


import com.api.nos_na_trilha.domain.admin.AdminRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AdminControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    String requestBody = "{\n" +
            "  \"email\": \"rayanegaudencio111@gmail.com\",\n" +
            "\t\"nome\": \"admin3\",\n" +
            "\t\"numeroTelefone\": \"845963256589\",\n" +
            "  \"senha\": \"senha123\"\n" +
            "}";

    @Test
    @DisplayName("CT01 - Deveria retornar status 400 quando os dados são inválidos.")
    @Transactional
    void testRequisicaoComDadosInvalidos() throws Exception {

        var response = mockMvc.perform(post("/admin"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("CT02 - Deve cadastrar Admin com dados corretos e retornar 201")
    @Transactional
    void testRequisicaoComDadosValidos() throws Exception {
        var response = mockMvc.perform(post("/admin")
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

        var response = mockMvc.perform(post("/admin")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
    }
}
