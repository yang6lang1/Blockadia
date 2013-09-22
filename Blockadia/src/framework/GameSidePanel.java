package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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

	private JButton modeButton = new JButton("Game Mode");
	private JButton playPauseButton = new JButton("Play");
	private JButton resetButton = new JButton("Reset");
	public static boolean test =true;//TODO:DELETE LATER

	public GameSidePanel(GameModel model, GameController controller){

		setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, GamePanel.DEFAULT_HEIGHT));
		initComponents();
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(0, 1));
		controlPanel.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.LOWERED),
				BorderFactory.createEmptyBorder(5, 2, 5, 2)));

		modeButton.setAlignmentX(CENTER_ALIGNMENT);
		playPauseButton.setAlignmentX(CENTER_ALIGNMENT);
		resetButton.setAlignmentX(CENTER_ALIGNMENT);
		
		ImageIcon icon = null;
		Image image=null;

		icon = new ImageIcon("res/side/Build-Icon.png");
		image=icon.getImage().getScaledInstance(80, 55,java.awt.Image.SCALE_SMOOTH);
		icon.setImage(image);
		modeButton=new JButton("Build Mode",icon);
		modeButton.setHorizontalTextPosition(JButton.CENTER);
		modeButton.setVerticalTextPosition(JButton.TOP);
		modeButton.setToolTipText("Click to enter build mode");
		modeButton.setPreferredSize(new Dimension(80,80));
		// when this button is pushed it enters game mode
		modeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				if(!test){
					System.out.println("Game mode");
					ImageIcon icon = null;
					Image image=null;
					icon = new ImageIcon("res/side/Game-Icon.png");
					image=icon.getImage().getScaledInstance(80, 55,java.awt.Image.SCALE_SMOOTH);
					icon.setImage(image);
					modeButton=new JButton("Game Mode",icon);
					modeButton.setToolTipText("Click to enter game mode");
					modeButton.setPreferredSize(new Dimension(80,80));
					test=true;
					System.out.println(test);
					repaint();
				}else{
					System.out.println("Build mode");
					ImageIcon icon = null;
					Image image=null;

					icon = new ImageIcon("res/side/Build-Icon.png");
					image=icon.getImage().getScaledInstance(80, 55,java.awt.Image.SCALE_SMOOTH);
					icon.setImage(image);
					modeButton=new JButton("Build Mode",icon);
					modeButton.setToolTipText("Click to enter game mode");
					modeButton.setPreferredSize(new Dimension(80,80));
					test=false;
					System.out.println(test);
					repaint();
				}
			}
		});

		playPauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

        if (test) {
        	playPauseButton.setText("Stop");
        	test = false;
        } else {
          playPauseButton.setText("Play");
          test = true;
        }
      
			}
		});


		Box buttonGroups = Box.createHorizontalBox();
		JPanel buttons1 = new JPanel();
		buttons1.setLayout(new GridLayout(0, 1));
		buttons1.add(modeButton);

		JPanel buttons2 = new JPanel();
		buttons2.setLayout(new GridLayout(0, 1));
		buttons2.add(playPauseButton);
		buttons2.add(resetButton);

		buttonGroups.add(buttons1);
		buttonGroups.add(buttons2);
		controlPanel.add(buttonGroups);
		add(controlPanel, "North");



		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(0, 1));
		optionPanel.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.LOWERED),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		optionPanel.add(new JLabel("Choose a test:"));

		add(optionPanel, "Center");

	}

}
