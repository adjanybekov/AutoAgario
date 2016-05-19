
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class BasicCell extends Cell {

    
    
    
	int CellRadius = 10;
	public ArrayList<String> names ;
	
	
//	String[] list = ["Azat","2","3"];
	

	
    public   BasicCell() {
    	this.name = "Azat";
    	this.location.x = (int) (Math.random() * (1000-210))+210;
    	this.location.y = (double) (Math.random() * (800-200))+200;
    	this.mass =  (double) (Math.random() * (20-10))+10;
    	this.CellRadius = ((int)this.mass)*2;
    	this.radius = this.mass;
    	this.color = new Color((int)(Math.random() * 0x1000000));
    	
    	this.speed = 1.8;
    	this.dir = new Vector(12.0, 13.0);
    }

  
    
    @Override
    public void draw(Graphics2D g2d) {
    	g2d.setColor(this.color);
    	
    	g2d.drawOval((int)this.location.x, (int) this.location.y, (int)this.mass/2,(int) this.mass/2);
    	
        g2d.drawString(""+this.mass, (int)this.location.x, (int) this.location.y + CellRadius);
       // g2d.drawOval((int)this.location.x+(int)this.mass, (int) this.location.y-(int)this.mass, (int)this.mass,(int) this.mass);
        g2d.drawString(this.name, (int)this.location.x, (int) this.location.y );
    }

}