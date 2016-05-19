
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Organism extends Food {

    /**
     * Default constructor
     */

	
	int OrgRadius=(int) (Math.random() * (10 - 6)) + 6;;
	
	
	
//	Make the length of A screen Rsizable As the Width And Height Grow! 
	
    public Organism() {
    	this.location.x = (Math.random() * (1000-210))+210;
    	this.location.y = (double) (Math.random() * (800-200)) +200;
    	
    	this.radius = OrgRadius;
    	
    	this.color = new Color((int)(Math.random() * 0x1000000));
    	this.mass = 4;
    	this.speed = 0;
    	this.dir = new Vector(0.0, 1.0);
    	//this.
    	this.stepStrategy = new StandStill();
    	
    }
    

 
    @Override
    public void draw(Graphics2D g2d) {
    	g2d.setColor(this.color);
    	g2d.fillOval((int)location.x, (int)location.y , OrgRadius, OrgRadius);
    	
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}