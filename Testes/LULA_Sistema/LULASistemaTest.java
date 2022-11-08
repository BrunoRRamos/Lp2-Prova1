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
    }

    @Test
    void cadastraLocal() {
        sistemaTest.cadastraLocal( "CAA", "Central de Aulas", "1122");
        assertEquals("CAA - Central de Aulas - 1122", sistemaTest.exibeLocal("CAA"));
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
    }

    @Test
    void cadastraComitiva() {
    }

    @Test
    void cadastraComitivaExceptions() {
    }

    @Test
    void exibeComitiva() {
    }

    @Test
    void exibeComitivaExceptions() {
    }

    @Test
    void exibeLocal() {
    }

    @Test
    void exibeLocalExceptions() {
    }
}