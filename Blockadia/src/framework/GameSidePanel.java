package framework;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * The control panel at the side
 * 
 * @author alex.yang
 **/

@SuppressWarnings("serial")
public class GameSidePanel extends JPanel{
	
	public static final int SIDE_PANEL_WIDTH = GamePanel.DEFAULT_WIDTH/3;
	
	public GameSidePanel(GameModel model, GameController controller){
		
		setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, GamePanel.DEFAULT_HEIGHT));
		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray), "Game Contr"));
	}

}
