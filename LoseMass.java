
import java.util.*;

/**
 * 
 */
public class LoseMass extends StepStrategy {

    /**
     * Default constructor
     */
    public LoseMass() {
    }

   
    
    public double LosePercentage =0.1;

   
    public String getName(){
        return "LsMss";
    }

    public void step(Entity e, double deltaTime){
    	while(deltaTime!=0)
    		e.mass-=e.mass*LosePercentage;
    	deltaTime--;
    	
}
    
}