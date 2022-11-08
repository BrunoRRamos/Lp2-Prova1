package LULA_Sistema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LULASistemaTest {
    private LULASistema sistemaTest;
    private Throwable exception;

    @BeforeEach
    void preparaSistema() {
        sistemaTest = new LULASistema();
        sistemaTest.cadastraLocal("CAA", "Central de Aulas", "1122");
        sistemaTest.cadastraComitiva(0, "Calourada", 100, "9988-3344");
    }

    @Test
    void cadastraLocal() {
        sistemaTest.cadastraLocal("BG", "Central de Barcas", "3344");
        assertEquals("BG - Central de Barcas - 3344", sistemaTest.exibeLocal("BG"));
    }

    @Test
    void cadastraLocalExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraLocal("", "Bloco de barcas", "7744");
        });
        assertEquals("Dado invalido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraLocal("BG", "", "7744");
        });
        assertEquals("Dado invalido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraLocal("BG", "Bloco de barcas", "");
        });
        assertEquals("Dado invalido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraLocal("CAA", "Central de Auditorios", "4433");
        });
        assertEquals("Local já cadastrado", exception.getMessage());
    }

    @Test
    void cadastraComitiva() {
        sistemaTest.cadastraComitiva(1, "Apresentação de TCC", 30, "2233-4455");
        assertEquals("ID: 1\nComitiva: Apresentação de TCC\nIntegrantes: 30\nContato: 2233-4455", sistemaTest.exibeComitiva(1));
    }

    @Test
    void cadastraComitivaExceptions() {
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.cadastraComitiva(-1, "Aulão de Cálculo 2", 120, "2456-6753");
        });
        assertEquals("Codigo Invalido", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.cadastraComitiva(101, "Aulão de Cálculo 2", 120, "2456-6753");
        });
        assertEquals("Codigo Invalido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraComitiva(0, "Aulão de Cálculo 2", 120, "2456-6753");
        });
        assertEquals("Comitiva já existe com essa identificicação", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraComitiva(2, "", 120, "2456-6753");
        });
        assertEquals("Dado invalido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraComitiva(2, "Aulão de Cálculo 2", -1, "2456-6753");
        });
        assertEquals("Número de pessoas inválido", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.cadastraComitiva(2, "Aulão de Cálculo 2", 2, "");
        });
        assertEquals("Dado invalido", exception.getMessage());
    }

    @Test
    void exibeComitiva() {
        assertEquals("ID: 0\nComitiva: Calourada\nIntegrantes: 100\nContato: 9988-3344", sistemaTest.exibeComitiva(0));
    }

    @Test
    void exibeComitivaExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.exibeComitiva(70);
        });
        assertEquals("Comitiva não existe", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.exibeComitiva(-1);
        });
        assertEquals("Codigo Inválido", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.exibeComitiva(100);
        });
        assertEquals("Codigo Inválido", exception.getMessage());
    }

    @Test
    void exibeLocal() {
        assertEquals("CAA - Central de Aulas - 1122", sistemaTest.exibeLocal("CAA"));
    }

    @Test
    void exibeLocalExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.exibeLocal("KG");
        });
        assertEquals("Local não existe", exception.getMessage());
    }
}