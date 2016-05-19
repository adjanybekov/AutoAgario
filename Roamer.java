
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Roamer extends CellDecorator    {

	//Environment env ;
    public   Roamer(Cell cell) {
    	
    	super(cell);
    	this.cell = cell;
    	this.mass = (double) cell.mass;//(Math.random() * (40-10))+20;
    	this.location.x =  cell.location.x;//(Math.random() * (1000-210))+210;
    	this.location.y = cell.location.y;//(double) (Math.random() * (800-200))+200;
    	this.speed = cell.speed;//1.8;
    	this.dir = cell.dir;//new Vector(12.0, 13.0);
    	this.name = cell.name;
    	
    }
    public  Cell decoratedCell(){
    	
    	return null;
    }
    
  

    public void draw(Graphics2D g2d) {
    	//cell.radius+=20;
    	//System.out.println("I am Here++++++++++++++++++++++++++++++++++++++++++");
    	g2d.setColor(color.blue);
    	g2d.drawOval((int)this.location.x, (int) this.location.y,(int)this.mass/2 ,(int)this.mass/2);
    	g2d.setColor(color.red);
    	int width  = (int)this.mass/2;
    	g2d.drawOval((int)((this.location.x -width*Math.sqrt(2)/3)) , (int) ((this.location.y)-width*Math.sqrt(2)/3),(int)2*width,(int)2*width);
    
    	
    	
    	
    	g2d.setColor(color.DARK_GRAY);
    	 g2d.drawString(this.name, (int)this.location.x, (int) this.location.y );
    	//g2d.fillOval(x, y, width, height);
    	//g2d.drawOval((int)cell.location.x, (int) cell.location.y,(int)cell.mass+10 ,(int)cell.mass+10);

    }

}