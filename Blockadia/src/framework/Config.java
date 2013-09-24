package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.Block;
import components.BlockShape;

import exceptions.ElementExistsException;
import exceptions.ElementNotExistException;

/**
 * This class represent a custom-created game configuration.
 * It also has all the custom-created BlockShape's that belongs to it,
 * all the world settings and the all the blocks in the game board.
 * */
public class Config {

	private Map<String, BlockShape> shapes;
	private List<Block> blocks;
	
	public Config(){
		shapes = new HashMap<String, BlockShape>();
		blocks = new ArrayList<Block>();
	}
	
	public void setGameShapes(final Map<String, BlockShape> shapes){
		this.shapes = shapes;
	}
	
	public Map<String, BlockShape> getGameShapes(){
		return this.shapes;
	}
	
	public void addGameShape(BlockShape shape) throws ElementExistsException{
		if(shapes.containsKey(shape.getShapeName())){
			throw new ElementExistsException("The shape with the same name already exist");
		}
		shapes.put(shape.getShapeName(),shape);
	}
	
	public void deleteGameShape(BlockShape shape) throws ElementNotExistException{
		if(!shapes.containsValue(shape)){
			throw new ElementNotExistException("The shape does not exist");
		}
		shapes.remove(shape);
	}
	
	public void deleteGameShape(String shapeName) throws ElementNotExistException{
		if(!shapes.containsKey(shapeName)){
			throw new ElementNotExistException("The shape with name: "+ shapeName +" does not exist");
		}
		shapes.remove(shapes.get(shapeName));
	}
	
}
