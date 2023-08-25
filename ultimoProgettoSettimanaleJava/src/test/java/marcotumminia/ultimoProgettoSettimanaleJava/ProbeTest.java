package marcotumminia.ultimoProgettoSettimanaleJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import marcotumminia.ultimoProgettoSettimanaleJava.entities.Probe;

@SpringBootTest
public class ProbeTest {
    private Probe probe;

    @BeforeEach
    public void setUp() {
        probe = new Probe(6l, "25235", "87421", 9, 48.0);
    }

    @Test
    public void smokeLevelControlWarningTest() {
        probe.setLivelloFumo(6);
        String expectedMessage = "!!!WARNING!!!";
        String result = captureConsoleOutput(() -> probe.warningControl());
        assertEquals(true, result.contains(expectedMessage));
    }

    @Test
    public void smokeLevelControlTestInBound() {
        probe.setLivelloFumo(3);
        String expectedMessage = "No danger detected";
        String result = captureConsoleOutput(() -> probe.warningControl());
        assertEquals(true, result.contains(expectedMessage));
    }

    private String captureConsoleOutput(Runnable code) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        code.run();

        System.setOut(originalOut);
        return outputStream.toString();
    }
}