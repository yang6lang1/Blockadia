package framework;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class NewShapeWindow extends JDialog {

	private GameSidePanel gsp;
	private NewShapeWindowBuildPanel buildPanel;
	private NewShapeWindowSidePanel sidePanel;
	

	public NewShapeWindow(GameFrame frame, GameSidePanel parent){
		super(frame,true);
		gsp = parent;
		setLayout(new BorderLayout());
		
		buildPanel = new NewShapeWindowBuildPanel();
		this.add((Component) buildPanel, "Center");
		sidePanel = new NewShapeWindowSidePanel(this,buildPanel);
		this.add(new JScrollPane(sidePanel), "East");
		
		this.setTitle("New Shape");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.pack();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {

				if(buildPanel.checkIsDirty()){
					int n = JOptionPane.showConfirmDialog(
							NewShapeWindow.this, "The shape has been modified. Do you want to save it?",
							"Unsaved changes",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if(n == JOptionPane.YES_OPTION){
						//TODO save the shape
						
						//1. Check the shape name
						//   Valid - create a new BlockShape and save it into the Config
						//   Invalid - show a message and abort the closing process
						System.out.println("New Shape Saved!");
						dispose();
					}
					else if(n == JOptionPane.NO_OPTION){
						dispose();
					}
					else if(n == JOptionPane.CANCEL_OPTION){
						//Do nothing, stay in this NewShapeWindow
					}
				}else{
					dispose();
				}

			}
		});
		
	}
}
