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
		//model.setDebugDraw(argPanel.getDebugDraw());
		//controller = new TestbedController(model, argPanel, behavior);
		//side = new TestbedSidePanel(model, controller);
		menu = new GameMenuBar();
		setJMenuBar(menu);
		add((Component) argPanel, "Center");
		add(new JScrollPane(side), "East");
		pack();

		//controller.playTest(0);
		//controller.start();
	}

}
