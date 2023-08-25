package marcotumminia.ultimoProgettoSettimanaleJava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Probe {

	private Long id;
	private String latitudine;
	private String longitudine;
	private Integer livelloFumo = 0;
	
	public Probe(Long id, String latitudine, String longitudine) {

		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		
	}

}