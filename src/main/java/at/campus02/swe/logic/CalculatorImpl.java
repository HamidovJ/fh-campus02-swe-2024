package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

import static java.lang.Float.NaN;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {
        double b = pop();
        double a = NaN;

        if (op == Operation.sin || op == Operation.cos) {
            if (!stack_.isEmpty()) {
                throw new CalculatorException("Sinus or Cosinus of two values not possible.");
            }

            switch (op) {
                case sin:
                    return Math.sin(b);
                case cos:
                    return Math.cos(b);
            }
        } else {
            a = pop();

            switch (op) {
                case add:
                    return a + b;
                case sub:
                    return a - b;
                case div:
                    double c = a / b;
                    if (Double.isInfinite(c))
                        throw new CalculatorException("Division by zero");
                    return c;
                case mul:
                    return a * b;
                case mod:
                    double m = a % b;
                    if (Double.isNaN(m))
                        throw new CalculatorException("Modulo by zero");
                    return m;
            }
        }

        return 0;
    }


    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
