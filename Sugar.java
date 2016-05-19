import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Sugar extends Food {
	
	
	int sideHalfength = (int) (Math.random() * (12 - 8)) + 8;
	

    /**
     * Default constructor
     */
    public Sugar() {
    	this.location.x = (int) (Math.random() * (1000-210)) +210;
    	this.location.y = (int) (Math.random() * (800-200)) +200;
    	
    	this.radius = sideHalfength ; 
    	this.color = new Color((int)(Math.random() * 0x1000000));
    	this.mass = 2;
    	this.speed = 0;
    	this.dir = new Vector(0.0, 1.0);
    	this.stepStrategy = new StandStill();
    	
    }
    
   
    
    @Override
    public void draw(Graphics2D g2d) {
    	g2d.setColor(this.color);
    	g2d.drawRect ((int)this.location.x, (int) this.location.y, sideHalfength, sideHalfength);   	
    }

}