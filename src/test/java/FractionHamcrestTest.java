import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FractionHamcrestTest {

    @Test
    public void addTest() {
        final Fraction actual = Fraction.of(0, 3)
                .add(Fraction.of(1, 3));
        final Fraction expected = Fraction.of(3,9);

        assertThat(actual, is(expected));
    }

    @Test
    public void multiplyTest() {
        final Fraction actual = Fraction.of(1, 2)
                .multiply(Fraction.of(1, 1));

        assertThat(actual, is(Fraction.HALF));
    }

    @Test
    public void multiplyToIndeterminateTest() {
        final Fraction actual = Fraction.of(1, 1)
                .multiply(Fraction.of(0, 0));

        assertThat(actual, is(Fraction.INDETERMINATE));
    }

    @Test
    public void getDenominatorTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.getDenominator(), equalTo(7));
    }

    @Test
    public void getNominatorTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.getNominator(), equalTo(3));
    }

    @Test
    public void toStringTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.toString(),is("3/7"));
    }

    @Test
    public void hashCodeTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.hashCode(),equalTo(10));
    }

    @Test
    public void givenTwoFractionsThatSumsToFull() {
        final Fraction actual = Fraction.of(1, 2)
                .add(Fraction.of(1, 2));

        assertThat(actual, is(Fraction.FULL));
    }

    @Test
    public void givenFractionThatEqualsFull() {
        final Fraction actual = Fraction.of(1, 1);

        assertThat(actual, is(Fraction.FULL));
    }

    @Test
    public void givenFractionThatEqualsHalf() {
        final Fraction actual = Fraction.of(1, 2);

        assertThat(actual, is(Fraction.HALF));
    }

    @Test
    public void givenFractionThatEqualsOneThird() {
        final Fraction actual = Fraction.of(1, 3);

        assertThat(actual, is(Fraction.ONE_THIRD));
    }

    @Test
    public void shouldReturnDoubleValue() {
        final Fraction actual = Fraction.of(3, 7);

        assertThat(actual.doubleValue(), allOf(greaterThan(0.41), lessThan(0.43)));
    }

    @Test
    public void exceptionTest() {
        try {
            Fraction.of(1, 0);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
            return;
        }
        assertThat(true, is(false));

    }
}