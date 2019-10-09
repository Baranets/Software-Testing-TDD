import org.junit.Before;
import org.junit.*;

public class JUFunctionTest extends Assert {

    private double PI = java.lang.Math.PI;

    @Test
    public void testResultIs83WhenValueIsPiHalf() {
        double foo = Function.solve(PI/2);
        assertEquals(foo,83.8,1);
    }

    @Test
    public void testResultIsMinus398WhenValueIsPiFourth() {
        double foo = Function.solve(PI/4);
        assertEquals(foo,-398,1);
    }

    @Test
    public void testResultIs15WhenValueIsPi() {
        double foo = Function.solve(PI);
        assertEquals(foo,15.3,1);
    }

    @Test
    public void testResultIsNaNWhenValueIsMinusPiHalf() {
        double foo = Function.solve(-PI/2);
        assertEquals(foo, Double.NaN, 0.1);
    }

    @Test
    public void testResultIsNaNWhenValueIsMinusPi() {
        double foo = Function.solve(-PI);
        assertEquals(foo, Double.NaN, 0.1);
    }

    @Test
    public void testResultIsNanWhenValueIs1() {
        double foo = Function.solve(1);
        assertEquals(foo, Double.NaN, 0.1);
    }

    @Test
    public void testResultIsNanWhenValueIs0() {
        double foo = Function.solve(0);
        assertEquals(foo, Double.NaN, 0.1);
    }

}
