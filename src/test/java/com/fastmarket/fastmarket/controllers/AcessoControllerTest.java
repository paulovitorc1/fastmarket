package com.fastmarket.fastmarket.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastmarket.fastmarket.dto.AcessoDTO;
import com.fastmarket.fastmarket.services.AcessoService;

class AcessoControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AcessoController acessoController;

    @Mock
    private AcessoService acessoService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(acessoController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testListar() throws Exception {
        AcessoDTO dto1 = new AcessoDTO();
        dto1.setId(1L);
        dto1.setDescricao("ADMIN");

        AcessoDTO dto2 = new AcessoDTO();
        dto2.setId(2L);
        dto2.setDescricao("USER");

        when(acessoService.listar()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/acesso"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descricao").value("ADMIN"))
                .andExpect(jsonPath("$[1].descricao").value("USER"));
    }

    @Test
    void testSalvar() throws Exception {
        AcessoDTO dto = new AcessoDTO();
        dto.setDescricao("TEST");

        AcessoDTO savedDto = new AcessoDTO();
        savedDto.setId(3L);
        savedDto.setDescricao("TEST");

        when(acessoService.salvar(any(AcessoDTO.class))).thenReturn(savedDto);

        mockMvc.perform(post("/acesso")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3L))
                .andExpect(jsonPath("$.descricao").value("TEST"));
    }
}
