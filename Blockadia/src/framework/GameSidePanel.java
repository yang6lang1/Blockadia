package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * The control panel at the side
 * 
 * @author alex.yang
 **/

@SuppressWarnings("serial")
public class GameSidePanel extends JPanel{
	
	public static final int SIDE_PANEL_WIDTH = GamePanel.DEFAULT_WIDTH/3;
	
  private JButton modeButton,playPauseButton,resetButton;
	
	public GameSidePanel(GameModel model, GameController controller){
		
		setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, GamePanel.DEFAULT_HEIGHT));
		initComponents();
	}
	
  public void initComponents() {
    setLayout(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    
    JPanel controlPanel = new JPanel();
    controlPanel.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.LOWERED),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
  }

}
