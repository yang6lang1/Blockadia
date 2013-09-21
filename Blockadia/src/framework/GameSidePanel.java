package framework;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * The control panel at the side
 * 
 * @author alex.yang
 **/

@SuppressWarnings("serial")
public class GameSidePanel extends JPanel{
	
	public static final int SIDE_PANEL_WIDTH = 200;
	
	public GameSidePanel(GameModel model, GameController controller){
		
		this.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, GamePanel.DEFAULT_HEIGHT));
	}

}
