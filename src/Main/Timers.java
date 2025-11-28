package Main;

import java.util.Timer;
import java.util.TimerTask;

public class Timers {


	GameManager gm;
	int secondsPassed = 0;
		
	Timers(GameManager gm){
			
		this.gm = gm;
	}
		
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		
		public void run() {
			
			secondsPassed++;
			System.out.println(secondsPassed);
		}
	};
		
	public void timeStart() {
		
		myTimer.scheduleAtFixedRate(task, 1000, 1000);	
	}
}