import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JUCSVManagerTest extends Assert {

    CSVManager manager;

    @Before
    public void setup() {
        manager = new CSVManager("/Users/max/Desktop/file.csv");
    }

    @After
    public void remove() {
        boolean foo = manager.removeFile();
        assertTrue(foo);
    }

    @Test
    public void testIsCsvFileExistWhenFunctionDone() {
        try {
            boolean foo = manager.createFile();
            assertTrue(foo);
        } catch (IOException e) {
            assertNull(e);
        }
    }

    @Test
    public void testIsCsvFileCreatedWhenPathDoesntContainsFileName() {
        try {
            boolean foo = manager.createFile("/Users/max/Desktop/");
            assertTrue(foo);
        } catch (IOException e) {
            assertNull(e);
        }
    }

    @Test
    public void testPrepareFileName() {
        File foo = manager.prepareFile("/Users/max/Desktop/");
        assertTrue(foo.getAbsolutePath().contains(".csv"));
    }

    @Test
    public void testDeleteFile() {
        try {
            boolean foo = manager.createFile();
            assertTrue(foo);
            boolean bar = manager.removeFile();
            assertTrue(bar);
        } catch (IOException e) {
            assertNull(e);
        }
    }

    @Test
    public void testWritingToTheFileWhenReadingFromTheFileAndCheckCorrection() {

        List<List<String>> rows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(i));
            list.add(String.valueOf(Function.solve(i)));
            rows.add(list);
        }

        try {
            manager.createFile();
            boolean foo = manager.writeLines(rows);
            assertTrue(foo);
        } catch (IOException e) {
            assertNull(e);
        }

        try {
            ArrayList<String[]> list = manager.readFile();
            assertNotNull(list);
            for (int i = 1; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length; j++) {
                    assertEquals(list.get(i)[j], rows.get(i - 1).get(j));
                }
            }
        } catch (IOException e) {
            assertNull(e);
        }
    }


}
