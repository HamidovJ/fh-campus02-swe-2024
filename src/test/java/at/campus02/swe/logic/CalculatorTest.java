package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }

    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }
    }

    @Test
    public void testModOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(8.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        assertEquals(2, result, 0);
    }

    @Test
    public void testSimpleModOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(10.0);
        calc.push(1);
        double result = calc.perform(Operation.mod);

        assertEquals(0, result, 0);
    }

    @Test
    public void testModuloByZero() {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(7);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Modulo by zero", e.getMessage());
            // e.getCause()
        }
    }

    @Test
    public void testSimpleSinusOperation() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();

        calc.push(1);
        double result = calc.perform(Operation.sin);

        assertEquals(Math.sin(1), result, 0);
    }

    @Test
    public void testMultipleValuesSinusOperation() {
        Calculator calc = new CalculatorImpl();

        try {
            calc.push(1);
            calc.push(1);
            calc.perform(Operation.sin);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Sinus or Cosinus of two values not possible.", e.getMessage());
        }
    }

    @Test
    public void testSimpleCosinusOperation() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();

        calc.push(1);
        double result = calc.perform(Operation.cos);

        assertEquals(Math.cos(1), result, 0);
    }

    @Test
    public void testDotProductSimple() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(1.0);
        calc.push(3.0);
        calc.push(2.0);
        calc.push(4.0);
        calc.push(2.0);
        double result = calc.perform(Operation.dotproduct);
        assertEquals(14.0, result, 0.001);
    }

    @Test
    public void testDotProduct3D() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(1.0);
        calc.push(2.0);
        calc.push(3.0);
        calc.push(4.0);
        calc.push(5.0);
        calc.push(6.0);
        calc.push(3.0);
        double result = calc.perform(Operation.dotproduct);
        assertEquals(32.0, result, 0.001);
    }

    @Test(expected = CalculatorException.class)
    public void testDotProductInvalidSize() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(1.0);
        calc.push(2.0);
        calc.push(-1.0);
        calc.perform(Operation.dotproduct);
    }
}