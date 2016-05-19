
import java.awt.Graphics2D;
import java.util.*;

public abstract class CellDecorator extends Cell {

   
	Cell cell;
    public CellDecorator(Cell cell) {
    	this.cell = cell;
	
    }
    
    public void draw(Graphics2D g2d) {
    	
    	
    }

}