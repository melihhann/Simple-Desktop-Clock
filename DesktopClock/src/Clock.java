import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Clock extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Components
	JTextField timeField;
	JTextField calendarField;
	JTextField todoField;
	Executor executor = new Executor();
	
	public Clock() {
		
		super("Desktop Clock Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,185);
		setVisible(true);
		setResizable(false);   
		setLocationRelativeTo(null);		  
		setAlwaysOnTop(true);  
		setLocation(3400, 350);
		  
		
		//initialize the panel
		executor.panel = new JPanel();
		executor.panel.setLayout(new FlowLayout());
		executor.panel.setBackground(Color.DARK_GRAY);  
		
		
		todoField = new JTextField(35) {
			@Override
			public void setBorder(Border border) {
				// No!
			}
		};
		
		todoField.setEditable(false);
		todoField.setFont(new Font("Arial", Font.BOLD, 20));
		todoField.setBackground(Color.WHITE);
		//Mouse Listener For timeField
				todoField.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						
						if(todoField.getBackground() == Color.WHITE) {
							todoField.setBackground(Color.BLACK);
						} else {
							todoField.setBackground(Color.WHITE);
						}
					}
					
				});
		
		//initialize the textField for Clock
		timeField = new JTextField(20) {
			@Override
			public void setBorder(Border border) {
				// No!
			}
		};
		timeField.setEditable(false);// no more messing with the time
		timeField.setFont(new Font("Arial", Font.BOLD, 48));
		timeField.setBackground(Color.WHITE); 
		//Mouse Listener For timeField
		timeField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				  
				if(timeField.getBackground() == Color.WHITE) {
					timeField.setBackground(Color.BLACK);
				} else {
					timeField.setBackground(Color.WHITE);
				}
			}
			
		});
		
		//initialize the textField for Calendar
		calendarField = new JTextField(20) {
			@Override
			public void setBorder(Border border) {
				// No!
			}
		};		
		calendarField.setEditable(false);
		calendarField.setFont(new Font("Arial", Font.BOLD, 48));
		calendarField.setBackground(Color.WHITE);
		//Mouse Listener For calendarField
		calendarField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				  if(calendarField.getBackground() == Color.WHITE) {
					  calendarField.setBackground(Color.BLACK);
				  } else {
					  calendarField.setBackground(Color.WHITE);
				  }
			}
			
		});
		
	
		
		//Mouse Listener For JPanel
		executor.panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//TODO
			}
			
		});
		todoField.setHorizontalAlignment(JTextField.CENTER);
		timeField.setHorizontalAlignment(JTextField.CENTER);
		calendarField.setHorizontalAlignment(JTextField.CENTER);
		executor.panel.add(timeField);
		executor.panel.add(calendarField);	
		executor.panel.add(todoField);
		add(executor.panel);
		
		Timer timer = new Timer(1000, new Listener());
		timer.start();
		
	}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			Calendar currentTime = Calendar.getInstance();		
			
			int hour = currentTime.get(Calendar.HOUR_OF_DAY);
			int minute = currentTime.get(Calendar.MINUTE);
			int second = currentTime.get(Calendar.SECOND);
			int day = currentTime.get(Calendar.DAY_OF_MONTH);
			int month = currentTime.get(Calendar.MONTH);
			int year = currentTime.get(Calendar.YEAR);
			month = month+1;// ilk ay = 0 oldugu icin
			
			
			todoField.setText("DON'T PANIC");   
			
			    
			if(hour < 10) {
				timeField.setText("0" + hour + ":"+  minute);
			}else {
				timeField.setText(hour + ":"+  minute);
			}
			
			if(minute < 10) {   
				timeField.setText(hour + ":"+ "0" + minute);
			}else {
				timeField.setText(hour + ":" + minute);
			}
			
			if(month < 10) {  
				calendarField.setText(day+ "/0" + month + "/"+ year);
			} else {
				calendarField.setText(day+ "/" + month + "/"+ year);
			}	
			
		}
	}
	
}
