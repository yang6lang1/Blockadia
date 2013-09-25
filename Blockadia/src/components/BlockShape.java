package components;

import org.jbox2d.common.Vec2;

/**
 * This class represents the shape of a custom-paint block
 * 
 * @author alex yang
 * */
public class BlockShape {

	public static final Vec2 DEFAULT_RESOLUTION = new Vec2(4,4);
	
	private String blockShapeName;
	private Vec2 resolution; 									//This decides weather the grid is 3x3 or 4x4, etc
	private boolean[][] shape;								//2D map of the game shape
	
	public BlockShape(){
		this("NONAME",DEFAULT_RESOLUTION,new boolean[4][4]);
	}
	
	public BlockShape(final String shapeName){
		this(shapeName,DEFAULT_RESOLUTION,new boolean[4][4]);
	}
	
	public BlockShape(final String shapeName, final Vec2 resolution, final boolean[][] shape){
		this.blockShapeName = shapeName;
		this.resolution = resolution;
		this.shape = shape;
	}
	
	public void setShapeName(final String shapeName){
		this.blockShapeName = shapeName;
	}
	
	public String getShapeName(){
		return this.blockShapeName;
	}

	public void setResolution(final Vec2 resolution){
		this.resolution = resolution;
	}
	
	public Vec2 getResolution(){
		return this.resolution;
	}
	
	public void setShape(final boolean[][] shape){
		this.shape = shape;
	}
	
	public boolean[][] getShape(){
		return this.shape;
	}

	public boolean equals(Object otherShape){
		if (otherShape == null) return false;
		if (otherShape == this) return true; // this might cause a problem
		if (!(otherShape instanceof BlockShape))return false;
		BlockShape anotherShape = (BlockShape)otherShape;
		//compare the name of the shape object
		if(anotherShape.getShapeName() == this.blockShapeName){
			return true;
		}else{
			return false;
		}
	}
}
