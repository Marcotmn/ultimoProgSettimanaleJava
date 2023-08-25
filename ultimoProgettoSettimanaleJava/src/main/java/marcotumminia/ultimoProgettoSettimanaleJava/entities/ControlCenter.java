package marcotumminia.ultimoProgettoSettimanaleJava.entities;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marcotumminia.ultimoProgettoSettimanaleJava.interfaces.Observer;
import marcotumminia.ultimoProgettoSettimanaleJava.interfaces.Subject;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ControlCenter implements Subject {

	private Long id;

	private List<Probe> probeList = new ArrayList<>();

	@Override
	public void register(Observer o) {
		probeList.add((Probe) o);
	}

	@Override
	public void unregister(Observer o) {
		probeList.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Probe s : probeList) {
			s.warningControl();
		}
	}
}
