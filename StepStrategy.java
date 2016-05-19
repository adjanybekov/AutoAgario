
import java.util.*;

/**
 * 
 */
public abstract class StepStrategy {

    /**
     * Default constructor
     */
//	Environment env;
    public StepStrategy() {

    }

    /**
     * 
     */
    public int numberOfTurns;



    /**
     * @return
     */
   
    
    public abstract String getName();

    public abstract void step(Entity e, double deltaTime);

}