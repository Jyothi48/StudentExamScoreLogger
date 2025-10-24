package task2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class ScoreTest{
private static final String TEST_FILE = "test_scores.csv";

@BeforeEach
public void setup() throws IOException {
    Files.deleteIfExists(Paths.get(TEST_FILE));
}

@Test
public void testFileWriting() throws IOException {
    Scorewriter writer = new Scorewriter(TEST_FILE);
    Students student = new Students("TestUser", 99, 100);

    writer.writeToFile(student);

    String content = Files.readString(Paths.get(TEST_FILE));
    assertTrue(content.contains("TestUser,99,100"));
}

@Test
public void testThreadCompletion() throws InterruptedException, IOException {
    Scorewriter writer = new Scorewriter(TEST_FILE);
    Thread t1 = new ThreadStudents(new Students("S1", 1, 80), writer);
    Thread t2 = new ThreadStudents(new Students("S2", 2, 90), writer);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    long lines = Files.lines(Paths.get(TEST_FILE)).count();
    assertEquals(2, lines);
}
}