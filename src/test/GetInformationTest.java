
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GetInformationTest {

    GetInformation g;
    GenerateBoardingPass b = new GenerateBoardingPass();

    @BeforeEach
    void setUp() {
        g = new GetInformation();
    }

    @Test
    void result() {
        Integer expectedN[] = {3452670, 5946872, 2345733, 9837425, 5463924, 2387569, 7883752, 3425925};
        List<Integer> ex = Arrays.asList(expectedN);
        assertTrue(ex.contains(g.getPass()));
    }
}