import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Executor extends JPanel{
	
	JPanel panel;
	
	public static void main(String[] args) {
		new Clock();
	}
	
	public Executor() {
		panel = new JPanel();
	}
}
