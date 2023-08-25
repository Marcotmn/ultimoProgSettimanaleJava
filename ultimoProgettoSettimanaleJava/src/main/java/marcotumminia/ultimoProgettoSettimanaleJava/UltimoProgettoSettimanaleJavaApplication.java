package marcotumminia.ultimoProgettoSettimanaleJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import marcotumminia.ultimoProgettoSettimanaleJava.entities.ControlCenter;
import marcotumminia.ultimoProgettoSettimanaleJava.entities.Probe;


@SpringBootApplication
public class UltimoProgettoSettimanaleJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UltimoProgettoSettimanaleJavaApplication.class, args);

		Probe s = new Probe(1l, "13456", "15092", 0, 17.0);
		Probe s1 = new Probe(2l, "45983", "45968", 4, 34.0);
		Probe s2 = new Probe(3l, "12456", "42928", 8, 44.0);
		Probe s3 = new Probe(4l, "45962", "18429", 2, 18.0);
		Probe s4 = new Probe(5l, "56346", "23567", 0, 15.0);
		Probe s5 = new Probe(6l, "25235", "87421", 9, 48.0);
		Probe s6 = new Probe(7l, "62345", "00985", 10, 52.0);
		Probe s7 = new Probe(8l, "23451", "56788", 8, 42.0);
		Probe s8 = new Probe(9l, "73456", "23537", 5, 37.0);
		Probe s9 = new Probe(10l, "34673", "34888", 4, 35.0);

		ControlCenter cc = new ControlCenter();
		cc.register(s);
		cc.register(s1);
		cc.register(s2);
		cc.register(s3);
		cc.register(s4);
		cc.register(s5);
		cc.register(s6);
		cc.register(s7);
		cc.register(s8);
		cc.register(s9);


		cc.notifyObservers();
	}
}