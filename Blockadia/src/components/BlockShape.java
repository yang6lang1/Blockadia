package components;

/**
 * This class represents the shape of a custom-paint block
 * 
 * @author alex yang
 * */
public class BlockShape {

	private String blockShapeName;
	
	public BlockShape(){
		
	}
	
	public void setShapeNam(final String shapeName){
		this.blockShapeName = shapeName;
	}
	
	public String getShapeName(){
		return this.blockShapeName;
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
