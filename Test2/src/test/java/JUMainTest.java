import org.junit.*;

import java.util.List;

public class JUMainTest extends Assert {

    Main main;

    @Before
    public void setup() {
        main = new Main();
    }

    @Test
    public void testWritingAvailableWithPositiveStep() {
        boolean foo = main.writeToFile(Module.func, 0.1, 5);
        assertTrue(foo);
    }

    @Test
    public void testWritingAvailableWithNegativeStep() {
        boolean foo = main.writeToFile(Module.func,-0.1, 5);
        assertTrue(foo);
    }

    @Test
    public void testWritingAvailableWithZeroStep() {
        boolean foo = main.writeToFile(Module.func,0, 5);
        assertFalse(foo);
    }

    @Test
    public void testRowCreation() {
        double bar = 5.0;
        List<String> foo = main.createRow(Module.func, bar);
        assertNotNull(foo);
        assertEquals(foo.get(0), String.valueOf(bar));
    }

    @Test
    public void testSolvingSin() {
        double foo = main.solve(Module.sin, java.lang.Math.PI);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testSolvingCos() {
        double foo = main.solve(Module.cos, java.lang.Math.PI);
        assertEquals(foo, -1.0, 0.01);
    }

    @Test
    public void testSolvingTg() {
        double foo = main.solve(Module.tg, 0.0);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testSolvingCtg() {
        double foo = main.solve(Module.ctg, java.lang.Math.PI/2);
        assertEquals(foo, 0.0, 0.01);
    }

    @Test
    public void testSolvingCsc() {
        double foo = main.solve(Module.csc, java.lang.Math.PI/2);
        assertEquals(foo, 1.0, 0.01);
    }

    @Test
    public void testSolvingLog() {
        double foo = main.solve(Module.log, 8);

        assertEquals(foo, 3.0, 0.01);
    }
}
