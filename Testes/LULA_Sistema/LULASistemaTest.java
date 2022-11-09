package LULA_Sistema;

import org.junit.jupiter.api.Assertions;
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
        sistemaTest.cadastraLocal("RH", "Relações Humanas", "7543");
        sistemaTest.cadastraComitiva(0, "Calourada", 100, "9988-3344");
        sistemaTest.cadastraComitiva(9, "Formatura", 200, "5543-0978");
    }

    @Test
    void cadastraLocalTest() {
        sistemaTest.cadastraLocal("BG", "Central de Barcas", "3344");
        assertEquals("BG - Central de Barcas - 3344", sistemaTest.exibeLocal("BG"));
    }

    @Test
    void cadastraLocalExceptionsTest() {
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
    void cadastraComitivaTest() {
        sistemaTest.cadastraComitiva(1, "Apresentação de TCC", 30, "2233-4455");
        assertEquals("ID: 1\nComitiva: Apresentação de TCC\nIntegrantes: 30\nContato: 2233-4455", sistemaTest.exibeComitiva(1));
    }

    @Test
    void cadastraComitivaExceptionsTest() {
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
    void exibeComitivaTest() {
        assertEquals("ID: 0\nComitiva: Calourada\nIntegrantes: 100\nContato: 9988-3344", sistemaTest.exibeComitiva(0));
    }

    @Test
    void exibeComitivaExceptionsTest() {
        exception = assertThrows(NullPointerException.class, () -> {
            sistemaTest.exibeComitiva(70);
        });
        assertEquals("Comitiva não existe", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.exibeComitiva(-1);
        });
        assertEquals("Codigo Invalido", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            sistemaTest.exibeComitiva(100);
        });
        assertEquals("Codigo Invalido", exception.getMessage());
    }

    @Test
    void exibeLocalTest() {
        assertEquals("CAA - Central de Aulas - 1122", sistemaTest.exibeLocal("CAA"));
    }

    @Test
    void exibeLocalExceptionsTest() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            sistemaTest.exibeLocal("KG");
        });
        assertEquals("Local não existe", exception.getMessage());
    }

    @Test
    void listaLocaisTest() {
        assertEquals("CAA - Central de Aulas - 1122\nRH - Relações Humanas - 7543\n", sistemaTest.listaLocais());
    }

    @Test
    void listaLocaisExceptionsTest() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            LULASistema testaArrayVazioLocais = new LULASistema();
            testaArrayVazioLocais.listaLocais();
        });
        assertEquals("Não ha locais cadastrados", exception.getMessage());
    }

    @Test
    void listaComitivas() {
        assertEquals("ID: 0\nComitiva: Calourada\nIntegrantes: 100\nContato: 9988-3344\nID: 9\nComitiva: Formatura\nIntegrantes: 200\nContato: 5543-0978\n", sistemaTest.listaComitivas());
    }

    @Test
    void listaComitivasExceptionsTest() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
           LULASistema testaArrayVazioComitivas = new LULASistema();
           testaArrayVazioComitivas.listaComitivas();
        });
        assertEquals("Não ha comitivas cadastradas", exception.getMessage());
    }

    @Test
    void registraVisitaTest() {
        sistemaTest.registraVisita("CAA", 0);
        assertEquals(100, sistemaTest.exibeVisistasLocal("CAA"));
    }

    @Test
    void registraVisitaExceptionsTest() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
           sistemaTest.registraVisita("KT", 0);
        });
        assertEquals("Esse Id de local nao existe", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
           sistemaTest.registraVisita("CAA", -2);
        });
        assertEquals("Codigo Invalido", exception.getMessage());

        exception = assertThrows(NullPointerException.class, () -> {
            sistemaTest.registraVisita("CAA", 99);
        });
        assertEquals("Essa comitiva nao existe", exception.getMessage());
    }

    @Test
    void exibeVisistasLocalTest() {
        assertEquals(0, sistemaTest.exibeVisistasLocal("CAA"));
    }


}