
import java.util.*;

/**
 * 
 */
public class StandStill extends StepStrategy {

    /**
     * Default constructor
     */
    public StandStill() {
    }



    /**
     * 
     */
    public void StandStill() {
        // TODO implement here
    }

    
    
    public String getName(){
    	
        return "SS";
    }

    
    public void step(Entity e, double deltaTime){
    	for(int i = 0 ; i<deltaTime; i++){
    		e.location = e.location;
    	}
        
    }

}