package application.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimerTask;

import application.control.ApplicationController;
import javafx.scene.text.Text;

public class CustomTimer extends TimerTask {

	private LocalTime time;
	private Text text;
	
	public CustomTimer(LocalTime time, Text text) {
		this.time = time;
		this.text = text;
	}
	
	public LocalTime getTimeObject() {
		return time;
	}
	
	public String getTimeText() {
		return time.format(DateTimeFormatter.ISO_TIME);
	}
	
	@Override
	public void run() {
		if(time.getHour() == 0 && time.getMinute() == 0 && time.getSecond() == 0 && time.getNano() == 0) {
			ApplicationController.lockAll();
			cancel();
		}else {
			time = time.minus(1, ChronoUnit.SECONDS);
			text.setText(getTimeText());
		}
	}

}
