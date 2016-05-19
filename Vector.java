
import java.util.*;

/**
 * 
 */
public class Vector {

    /**
     * Default constructor
     */
    public Vector() {
    	x=0;
    	y=0;
    }

   
    public double x;

    /**
     * 
     */
    public double y;

    /**
     * @param x 
     * @param y
     */
    public Vector(double x, double y) {
    	this.x = x;
    	this.y = y;
    	
       
    }

    /**
     * @return
     */
    public Vector normalize() {
        // TODO implement here
    	Vector location = new Vector();
    	location.x = x/Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    	location.y = y/Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return location;
    }

    /**
     * @param other 
     * @return
     */
    public double distanceTo(Vector vector) {
    	double distance;
    	
    	distance = Math.sqrt(Math.pow((vector.x - this.x),2)+Math.pow((vector.y - this.y),2));
    	
    	return distance;
    }

}