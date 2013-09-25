package framework;

import javax.swing.DefaultComboBoxModel;

import org.jbox2d.common.Vec2;

import components.BlockShape;

/**
 * Model of the Blockadia game
 * 
 * @author alex.yang
 * */
public class GameModel {

	private final DefaultComboBoxModel<BlockShape> components = new DefaultComboBoxModel<BlockShape>();
	private final Vec2 mouse = new Vec2();
	
	private Config config;
	private double panelWidth;
	private double calculatedFPS;
	
	public GameModel(){	
		//for testing purpose:
		components.addElement(new BlockShape());
		components.addElement(new BlockShape("New Name"));
	}
	
	public Config getCurrGameConfig(){
		return this.config;
	}
	
	public void setCurrGameConfig(final Config config){
		this.config = config;
	}
	
	public Vec2 getMouse(){
		return this.mouse;
	}
	
	public void setMouse(final Vec2 mouse){
		this.mouse.set(mouse);
	}
	
	public double getPanelWidth(){
		return this.panelWidth;
	}
	
	public void setPanelWidth(final double panelWidth){
		this.panelWidth = panelWidth;
	}
	
	public double getCalculatedFPS(){
		return this.calculatedFPS;
	}
	
	public void setCalculatedFPS(final double FPS){
		this.calculatedFPS = FPS;
	}
	
	public DefaultComboBoxModel<BlockShape> getComboModel(){
		return this.components;
	}
}
