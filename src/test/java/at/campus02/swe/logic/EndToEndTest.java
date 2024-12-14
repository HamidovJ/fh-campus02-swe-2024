package at.campus02.swe.logic;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.parser.Parser;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void SimpleSinusOperation() throws Exception
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/E2ESinusTest01.xml"));

        assertEquals(Math.sin(1), result, 0);
    }

    @Test
    public void MultipleValuesSinusOperation() throws Exception
    {
        Calculator calc = new CalculatorImpl();

        try {
            Parser parser = new Parser(calc);
            parser.parse(new File("src/test/resources/E2ESinusTest02.xml"));

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Sinus or Cosinus of two values not possible.", e.getMessage());
            // e.getCause()
        }
    }

    @Test
    public void ComplexSinusOperation() throws Exception
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/E2ESinusTest03.xml"));

        assertEquals(Math.sin(1) + 5, result, 0);
    }

    @Test
    public void SimpleCosinusOperation() throws Exception
    {
        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/E2ECosinusTest01.xml"));

        assertEquals(Math.cos(1), result, 0);
    }
}