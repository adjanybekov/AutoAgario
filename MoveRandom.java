
import java.util.*;

/**
 * 
 */
public class MoveRandom extends StepStrategy {

    /**
     * Default constructor
     */
	Environment env;
    public MoveRandom(Environment env) {
    	this.env = env;
    }
 
   

    
    public  String getName(){
        return "MvRand";
    }

  
    public void step(Entity e, double deltaTime){
   
    	
 	   // Cell smallCell = null;
    	while(deltaTime > 0)
    	{
    		e.dir.x = (Math.random() * (2)) + (-1);
     	    e.dir.y = (Math.random() * (2)) + (-1);
     	    e.dir = e.dir.normalize();
    	   e.location.x += e.dir.x;
    	   e.location.y += e.dir.y;
    	   
    	   
    	   for(int i = 0; i< env.foodList.size(); i++){
    		   if( e.location.distanceTo(env.foodList.get(i).location) <=30)//== .location.x && e.location.y == env.foodList.get(i).location.y )
    		   {  	e.mass+=env.foodList.get(i).mass;
    		   		e.speed+=env.foodList.get(i).speed;
    			   env.entities.remove(env.foodList.get(i));
    		   		env.foodList.remove(env.foodList.get(i));
      		   }
    	   }
    	   deltaTime--;
    	   
    	  
       
    	}
        
        	
       
    
    	
	
		
   
    }
}


