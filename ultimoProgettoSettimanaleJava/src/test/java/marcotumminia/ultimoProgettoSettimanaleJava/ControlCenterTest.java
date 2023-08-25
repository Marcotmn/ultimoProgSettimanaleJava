package marcotumminia.ultimoProgettoSettimanaleJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import marcotumminia.ultimoProgettoSettimanaleJava.entities.ControlCenter;
import marcotumminia.ultimoProgettoSettimanaleJava.entities.Probe;

@SpringBootTest
public class ControlCenterTest {
    private ControlCenter controlCenter;
    private Probe probe1;
    private Probe probe2;

    @BeforeEach
    public void setUp() {
        controlCenter = new ControlCenter();
        probe1 = new Probe(1l, "13456", "15092", 0, 17.0);
        probe2 = new Probe(7l, "62345", "00985", 10, 52.0);
        controlCenter.register(probe1);
        controlCenter.register(probe2);
    }

    @Test
    public void testNotifyObservers_Warning() {
        probe1.setLivelloFumo(6);
        probe2.setLivelloFumo(3);
        String expectedMessage = "!!!WARNING!!!";
        String result = captureConsoleOutput(() -> controlCenter.notifyObservers());
        assertEquals(true, result.contains(expectedMessage));
    }

    @Test
    public void testNotifyObservers_InBound() {
        probe1.setLivelloFumo(3);
        probe2.setLivelloFumo(1);
        String expectedMessage = "No danger detected";
        String result = captureConsoleOutput(() -> controlCenter.notifyObservers());
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