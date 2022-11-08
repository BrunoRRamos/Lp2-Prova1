package LULA_Sistema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComitivaTest {

    private Comitiva comitivaTest;

    @BeforeEach
    void preparaComitivaTest() {
        comitivaTest = new Comitiva(0, "Calourada Computação", 100, "299834");
    }

    @Test
    void getCodigoIdentificacao() {
    }

    @Test
    void testToString() {
    }
}