package ic.doc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    GuiApp app = new GuiApp();


    @Test
    public void addDigitToStackWhenDigitButtonIsPressed (){
        app.calculator.addToCurrentDigits(1);
        app.calculator.addToCurrentDigits(2);
        assertThat(app.calculator.currentDigits.peek(), is(2));
    }


    @Test
    public void ensureAtLeastTwoDigitsOnStackWhenOperatorButtonIsPressed(){
        app.calculator.addToCurrentDigits(1);
        try{
            app.calculator.calculate("+");
            fail("Should have thrown exception: not enough numbers on stack to perform operation");
        } catch (IllegalStateException e){
            assertEquals("Not enough numbers on stack", e.getMessage());
        }
    }

//    @Test
//    public void ensureCalculationOfSumIsCorrect(){
//        app.calculator.addToCurrentDigits(1);
//        app.calculator.addToCurrentDigits(2);
//        app.calculator.calculate("+");
//        assertEquals(3, app.calculator.currentDigits.peek());
//    }
//
//    @Test
//    public void ensureCalculationOfSubtractionIsCorrect(){
//        app.calculator.addToCurrentDigits(3);
//        app.calculator.addToCurrentDigits(2);
//        int result = app.calculator.calculate("-");
//        assertEquals(1, result);
//    }
//
//    @Test
//    public void addResultBackToStackAfterOperation(){
//        app.calculator.addToCurrentDigits(3);
//        app.calculator.addToCurrentDigits(2);
//        int result = app.calculator.calculate("-");
//        assertThat(app.calculator.currentDigits.peek(), is(result));
//    }
}