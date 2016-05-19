
import java.util.*;

/**
 * 
 */
public class ChaseSmaller extends StepStrategy {
	

	public Environment env;
	
    public ChaseSmaller(Environment env) {
    	this.env = env;
    	
    }

    
   
    public String getName(){//Name is Apsent /////////////////////////////////
    
    return "ChSm";
    }  
    
    double minDistance = 2000, distance;

    public void step(Entity e, double deltaTime){// STEP_FUNCTION 
    	
    	Cell smallCell = null;
    	
    	
    	for (int i = 0; i<env.entities.size() ; i++){
    		if(env.entities.get(i) instanceof Cell ){
    			if(env.entities.get(i)!=e){
    				distance = e.location.distanceTo(env.entities.get(i).location);
    				if(distance<minDistance){
    					minDistance = distance;
    					smallCell = (Cell) env.entities.get(i);
    				}
    			}
        			
    		}
    		}
    	
    	
    	if(e.mass >= smallCell.mass){
    		Vector  newDirect = new Vector(smallCell.location.x- e.location.x, smallCell.location.y- e.location.y); 
    		newDirect= newDirect.normalize();
    		e.location.x += newDirect.x;
        	
        	e.location.y += newDirect.y;
    	}
    		
    	//while(deltaTime > 0){
    	  if(e.location.distanceTo(smallCell.location) <= 1 ){
    		  e.mass+= smallCell.mass;
    		  e.speed+=smallCell.speed;
    		  env.entities.remove(smallCell);
    		  deltaTime--;
    	   }
    	//  }
    	  
    	  
    	
    	
    	
   
}
    
    
}
    	
    
        
    

