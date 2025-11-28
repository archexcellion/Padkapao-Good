
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	GameManager gm;
	public ActionHandler(GameManager gm) {this.gm = gm;}
	
	
	@Override
	public void actionPerformed(ActionEvent e)  {
		
		// recieve command
		String yourChoice = e.getActionCommand();
		
		// select case
		switch(yourChoice) {
		
			//game start
			case "start": gm.sChanger.showDialogueScreen(); break;
		
			//change scene
			case "goDialogueScreen": gm.sChanger.showDialogueScreen(); break;
			case "goSelectIngScreen": gm.sChanger.showSelectIngScreen(); break;
			case "goStoveScreen": gm.sChanger.showStoveScreen(); break;
			
			case "goExtraScreen" : gm.sChanger.showExtraScreen(); break;
		//case "goServeScreen" : gm.sChanger.showServe(); break;
			
			// game over
			case "restart": gm.ui.reset();
		}
	}
}