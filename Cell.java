
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public abstract class Cell extends Entity {

    /**
     * Default constructor
     */
    public Cell() {
    	
    	name = "Azat";
    	foodeaten = 12;
    	cellsSwallowed = 5;
    	this.radius = 12;
    	
    }

    
    public String name;

   // public int radius;
    public int foodeaten;

    
    public int cellsSwallowed;

    /**
     * @param additionalMass 
     * @return
     */
    public void addMass(double additionalMass) {
    	this.mass+=additionalMass;
    	
    }

    /**
     * @param reductionalMass 
     * @return
     */
    public void removeMass(double reductionalMass) {
    	this.mass-=reductionalMass;
    }

    /**
     * @param g2d 
     * @return
     */
    public abstract void draw(Graphics2D g2d);

}