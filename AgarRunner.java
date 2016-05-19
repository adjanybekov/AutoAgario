//package agario1;
import java.util.*;

import javax.swing.JFrame;



public class AgarRunner {

	
    public AgarRunner() {
    	
    }

    /**
     * 
     */
    public static JFrame frame = new JFrame();
    public static Environment env ;
    public static Display ds ;
    public static boolean bool = true;
   // Display disp;// = new Display(this);

    /**
     * @param args String[*] 
     * @return
     */
public static void main(String[] args) {
    	
    	
    	Environment env = new Environment();
    	Display ds =new Display(env);
        frame.add(ds);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        while(true){
        	env.StepAll(1);
        	ds.repaint();
        	
		    try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }
    }

}