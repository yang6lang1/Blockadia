package framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import components.BlockShape;

/**
 * This is the build panel (300x300) in New Shape window
 * By default, it draws a 3x3 grid
 * It creates a BlockShape object while interacting with user
 * 
 * @author alex.yang
 * */
@SuppressWarnings("serial")
public class NewShapeWindowBuildPanel extends JPanel {
	
	public static final int SHAPE_WIN_SIZE = 300;
	private BlockShape blockShape;
	
	public NewShapeWindowBuildPanel(){
		this.setPreferredSize(new Dimension(SHAPE_WIN_SIZE,SHAPE_WIN_SIZE));
		setBackground(Color.black);
		blockShape = new BlockShape("NONAME");
		
		addListeners();
	}
	
	public void addListeners(){
		
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
      	//TODO
      }
    });
    
    
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
      	//TODO
      }
    });
    

	}
	
	public void paintComponent(Graphics g){
  	// repaint the proper background color (controlled by
		// the windowing system)
		super.paintComponent(g);
		//1st: paint the grid corresponding to the resolution of blockShape
		int numOfRows = (int)blockShape.getResolution().x;
		int numOfCols = (int)blockShape.getResolution().y;
		g.setColor(Color.orange);
		int gridSize = (int)(SHAPE_WIN_SIZE/numOfRows);
		for (int row = 0; row <= numOfRows; row++) {
			g.drawLine(0,row*gridSize ,SHAPE_WIN_SIZE, row*gridSize);
			//System.out.println("draw a line between:("+ 0+","+row*gridSize+") and ("+ SHAPE_WIN_SIZE+","+row*gridSize+")");
		}
		g.drawLine(0,SHAPE_WIN_SIZE-1, SHAPE_WIN_SIZE, SHAPE_WIN_SIZE-1);

		for (int col = 0; col <= numOfCols; col++) {
			g.drawLine(col*gridSize, 0 , col*gridSize , SHAPE_WIN_SIZE);
		}
		g.drawLine(SHAPE_WIN_SIZE-1, 0, SHAPE_WIN_SIZE-1, SHAPE_WIN_SIZE);

	/*	//paint the gridElements
		for(int i=0; i< this.gizmos.size();i++){
			gizmos.get(i).paintComponents(g.create());	
		}*/

	}
}
