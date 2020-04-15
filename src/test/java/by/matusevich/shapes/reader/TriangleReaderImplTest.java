package by.matusevich.shapes.reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.matusevich.shapes.exception.ReaderException;
import by.matusevich.shapes.reader.impl.TriangleReaderImpl;

import java.util.ArrayList;
import java.util.List;

public class TriangleReaderImplTest {

    TriangleReader triangleReader;

    @BeforeClass
    public void setUp() {
        triangleReader = new TriangleReaderImpl();
    }

    @Test
    public void reedAllDataTest() throws ReaderException {
        List<String> expected = new ArrayList<>();
        expected.add("1 1 2 1 1 2");
        expected.add("5 1 2 5 0 3");
        expected.add("3 1 4 1 1 2 3");
        expected.add("3w2 1 4 1 1 2 3");
        expected.add("3 1 4 1 1 2 3w");
        expected.add("       5 1 2 5 1 2");
        expected.add("8 7 6 5 1 2");

        List<String> actual;
        actual = triangleReader.reedAllData("src/main/resources/file.txt");

        for (int i=0;i<actual.size();i++){
            System.out.println(actual.get(i));
        }
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = ReaderException.class)
    public void reedAllDataTestExceptionsFileNotExist() throws ReaderException {

        List<String> expected = new ArrayList<>();
        expected.add("1 1 2 1 1 2");
        expected.add("5 1 2 5 1 2");
        expected.add("3 1 4 1 1 2 3");
        expected.add("3w2 1 4 1 1 2 3");
        expected.add("3 1 4 1 1 2 3w");
        expected.add("       5 1 2 5 1 2");
        expected.add("8 7 6 5 1 2");

        List<String> actual;
        actual = triangleReader.reedAllData("src/main/resources/file1.txt");

        for (int i=0;i<actual.size();i++){
            System.out.println(actual.get(i));
        }
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = ReaderException.class)
    public void reedAllDataTestEmptyFile() throws ReaderException {

        List<String> lines = new ArrayList<>();

        lines = triangleReader.reedAllData("src/main/resources/test_file.txt");
    }

}
