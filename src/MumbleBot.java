import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
 
public class MumbleBot {
	private static Robot robot;

	public static void main(String[] args) throws AWTException, IOException {
		robot = new Robot();

		JFrame mainj                = new JFrame();
		JToggleButton button_local  = new JToggleButton("Local (Page Down)");
		JToggleButton button_upward = new JToggleButton("Upward (Page Up)");
		JToggleButton button_fleet  = new JToggleButton("Fleet (*)");
	
		mainj.setSize(600, 300);
		mainj.setLayout(new GridLayout(3,1));
		mainj.add(button_local);
		mainj.add(button_upward);
		mainj.add(button_fleet);
		mainj.setVisible(true);
		mainj.setAlwaysOnTop(true);
		button_local.setVisible(true);
		button_upward.setVisible(true);
		button_fleet.setVisible(true);

		mainj.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		button_local.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				toggleKey(ev, KeyEvent.VK_PAGE_DOWN);
			}
		});

		button_upward.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				toggleKey(ev, KeyEvent.VK_PAGE_UP);
			}
		});

		button_fleet.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				toggleKey(ev, KeyEvent.VK_MULTIPLY);
			}
		});
	}

	private static void toggleKey(ItemEvent ev, int target_key) {
		int state = ev.getStateChange();

		if (state == ItemEvent.SELECTED){
			robot.keyPress(target_key);
		} else if (state == ItemEvent.DESELECTED){
			robot.keyRelease(target_key);
		}
	}
}
