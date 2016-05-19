
import java.util.*;

/**
 * 
 */
public abstract class FoodFactory {

    /**
     * Default constructor
     */
    public FoodFactory() {
    }

   
    
    public abstract Food createFood(Environment env);

}