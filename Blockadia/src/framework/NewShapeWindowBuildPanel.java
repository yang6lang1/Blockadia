package framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jbox2d.common.Vec2;

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
	
	public static final Color DEFAULT_PAINT_COLOR = Color.green;
	public static final int SHAPE_WIN_SIZE = 400;
	private BlockShape blockShape;
	private Color paintColor;
	private boolean isDirty;
	
	public NewShapeWindowBuildPanel(){
		this(new BlockShape());
	}
	
	public NewShapeWindowBuildPanel(BlockShape blockShape){
		this.blockShape = blockShape;
		this.setPreferredSize(new Dimension(SHAPE_WIN_SIZE,SHAPE_WIN_SIZE));
		setBackground(Color.black);
		paintColor = DEFAULT_PAINT_COLOR;
		
		addListeners();
	}
	
	public void setGridResolution(final Vec2 newResolution){
		blockShape.setResolution(newResolution);
		this.repaint();
	}
	
	public Vec2 getGridResolution(){
		return this.blockShape.getResolution();
	}
	
	public void setPaintColor(final Color paintColor){
		this.paintColor = paintColor;
	}
	
	public Color getPaintColor(){
		return this.paintColor;
	}
	
	public void setIsDirty(final boolean isDirty){
		this.isDirty = isDirty;
	}
	
	public boolean checkIsDirty(){
		return this.isDirty;
	}
	
	public void addListeners(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(SwingUtilities.isLeftMouseButton(e)){				//if left click
					if(e.getX() < SHAPE_WIN_SIZE && e.getY() < SHAPE_WIN_SIZE){
						int gridSize =  (int)(SHAPE_WIN_SIZE/(int)blockShape.getResolution().x);
						int col = (int)(e.getX()/gridSize);					//which col is the clicked position
						int row = (int)(e.getY()/gridSize);					//which row is the clicked position
						blockShape.setShapeElement(paintColor, row, col);
						setIsDirty(true);
						repaint();
					}	
				}
				else if(SwingUtilities.isRightMouseButton(e)){	//if right click
					if(e.getX() < SHAPE_WIN_SIZE && e.getY() < SHAPE_WIN_SIZE){
						int gridSize =  (int)(SHAPE_WIN_SIZE/(int)blockShape.getResolution().x);
						int col = (int)(e.getX()/gridSize);					//which col is the clicked position
						int row = (int)(e.getY()/gridSize);					//which row is the clicked position
						blockShape.setShapeElement(BlockShape.DEFAULT_COLOR, row, col);
						setIsDirty(true);
						repaint();
					}			
				}
				
			}
		});
    
    
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
      	
				if(SwingUtilities.isLeftMouseButton(e)){				//if left click
					if(e.getX() < SHAPE_WIN_SIZE && e.getY() < SHAPE_WIN_SIZE){
						int gridSize =  (int)(SHAPE_WIN_SIZE/(int)blockShape.getResolution().x);
						int col = (int)(e.getX()/gridSize);					//which col is the clicked position
						int row = (int)(e.getY()/gridSize);					//which row is the clicked position
						blockShape.setShapeElement(paintColor, row, col);
						setIsDirty(true);
						repaint();
					}	
				}
				else if(SwingUtilities.isRightMouseButton(e)){	//if right click
					if(e.getX() < SHAPE_WIN_SIZE && e.getY() < SHAPE_WIN_SIZE){
						int gridSize =  (int)(SHAPE_WIN_SIZE/(int)blockShape.getResolution().x);
						int col = (int)(e.getX()/gridSize);					//which col is the clicked position
						int row = (int)(e.getY()/gridSize);					//which row is the clicked position
						blockShape.setShapeElement(BlockShape.DEFAULT_COLOR, row, col);
						setIsDirty(true);
						repaint();
					}			
				}

      }
    });
    

	}
	
	public void paintComponent(Graphics g){
  	// repaint the proper background color (controlled by the windowing system)
		super.paintComponent(g);

		int numOfRows = (int)blockShape.getResolution().x;
		int numOfCols = (int)blockShape.getResolution().y;
		int gridSize = (int)(SHAPE_WIN_SIZE/numOfRows);
		
		//1st: paint each element in the BlockShape -> shape(Color[][])
		for(int i=0; i< numOfRows;i++){
			for(int j=0; j< numOfCols; j++){
				g.setColor(blockShape.getShapeElement(i, j));
				g.fillRect(j*gridSize, i*gridSize, gridSize, gridSize);
			}
		}
	
		//2nd: paint the grid corresponding to the resolution of blockShape
		g.setColor(Color.orange);
		for (int row = 0; row <= numOfRows; row++) {
			g.drawLine(0,row*gridSize ,SHAPE_WIN_SIZE, row*gridSize);
		}
		g.drawLine(0,SHAPE_WIN_SIZE-1, SHAPE_WIN_SIZE, SHAPE_WIN_SIZE-1);

		for (int col = 0; col <= numOfCols; col++) {
			g.drawLine(col*gridSize, 0 , col*gridSize , SHAPE_WIN_SIZE);
		}
		g.drawLine(SHAPE_WIN_SIZE-1, 0, SHAPE_WIN_SIZE-1, SHAPE_WIN_SIZE);
	}
}
