package com.fastmarket.fastmarket.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fastmarket.fastmarket.dto.AcessoDTO;
import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

class AcessoServiceTest {

    @InjectMocks
    private AcessoService acessoService;

    @Mock
    private AcessoRepository acessoRepository;

    private Acesso acesso1;
    private Acesso acesso2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        acesso1 = new Acesso();
        acesso1.setId(1L);
        acesso1.setDescricao("ADMIN");

        acesso2 = new Acesso();
        acesso2.setId(2L);
        acesso2.setDescricao("USER");
    }

    @Test
    void testListar() {
        when(acessoRepository.findAll()).thenReturn(Arrays.asList(acesso2, acesso1));

        List<AcessoDTO> result = acessoService.listar();

        assertEquals(2, result.size());
        assertEquals("ADMIN", result.get(0).getDescricao());
    }

    @Test
    void testSalvar() {
        AcessoDTO dto = new AcessoDTO();
        dto.setDescricao("TEST");

        Acesso acessoSaved = new Acesso();
        acessoSaved.setId(3L);
        acessoSaved.setDescricao("TEST");

        when(acessoRepository.save(any(Acesso.class))).thenReturn(acessoSaved);

        AcessoDTO result = acessoService.salvar(dto);

        assertNotNull(result);
        assertEquals("TEST", result.getDescricao());
        assertEquals(3L, result.getId());
    }

    @Test
    void testListarPorIdExists() {
        when(acessoRepository.findById(1L)).thenReturn(Optional.of(acesso1));

        AcessoDTO result = acessoService.listar_por_id(1L);

        assertEquals("ADMIN", result.getDescricao());
    }

    @Test
    void testListarPorIdNotFound() {
        when(acessoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> acessoService.listar_por_id(99L));
    }

    @Test
    void testDeletarAcessoExists() {
        when(acessoRepository.existsById(1L)).thenReturn(true);

        String message = acessoService.deletar_acesso(1L);

        verify(acessoRepository, times(1)).deleteById(1L);
        assertEquals("Acesso com ID 1 deletado com sucesso.", message);
    }

    @Test
    void testDeletarAcessoNotFound() {
        when(acessoRepository.existsById(99L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> acessoService.deletar_acesso(99L));
    }

    @Test
    void testAtualizarExists() {
        when(acessoRepository.findById(1L)).thenReturn(Optional.of(acesso1));
        when(acessoRepository.save(any(Acesso.class))).thenReturn(acesso1);

        AcessoDTO dto = new AcessoDTO();
        dto.setDescricao("NEW");

        AcessoDTO result = acessoService.atualizar(1L, dto);

        assertEquals("NEW", result.getDescricao());
    }

    @Test
    void testAtualizarNotFound() {
        when(acessoRepository.findById(99L)).thenReturn(Optional.empty());

        AcessoDTO dto = new AcessoDTO();
        dto.setDescricao("NEW");

        assertThrows(EntityNotFoundException.class, () -> acessoService.atualizar(99L, dto));
    }
}
