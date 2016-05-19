
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Environment {
	ArrayList<Food> foodList;
	
	private ArrayList<FoodFactory> facList;
	public ArrayList<Entity> entities;// new ArrayList<Entity>();
	ArrayList<Cell> cellList;
	// public ArrayList<Cell> REHList;
	 public ArrayList<String> names ;
	 //public static ArrayList<String> namelist;
	
	 
	
    /**
     * Default constructor
     */
	
    public Environment() {
    	
        foodList = new ArrayList<Food>();
        cellList = new ArrayList<Cell>();
        entities = new ArrayList<Entity>();
      //  REHList = new ArrayList<Cell>();
        names = new ArrayList<String>();
        
    }
    
  
    public int windowHeight = 800;
    public int windowWidth= 1000;

   
    public int leftPanelWidth = 900;
    public BufferedImage logo;
    public int NumberOfSteps;
  
    int i;
    private int foodCount;
    Random random;
    
    /**
     * @return
     */
    
    public void disp()
    {
    	facList = new ArrayList<FoodFactory>();
        facList.add(new SugarFactory());
        facList.add(new OrganismFactory());
        

        
        random = new Random();
        foodCount = 500;
        FoodGenerator();
       int tmp;
       
	    	for(int i = 0; i < foodCount; ++i)
	    	{
	    		tmp = random.nextInt(2);
	    		foodList.add(facList.get(tmp).createFood(this));
	    		foodList.add(facList.get(tmp).createFood(this));
	    		entities.add(foodList.get(i));
	    		
	    	}
	    	
	    	
	    	this.cellGenerator();
	    	
    }
    
    
    public void FoodGenerator(){
    		random = new Random();
    		//foodCount = 500;
    		//random = new Random();
    		
    		foodCount = 200;
        	int tmp;
	    	for(int i = 0; i < foodCount; ++i)
	    	{
	    	  tmp = random.nextInt(2);
	    		
	    		foodList.add(facList.get(tmp).createFood(this));
	    		foodList.add(facList.get(tmp).createFood(this));
	    		entities.add(foodList.get(i));
	    		
	    	}
	    	
    }
    
    
    public void cellGenerator(){
    	for(int j = 0;j<10 ; j++){
    		
    		cellList.add(new BasicCell());
    		entities.add(cellList.get(j));
    		cellList.get(j).name = generateName(j);
    		//System.out.println(entities.get(j));
    		
    	}
    }
 
    
    
    
    
    
    public String generateName(int i) {

    	
    	names.add("Azat"); 
    	names.add("Mehmet");
    	names.add("Ali"); 
    	names.add("Veli");
    	names.add("Yusuf"); 
    	names.add("Artun");
    	names.add("Sagyn"); 
    	names.add("Sary");
        return names.get(i);
        
    }

    /**
     * @return
     */
    public StepStrategy generateSugarStepStrategy() {
    	
        
        return new StandStill();
    }

    /**
     * @return
     */
    public StepStrategy generateOrganismStepStrategy() {
        int randOrg = random.nextInt(2);
        if(randOrg==0)
        	return new StandStill();
        else 
        	return new MoveRandom(this);
    	
       // return null;
    }

    public StepStrategy generateCellStepStrategy(Cell cell) {	
    		if(cell instanceof BasicCell){//BasicCell
    			//int randCell = random.nextInt(2);
    			//System.out.println("Hello BasicCell");
    		
         //   if(randCell==0)
            	return new GrabFood(this);
            	
         /*   else 
            	return new GrabFood(this);*/
            	
    			//return new ChaseSmaller(this);
    }
 
    	       /* 
    		
    		
    		else if(cell instanceof Roamer){//Roamer
    			int randCell = random.nextInt(3);
    			//System.out.println("RandCell is "+randCell);
    			//System.out.println("Hello Roamer");
    			   if(randCell==0)
    	            	return new GrabFood(this);
    	           else if(randCell == 1)
    	            	return new StandStill();
    	           else 
    	            	return new ChaseSmaller(this);
    	            	}
    	           
    		else if(cell instanceof Evader){//Roamer
    			int randCell = random.nextInt(5);
    			System.out.println("RandCell is "+randCell);
    			
    			   if(randCell==0)
    	            	return new StandStill();
    	            else if(randCell==1)
    	            	return new GrabFood(this);
    	            else if(randCell == 2)
    	            	return new MoveRandom(this);
    	            else if(randCell == 3)
    	            	return new MoveLinear(this);
    	            else //if(randCell == 4)
    	            	return new AvoidLarger(this);
    			   	
    	            	}
    		
    		else if (cell instanceof Hunter){   // Roamer (cell instanceof Hunter)
    				int randCell = random.nextInt(7);
    				//System.out.println("Hello Hunter");
    				if(randCell==0)
    	            	return new StandStill();
    	            else if(randCell==1)
    	            	return new GrabFood(this);
    	            else if(randCell == 2)
    	            	return new MoveRandom(this);
    	            else if(randCell == 3)
    	            	return new MoveLinear(this);
    	            else if(randCell == 4)
    	            	return new AvoidLarger(this);
    	            else if(randCell == 5)
    	            	return new ChaseSmaller(this);
    	            else //if(randCell == 6)
    	            	return new LoseMass();
    	            	}*/
    		
    		else 
    			return null;
    		}
    		
    		
    	

    
    public Food CreateFood(FoodFactory factory) {
    	
            Food f =  factory.createFood(this);
            return f;
    }

    /**
     * @return
     */
    public Cell CreateCell() {
    	
    	for (int i = 0; i<entities.size(); i++)
    		if(entities.get(i) instanceof Cell)
    			return (Cell) entities.get(i);
    	
    		
    	return null;
    }

  
    
    public void StepAll(double deltaTime) {
    
    	Cell cell;
    	
    	for(int i= 0; i < entities.size(); i++){
    		if (entities.get(i) instanceof Sugar){
    			entities.get(i).stepStrategy = generateSugarStepStrategy(); 
    		}
    		else if (entities.get(i) instanceof Organism){
    			entities.get(i).stepStrategy = generateOrganismStepStrategy() ;
    		}
    		else if (entities.get(i) instanceof Cell){
    			if(entities.get(i).mass < 10000){
    				entities.get(i).stepStrategy = generateCellStepStrategy( CreateCell());
    			}
    			else if(entities.get(i).mass > 180){
    				cell =  new Hunter((Cell)entities.get(i));
    			
    				
    				entities.set(i, cell);
    				entities.get(i).stepStrategy = generateCellStepStrategy(cell); //return Hunter
    				
    			}
    			
    			else if(entities.get(i).mass > 120){
    				cell =  new Evader((Cell)entities.get(i));
    				//REHList.add(cell);
    				entities.set(i, cell);
    				entities.get(i).stepStrategy = generateCellStepStrategy(cell); //return Evader
    			}
    			else if(entities.get(i).mass > 70){
    				cell =  new Roamer((Cell)entities.get(i));
    				//REHList.add((Cell)cell);
    				entities.set(i, cell);
    				//System.out.println("I am Here++++++++++++++++++++++++++++++++++++++++++");
    				entities.get(i).stepStrategy = generateCellStepStrategy(cell); //return Roamer

    			}
    			
    			
    			
    			
    			NumberOfSteps+=1;
    			System.out.println(foodList.size());
    			if(foodList.size() <  100){
    	    		FoodGenerator();
    	    		System.out.println("Here I am In Environmrnt");
    	    	}
    		}
    		
    	}
    	
    	
    	

    	for(int i= 0; i < entities.size(); i++){
    		entities.get(i).step(deltaTime);  	
    		
    	}

    }

}