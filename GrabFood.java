
import java.util.*;

/**
 * 
 */
public class GrabFood extends StepStrategy {

    /**
     * Default constructor
     */
	public Environment env;
	
    public GrabFood(Environment env) {
    	this.env  =  env;
    }


  
    public  String getName()
    {
    	
        return "GrbFfd";
    }
    
    double minDistance = 2000, distance;
    
    public void step(Entity e, double deltaTime){
    
    	Food minFood = null;
    	

    	for (int i = 0; i<env.entities.size() ; i++){	
    		distance = e.location.distanceTo(env.entities.get(i).location);//distance between Cell and Food
    		if(distance<minDistance){
				minDistance = distance;
				//System.out.println("minDistance"+deltaTime);
				
    		if(env.entities.get(i) instanceof Food ){
    			minFood = (Food) env.entities.get(i);
	     	   	}
    		}
    		
    		//else continue;
    	}
    	
    	
    	
    	while(deltaTime>0){
    	e.dir.x =  minFood.location.x - e.location.x;   
 	   	e.dir.y = minFood.location.y  - e.location.y; 
 	   	e.dir = e.dir.normalize();
 	   	
 	   e.location.x += e.dir.x;
	   e.location.y += e.dir.y;
	   

	   if(e.location.distanceTo(minFood.location) < 50){
		   
		   e.mass+= minFood.mass;
		   e.speed+=minFood.speed;
		   
		 
		   env.entities.remove(minFood);
		   env.foodList.remove(minFood);
		   
		   
		 //  System.out.println("Size is" + env.entities.size());
		   //System.out.println("Size Food is" + env.foodList.size());
		  
	   }
	   
	   deltaTime--;}
	   
	}
    	
    }
    


	     	   	
	     	   	
	     	    