package marcotumminia.ultimoProgettoSettimanaleJava.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import marcotumminia.ultimoProgettoSettimanaleJava.interfaces.Observer;

@AllArgsConstructor

@Data

public class Probe implements Observer{

	private Long id;
	private String latitudine;
	private String longitudine;
	private Integer livelloFumo = 0;
	private Double temperature;
	
	private ControlCenter controlCenter;
	
	public Probe(Long id, String latitudine, String longitudine, Integer livelloFumo, Double temperature) {

		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
		this.temperature = temperature;
	}
	
	@Override
	public void warningControl() {
	    if (this.livelloFumo >= 5) {
	        String notificationUrl = generateNotificationUrl();
	        System.out.println("!!!WARNING!!! The probe n. " + id + " has detected a level of smoke of " + livelloFumo + "..." + 
	                 " !-DANGEROUS-! level of temperature: " + temperature + "°" + ", latitude: " + latitudine + " longitude: " + longitudine);
	        System.out.println("\"The ControlCenter has sent the notificationURL " + notificationUrl);
	    } else {
	        System.out.println("No danger detected by probe n. " + id + "..." + " Temperature level is ok: " + temperature + "°");
	    }
	}

	public String generateNotificationUrl() {
	    return "http://host/alarm?idsonda=" + id + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel="
	            + livelloFumo;
	}
}
