
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.JPanel;
import javax.xml.parsers.FactoryConfigurationError;
/**
 * 
 */
public class Display extends JPanel {
	
    Environment env;
    
    int i;
    
    Random random;
    private Image logo;
    private ArrayList<FoodFactory> facList;

	private int foodCount;
    
    public  Display(Environment environment) {
        this.env  = environment;
        env.disp();
        env.StepAll(20);
        //cellGenerator();
    }

    @Override
    public Dimension getPreferredSize() {
       
        setBackground(Color.WHITE);
        return  new Dimension(env.windowWidth, env.windowHeight);//x = 1000 y =800
    }


    
    
    
    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        
       int n= 0;
       
    	   for(n = 8*30; n < this.env.windowWidth ;n +=30){
    		   graphics2D.setPaint(Color.LIGHT_GRAY);
    		   graphics2D.drawLine(n, 0, n, this.env.windowHeight);}
    	   for(n = 30; n < this.env.windowHeight ;n +=30){
    		   graphics2D.setPaint(Color.LIGHT_GRAY);
    		   graphics2D.drawLine(8*30, n ,this.env.windowWidth,n);}
    	   
    	   graphics2D.setPaint(Color.LIGHT_GRAY);
		   graphics2D.drawLine(0, 540,7*30,540);
       
		   
		   
		   
       for(int i = 0; i < env.entities.size(); i++)
       {
    	   env.entities.get(i).draw(graphics2D); // I redraw All of them ne By One 
    	   
    	  // System.out.println("I am Here" + env.entities.size());
       }
       
       
       logo = Toolkit.getDefaultToolkit().getImage("logo/Agario.png");
       graphics2D.drawImage(logo,0,600,200,200,null);
       graphics2D.drawString("---------  -----  -----  ----  ---  -  --", 5 ,60);
       
        // TODO implement here
        //return null;
        graphics2D.setPaint(Color.RED);
        graphics2D.drawString("Step : "+this.env.NumberOfSteps,5,20);// + this.a.g, 5, 20); // a may be steps or step all g may be 
        graphics2D.setPaint(Color.BLACK);
        int CellCount = 0;
        for(int i =0 ;i < env.entities.size(); i++){
        	if(env.entities.get(i) instanceof Cell)
        		CellCount++;
        		
        }
        graphics2D.drawString("Cells : "+ CellCount,170, 20);
        graphics2D.setPaint(Color.MAGENTA);
        graphics2D.drawString("               LeaderBoard", 5, 40);
        graphics2D.setPaint(Color.BLUE);
        //graphics2D.
        graphics2D.drawString("  Name   Mass  Spd   Fd  C  St", 5, 80);
        graphics2D.setPaint(Color.BLACK);
     //   graphics2D.drawString("---------  -----  -----  " + "--", 5, 100);
        //
        String str = new String();
        n = 120;
        
        
        for(Entity cell: env.entities){
        	if(cell instanceof Cell){
        		//cell =  cell;
        	str = String.format(" %4.6s %5.1f  %5.1f %6.7s",((Cell)cell).name , cell.mass, cell.speed, cell.stepStrategy.getName());
             graphics2D.drawString((String) str, 5, n);
             n+=20;}
        	
        }
        graphics2D.drawString("---------  -----  -----  ----  ---  -  --", 5, n);
        
        
        
    }

}