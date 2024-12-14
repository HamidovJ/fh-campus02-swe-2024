package at.campus02.swe.logic;

import at.campus02.swe.Calculator;
import at.campus02.swe.parser.Parser;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;

public class EndToEndTest {
    @Test
    public void AddOperation() throws Exception
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/E2EAddTest.xml"));

        assertEquals(23.0, result, 0);
    }

    @Test
    public void DivisionOperation() throws Exception
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/E2EDivisionTest.xml"));

        assertEquals(1, result, 0);
    }
}