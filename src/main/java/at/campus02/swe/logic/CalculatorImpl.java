package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.sql.Array;
import java.util.Stack;

import static java.lang.Float.NaN;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {
        if(op == Operation.dotproduct) {
            int vectorSize = (int) pop();

            if (vectorSize <= 0) {
                throw new CalculatorException("Ungültige Vektorgröße! Vektorgröße muss größer als 0 sein.");
            }

            if (stack_.size() < 2 * vectorSize) {
                throw new CalculatorException("Nicht genügend Werte auf dem Stack für zwei Vektoren mit der angegebenen Größe.");
            }

            double[] vector1 = new double[vectorSize];
            double[] vector2 = new double[vectorSize];

            for (int i = 0; i < vectorSize; i++) {
                vector1[i] = pop();
            }
            for (int i = 0; i < vectorSize; i++) {
                vector2[i] = pop();
            }

            double result = 0.0;
            for (int i = 0; i < vectorSize; i++) {
                result += vector1[i] * vector2[i];
            }

            return result;

        }

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
