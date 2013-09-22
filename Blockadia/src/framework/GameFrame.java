package framework;

import interfaces.IGamePanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * The Blockadia frame. Contains all stuff. Make sure you in the GameMain.java call 
 * {@link #setVisible(boolean)} and
 * {@link #setDefaultCloseOperation(int)}.
 * 
 * @author alex.yang
 **/

@SuppressWarnings("serial")
public class GameFrame  extends JFrame {
	
	private GameMenuBar menu;
	private GameInfoBar infoBar;
	private GameSidePanel side;
	private GameModel model;
	private GameController controller;

	public GameFrame(final GameModel argModel, final IGamePanel argPanel) {
		super("Blockadia");
		setLayout(new BorderLayout());
		
		model = argModel;

		menu = new GameMenuBar();//TODO: rework on the GameMenuBar constructor
		setJMenuBar(menu);
		infoBar = new GameInfoBar();
		add(infoBar,"South");
		
		controller = new GameController(model,argPanel);
		side = new GameSidePanel(model,controller);
		add((Component) argPanel, "Center");
		//add(new JScrollPane(side), "East");
		add(side,"East");
		pack();

		//controller.playTest(0);
		//controller.start();
	}

}
