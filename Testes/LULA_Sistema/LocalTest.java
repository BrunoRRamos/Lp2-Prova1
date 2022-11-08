package LULA_Sistema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalTest {
    private Local localTest;

    @BeforeEach
    void preparaLocalTest() {
        localTest = new Local("CAA", "Central de Aulas", "223344");
    }

    @Test
    void toStringTest() {
        assertEquals("CAA - Central de Aulas - 223344", localTest.toString());
    }
}