package ic.doc;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void addDigitToStackWhenDigitButtonIsPressed (){
        calculator.addToCurrentDigits(1);
        calculator.addToCurrentDigits(2);
        assertThat(calculator.currentDigits.peek(), is(2));
    }


    @Test
    public void ensureAtLeastTwoDigitsOnStackWhenOperatorButtonIsPressed(){
        calculator.addToCurrentDigits(1);
        try{
            calculator.calculate("+");
            fail("Should have thrown exception: not enough numbers on stack to perform operation");
        } catch (IllegalStateException e){
            assertEquals("Not enough numbers on stack", e.getMessage());
        }
    }

    @Test
    public void ensureCalculationOfSumIsCorrect(){
        calculator.addToCurrentDigits(1);
        calculator.addToCurrentDigits(2);
        int result = calculator.calculate("+");
        assertEquals(3, result);
    }

    @Test
    public void ensureCalculationOfSubtractionIsCorrect(){
        calculator.addToCurrentDigits(3);
        calculator.addToCurrentDigits(2);
        int result = calculator.calculate("-");
        assertEquals(1, result);
    }

    @Test
    public void addResultBackToStackAfterOperation(){
        calculator.addToCurrentDigits(3);
        calculator.addToCurrentDigits(2);
        int result = calculator.calculate("-");
        assertThat(calculator.currentDigits.peek(), is(result));
    }
}