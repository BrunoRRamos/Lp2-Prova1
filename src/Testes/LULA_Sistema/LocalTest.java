package LULA_Sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalTest {
    private Local localTest;

    @BeforeEach
    void preparaLocal() {
        localTest = new Local("CAA", "Central de Aulas", "223344");
    }

}