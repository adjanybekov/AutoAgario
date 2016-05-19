
import java.util.*;

/**
 * 
 */
public class OrganismFactory extends FoodFactory {

    /**
     * Default constructor
     */
    public OrganismFactory() {
    }

    /**
     * @param env 
     * @return
     */
    public  Food createFood(Environment env){
        return new Organism();
    }

}