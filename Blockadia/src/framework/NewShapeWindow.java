package framework;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class NewShapeWindow extends JDialog {

	private GameSidePanel gsp;
	private NewShapeWindowBuildPanel buildPanel;

	public NewShapeWindow(GameFrame frame, GameSidePanel parent){
		super(frame,true);
		gsp = parent;
		setLayout(new BorderLayout());
		
		buildPanel = new NewShapeWindowBuildPanel();
		this.add((Component) buildPanel, "Center");
		
		this.setTitle("New Shape");
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//TODO:Might need to check if saved
		this.pack();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				//TODO
			}
		});
		
    //Ensure the text field always gets the first focus.
    addComponentListener(new ComponentAdapter() {
        public void componentShown(ComponentEvent ce) {
        	//TODO
           // textField.requestFocusInWindow();
        }
    });
	}
}
