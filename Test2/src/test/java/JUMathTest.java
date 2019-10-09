
import org.junit.*;

public class JUMathTest extends Assert {

    private Math math;
    private double PI;

    @Before
    public void setup() {
        math = new Math();
        PI = java.lang.Math.PI;
    }

    @Test
    public void testFactorialWhenValueIsZero() {
        try {
            long foo = math.factorial(0);
            assertEquals(foo, 1);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void testFactorialWhenValueLessThenZero() {
        try {
            long foo = math.factorial(-1);
            assertNull(foo);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testFactorialIs1WhenValueIs1() {
        try {
            long foo = math.factorial(1);
            assertEquals(foo, 1);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void testFactorialIs120WhenValueIs5() {
        try {
            long foo = math.factorial(5);
            assertEquals(foo, 120);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void testSinusIsZeroWhenXEquals0() {
        double foo = math.sin(0, 15);

        assertEquals(foo, 0, 0.01);
    }

    @Test
    public void testSinusIsZeroWhenXEquals6Pi() {
        double foo = math.sin(6*PI, 20);

        assertEquals(foo, 0.0, 1);
    }

    @Test
    public void testSinusIsZeroWhenValueIsPi() {
        double foo = math.sin(PI, 15);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testSinusIs1WhenValueIsPiHalf() {
        double foo = math.sin(PI / 2, 15);
        assertEquals(foo, 1.0, 0.01);
    }

    @Test
    public void testSinusIsZeroWhenValueIsMinusPi() {
        double foo = math.sin(- PI, 15);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testSinusIsMinus1WhenValueIsMinusPiHalf() {
        double foo = math.sin(- PI / 2, 15);
        assertEquals(foo, - 1.0, 0.01);
    }

    @Test
    public void testSinusIsMinus1WhenValueIs3PiHalf() {
        double foo = math.sin(3*PI/2, 10);
        assertEquals(foo, - 1.0, 0.01);
    }


    @Test
    public void testSinusDifferentDeltaGivesDifferentValues() {
        double foo = math.sin(- PI / 2, 1);
        double bar = math.sin(- PI / 2, 15);
        assertNotEquals(foo, bar, 0.01);
    }

    @Test
    public void testCosIsZeroWhenXEquals1() {
        double foo = math.cos(0);

        assertEquals(foo, 1, 0.01);
    }

    @Test
    public void testCosIsZeroWhenValueIsPiHalf() {
        double foo = math.cos(PI / 2);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testCosIsZeroWhenValueIsMinusPiHalf() {
        double foo = math.cos(PI / 2);
        assertEquals(foo, 0, 0.01);
    }

    @Test
    public void testCosIsMinus1WhenValueIsMinusPi() {
        double foo = math.cos(PI);
        assertEquals(foo, - 1.0, 0.01);
    }

    @Test
    public void testCosIs1WhenValueIsPiSixth() {
        double foo = math.cos(- PI / 6);
        double bar = java.lang.Math.sqrt(3)/2;
        assertEquals(foo, bar, 0.01);
    }

    @Test
    public void testTgIsZeroWhenValueIsZero() {
        double foo = math.tg(0);
        assertEquals(foo, 0, 0.01);
    }

    @Test
    public void testTgIs1WhenValueIsPiFourth() {
        double foo = math.tg(PI/4);
        assertEquals(foo, 1, 0.01);
    }

    @Test
    public void testTgIsMaxDoubleWhenValueIsPiHalf() {
        double foo = math.tg(PI/2);
        assertEquals(foo, Double.POSITIVE_INFINITY, 0.01);
    }

    @Test
    public void testRoundDouble() {
        double foo = Math.round(PI, 2);
        assertEquals(foo, 3.14, 0.01);
    }

    @Test
    public void testRoundWhenPlaceLessThenZero() {
        try {
            double foo = Math.round(PI, -1);
            assertNull(foo);
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testCscIs1WhenValueIsPiHalf() {
        double foo = math.csc(PI/2);
        assertEquals(foo, 1.0, 0.01);
    }

    @Test
    public void testCscIsMinus1WhenValueIs3PiHalf() {
        double foo = math.csc(3*PI/2);
        assertEquals(foo, - 1.0, 0.01);
    }

    @Test
    public void testCscIsInfinityWhenValueIs0() {
        double foo = math.csc(0);
        assertEquals(foo, Double.POSITIVE_INFINITY, 0.01);
    }

    @Test
    public void testCscIsSqrt2WhenValueIsPiFourth() {
        double foo = math.csc(PI/4);
        assertEquals(foo, java.lang.Math.sqrt(2),0.01);
    }

    @Test
    public void testCtgIsMaxDoubleWhenValueIs0() {
        double foo = math.ctg(0);
        assertEquals(foo, Double.POSITIVE_INFINITY, 0.01);
    }

    @Test
    public void testCtgIsMaxDoubleWhenValueIsPi() {
        double foo = math.ctg(PI);
        assertEquals(foo, Double.NEGATIVE_INFINITY, 0.01);
    }

    @Test
    public void testCtgIs1WhenValueIsPiFourth() {
        double foo = math.ctg(PI/4);
        assertEquals(foo, 1, 0.01);
    }

    @Test
    public void testCtgIsZeroWhenValueIsPiHalf() {
        double foo = math.ctg(PI/2);
        assertEquals(foo, 0, 0.01);
    }

//    @Test
//    public void testResultIs1WhenLn() {
//        double foo = math.ln(2,5);
//        assertEquals(foo, 1, 0.1);
//    }

    @Test
    public void testResultIs2WhenLog2_4() {
        double foo = math.log(2,4);
        assertEquals(foo,2,0.1);
    }

    @Test
    public void testResultIs2WhenLog5_25() {
        double foo = math.log(5,25);
        assertEquals(foo,2,0.1);
    }

    @Test
    public void testResultIs3WhenLog5_125() {
        double foo = math.log(5,125);
        assertEquals(foo,3,0.1);
    }

    @Test
    public void testResultIsNullAndThrowsWhenLogMinus5_125() {
        try {
            double foo = math.log(-5, 125);
            assertNull(foo);
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }
}
