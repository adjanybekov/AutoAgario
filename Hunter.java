
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Hunter extends CellDecorator {

    /**
     * Default constructor
     */
    public Hunter(Cell cell) {
    	super(cell);
    	this.cell = cell;
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
    	g2d.setColor(color.RED);
    	//g2d.drawOval((int)cell.location.x, (int) cell.location.y,(int)cell.mass ,(int)cell.mass);
    	g2d.drawOval((int)(cell.location.x-cell.mass/2), (int) (cell.location.y-cell.mass/2),(int)cell.mass*2 ,(int)cell.mass*2);
    	g2d.setColor(color.DARK_GRAY);
    	g2d.drawString(this.name, (int)this.location.x, (int) this.location.y );
    }


}