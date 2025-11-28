package Main;

public class SceneChanger {

	GameManager gm;
	boolean start=false;
	int bgNow;
	
	public SceneChanger(GameManager gm)  {this.gm = gm;}
	
	public int getbgNow() {return bgNow;}
	
	// show dialouge screen
	public void showDialogueScreen() {
		
		bgNow = 1;
		
		gm.ui.bgPanel[0].setVisible(false);
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
	}
	// show select ingredient screen
	public void showSelectIngScreen() {

		bgNow = 2;
		
		gm.ui.bgPanel[0].setVisible(false);
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);

	}
	// show stove screen
	public void showStoveScreen() {

		bgNow = 3;
		
		gm.ui.bgPanel[0].setVisible(false);
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.bgPanel[4].setVisible(false);

	}
	// show package screen
	public void showExtraScreen() {
		
		bgNow = 4;
		
		gm.ui.bgPanel[0].setVisible(false);
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
	}
	
	public void showGameOver() {
		
		gm.ui.bgPanel[0].setVisible(false);
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
	}
	
	
}