import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
 
public class Robot1{
 

 
 
    public static void main(String[] args) throws AWTException,IOException {
 
    
 
    Robot robot = new Robot();
    JFrame mainj = new JFrame();
    JToggleButton buttonwhisper = new JToggleButton("Whisper (Page Down)");
    JToggleButton buttonshout = new JToggleButton("Shout (Page Up)");

    mainj.setSize(600, 300);
    mainj.setLayout(new GridLayout(2,1));
    mainj.add(buttonshout);
    mainj.add(buttonwhisper);
    mainj.setVisible(true);
    mainj.setAlwaysOnTop(true);
    buttonwhisper.setVisible(true);
    buttonshout.setVisible(true);
    
    buttonshout.addItemListener(new ItemListener() {
    	public void itemStateChanged(ItemEvent ev) {
    	      if(ev.getStateChange()==ItemEvent.SELECTED){
    	    	  robot.keyPress(KeyEvent.VK_PAGE_UP);
    	        } else if(ev.getStateChange()==ItemEvent.DESELECTED){
    	        	robot.keyRelease(KeyEvent.VK_PAGE_UP);
    	        }
    	}
    });
    
    buttonwhisper.addItemListener(new ItemListener() {
    	public void itemStateChanged(ItemEvent ev) {
  	      if(ev.getStateChange()==ItemEvent.SELECTED){
	    	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        } else if(ev.getStateChange()==ItemEvent.DESELECTED){
	        	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    	        }
    	}
    });
    
    
    
    buttonwhisper.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			
		}
    	
    });
    	
    
    
      //robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
      //robot.delay(1000);
      //robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
      
    
    }
}