
import java.util.*;

/**
 * 
 */
public class SugarFactory extends FoodFactory {

    /**
     * Default constructor
     */
    public SugarFactory() {
    	
    }

    /**
     * @param env 
     * @return
     */
    public Food createFood(Environment env){
        return new Sugar();
    }
    //entity[] new Sugar();

}