package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ModelTest {
  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  Updatable view = context.mock(Updatable.class);

  Model calculator = new Model(view);

  @Test
  public void addDigitToStackWhenDigitButtonIsPressed() {
    context.checking(
        new Expectations() {
          {
            ignoring(view);
          }
        });

    calculator.addToCurrentDigits(1);
    calculator.addToCurrentDigits(2);
    assertThat(calculator.currentDigits.peek(), is(2));
  }

  @Test
  public void ensureAtLeastTwoDigitsOnStackWhenOperatorButtonIsPressed() {
    context.checking(
        new Expectations() {
          {
            ignoring(view);
          }
        });

    calculator.addToCurrentDigits(1);
    try {
      calculator.calculate("+");
      fail("Should have thrown exception: not enough numbers on stack to perform operation");
    } catch (IllegalStateException e) {
      assertEquals("Not enough numbers on stack", e.getMessage());
    }
  }

  @Test
  public void ensureCalculationOfSumIsCorrect() {
    context.checking(
        new Expectations() {
          {
            ignoring(view);
          }
        });

    calculator.addToCurrentDigits(1);
    calculator.addToCurrentDigits(2);
    calculator.calculate("+");
    assertThat(calculator.currentDigits.peek(), is(3));
  }

  @Test
  public void ensureCalculationOfSubtractionIsCorrect() {
    context.checking(
        new Expectations() {
          {
            ignoring(view);
          }
        });

    calculator.addToCurrentDigits(3);
    calculator.addToCurrentDigits(2);
    calculator.calculate("-");
    assertThat(calculator.currentDigits.peek(), is(1));
  }
}
