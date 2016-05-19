
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public abstract class Entity {

   
    public Entity() {
    	color = Color.WHITE;
    	location = new Vector (0,0);
    	
    	mass = 1.0;
    	speed = 0.0;
    	dir = new Vector(0.0, 1.0);
    	this.radius = 0;
    }


    public Color color ;   //= new Color((int)(Math.random() * 0x1000000));
    public Vector location; 
    public Vector dir;
    public StepStrategy stepStrategy;
    
    public double mass;

    public double radius;
    public double speed;

    public void step(double deltaTime) {
    	stepStrategy.step(this, deltaTime);
    	
    	//gene
    }

    public abstract void draw(Graphics2D g2d);

}