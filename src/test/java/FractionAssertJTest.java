import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FractionAssertJTest {

    @Test
    public void addTest() {
        final Fraction actual = Fraction.of(0, 3)
                .add(Fraction.of(1, 3));
        final Fraction expected = Fraction.of(3,9);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplyTest() {
        final Fraction actual = Fraction.of(1, 2)
                .multiply(Fraction.of(1, 1));

        assertThat(actual).isEqualTo(Fraction.HALF);
    }

    @Test
    public void multiplyToIndeterminateTest() {
        final Fraction actual = Fraction.of(1, 1)
                .multiply(Fraction.of(0, 0));

        assertThat(actual).isEqualTo(Fraction.INDETERMINATE);
    }

    @Test
    public void getDenominatorTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.getDenominator()).isEqualTo(7);
    }

    @Test
    public void getNominatorTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.getNominator()).isEqualTo(3);
    }

    @Test
    public void toStringTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.toString()).startsWith("3")
                .contains("/")
                .endsWith("7");
    }

    @Test
    public void hashCodeTest() {
        final Fraction actual = Fraction.of(3, 7);
        assertThat(actual.hashCode()).isEqualTo(10);
    }

    @Test
    public void givenTwoFractionsThatSumsToFull() {
        final Fraction actual = Fraction.of(1, 2)
                .add(Fraction.of(1, 2));

        assertThat(actual).isEqualTo(Fraction.FULL);
    }

    @Test
    public void givenFractionThatEqualsFull() {
        final Fraction actual = Fraction.of(1, 1);

        assertThat(actual).isEqualTo(Fraction.FULL);
    }

    @Test
    public void givenFractionThatEqualsHalf() {
        final Fraction actual = Fraction.of(1, 2);

        assertThat(actual).isEqualTo(Fraction.HALF);
    }

    @Test
    public void givenFractionThatEqualsOneThird() {
        final Fraction actual = Fraction.of(1, 3);

        assertThat(actual).isEqualTo(Fraction.ONE_THIRD);
    }

    @Test
    public void shouldReturnDoubleValue() {
        final Fraction actual = Fraction.of(3, 7);

        assertThat(actual.doubleValue()).isGreaterThan(0.41)
                .isLessThan(0.43);
    }

    @Test
    public void testexception() {

        try {
            Fraction.of(1, 0);
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}