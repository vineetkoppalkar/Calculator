/*
 *  Simple Calculator
 *  Vineet Koppalkar
 *  
 *  This is a simple calculator app that can perform addition, subtraction, multiplication,
 *  division and factorial. This is created using Java Swing.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator extends JFrame {
	
	private final int WIDTH = 300;
	private final int HEIGHT = 450;
	
	static Point compCoords;
	
	public Calculator() {
		super();
		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setTitle("Calculator");
		
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		
		//Close and Minimize button Panel
		JPanel windowButtons = new JPanel();
		windowButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		windowButtons.setBackground(new Color(40, 40, 40));
		
		compCoords = null;
		windowButtons.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				
			}

			public void mousePressed(MouseEvent e) {
				compCoords = e.getPoint();
			}

			public void mouseReleased(MouseEvent e) {
				compCoords = null;
			}
			
			public void mouseEntered(MouseEvent e) {
				
			}
			
			public void mouseExited(MouseEvent e) {
				
			}
		});
		windowButtons.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
			}

			public void mouseMoved(MouseEvent e) {

			}
		});
		
		
		//Close Button
		JButton close = new JButton("X");
		close.setBackground(new Color(65, 65, 65));
		close.setForeground(Color.WHITE);
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setFocusPainted(false);
		//close.setContentAreaFilled(false);

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//Minimize Button
		JButton minimize = new JButton("—");
		minimize.setBackground(new Color(65, 65, 65));
		minimize.setForeground(Color.WHITE);
		minimize.setOpaque(true);
		minimize.setBorderPainted(false);
		minimize.setFocusPainted(false);
		//minimize.setContentAreaFilled(false);
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		
		windowButtons.add(minimize);
		windowButtons.add(close);
		northPanel.add(windowButtons);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(new Color(65, 65, 65));
		outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel outputArea = new JLabel("0");
		outputArea.setFont(new Font("Calibri", Font.BOLD, 30));
		outputArea.setForeground(Color.WHITE);
		
		outputPanel.add(outputArea);
		northPanel.add(outputPanel);

		add(northPanel, BorderLayout.NORTH);		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 4));
		centerPanel.setBackground(new Color(40, 40, 40));
		
		JButton add = new JButton("+");
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Calibri", Font.BOLD, 20));
		add.setFocusPainted(false);
		add.setContentAreaFilled(false);
		
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				outputArea.setText(output + " + ");
				
			}
			
		});		
		
		JButton substract = new JButton("-");
		substract.setForeground(Color.WHITE);
		substract.setFont(new Font("Calibri", Font.BOLD, 20));
		substract.setFocusPainted(false);
		substract.setContentAreaFilled(false);
		
		substract.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				outputArea.setText(output + " - ");
				
			}
			
		});
		
		JButton multiply = new JButton("x");
		multiply.setForeground(Color.WHITE);
		multiply.setFont(new Font("Calibri", Font.BOLD, 20));
		multiply.setFocusPainted(false);
		multiply.setContentAreaFilled(false);
		
		multiply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				outputArea.setText(output + " * ");
				
			}
			
		});
		
		JButton divide = new JButton("/");
		divide.setForeground(Color.WHITE);
		divide.setFont(new Font("Calibri", Font.BOLD, 20));
		divide.setFocusPainted(false);
		divide.setContentAreaFilled(false);
		
		divide.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				outputArea.setText(output + " / ");
				
			}
			
		});
		
		centerPanel.add(add);
		centerPanel.add(substract);
		centerPanel.add(multiply);
		centerPanel.add(divide);
		
		JButton zero = new JButton("0");
		zero.setForeground(Color.WHITE);
		zero.setFont(new Font("Calibri", Font.BOLD, 20));
		zero.setFocusPainted(false);
		zero.setContentAreaFilled(false);
		
		zero.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(zero.getText());
				} else {
					outputArea.setText(outputArea.getText() + zero.getText());
				}
				
			}	
			
		});
		
		JButton one = new JButton("1");
		one.setForeground(Color.WHITE);
		one.setFont(new Font("Calibri", Font.BOLD, 20));
		one.setFocusPainted(false);
		one.setContentAreaFilled(false);
		
		one.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(one.getText());
				} else {
					outputArea.setText(outputArea.getText() + one.getText());
				}
				
			}
			
		});
		
		JButton two = new JButton("2");
		two.setForeground(Color.WHITE);
		two.setFont(new Font("Calibri", Font.BOLD, 20));
		two.setFocusPainted(false);
		two.setContentAreaFilled(false);
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(two.getText());
				} else {
					outputArea.setText(outputArea.getText() + two.getText());
				}
				
			}				
		});		
		
		JButton three = new JButton("3");
		three.setForeground(Color.WHITE);
		three.setFont(new Font("Calibri", Font.BOLD, 20));
		three.setFocusPainted(false);
		three.setContentAreaFilled(false);
		
		three.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(three.getText());
				} else {
					outputArea.setText(outputArea.getText() + three.getText());
				}
				
			}	
			
		});
				
		JButton four = new JButton("4");
		four.setForeground(Color.WHITE);
		four.setFont(new Font("Calibri", Font.BOLD, 20));
		four.setFocusPainted(false);
		four.setContentAreaFilled(false);
		
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(four.getText());
				} else {
					outputArea.setText(outputArea.getText() + four.getText());
				}				
			}				
		});
		
		JButton five = new JButton("5");
		five.setForeground(Color.WHITE);
		five.setFont(new Font("Calibri", Font.BOLD, 20));
		five.setFocusPainted(false);
		five.setContentAreaFilled(false);
		
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(five.getText());
				} else {
					outputArea.setText(outputArea.getText() + five.getText());
				}				
			}				
		});
		
		JButton six = new JButton("6");
		six.setForeground(Color.WHITE);
		six.setFont(new Font("Calibri", Font.BOLD, 20));
		six.setFocusPainted(false);
		six.setContentAreaFilled(false);
		
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(six.getText());
				} else {
					outputArea.setText(outputArea.getText() + six.getText());
				}				
			}				
		});
		
		JButton seven = new JButton("7");
		seven.setForeground(Color.WHITE);
		seven.setFont(new Font("Calibri", Font.BOLD, 20));
		seven.setFocusPainted(false);
		seven.setContentAreaFilled(false);
		
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(seven.getText());
				} else {
					outputArea.setText(outputArea.getText() + seven.getText());
				}	
			}			
		});
		
		JButton eight = new JButton("8");
		eight.setForeground(Color.WHITE);
		eight.setFont(new Font("Calibri", Font.BOLD, 20));
		eight.setFocusPainted(false);
		eight.setContentAreaFilled(false);
		
		eight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(eight.getText());
				} else {
					outputArea.setText(outputArea.getText() + eight.getText());
				}				
			}			
		});
		
		JButton nine = new JButton("9");
		nine.setForeground(Color.WHITE);
		nine.setFont(new Font("Calibri", Font.BOLD, 20));
		nine.setFocusPainted(false);
		nine.setContentAreaFilled(false);
		
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(nine.getText());
				} else {
					outputArea.setText(outputArea.getText() + nine.getText());
				}				
			}			
		});
		
		JButton dot = new JButton(".");
		dot.setForeground(Color.WHITE);
		dot.setFont(new Font("Calibri", Font.BOLD, 20));
		dot.setFocusPainted(false);
		dot.setContentAreaFilled(false);
		
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.equals("0")) {
					outputArea.setText(dot.getText());
				} else {
					outputArea.setText(outputArea.getText() + dot.getText());
				}				
			}			
		});
		
		JButton delete = new JButton("←");
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Calibri", Font.BOLD, 20));
		delete.setFocusPainted(false);
		delete.setContentAreaFilled(false);
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				if(output.charAt(0) == '-') {
					if(output.length() > 2) {
						outputArea.setText(output.substring(0, output.length() - 1));
					} else {
						outputArea.setText("0");
					}
				} else {
					if(output.length() != 1) {
						outputArea.setText(output.substring(0, output.length() - 1));
					} else {						
						outputArea.setText("0");
					}
				}
			}			
		});		
		
		JButton factorial = new JButton("!");
		factorial.setForeground(Color.WHITE);
		factorial.setFont(new Font("Calibri", Font.BOLD, 20));
		factorial.setFocusPainted(false);
		factorial.setContentAreaFilled(false);
		
		factorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = outputArea.getText();
				long input = Long.parseLong(output);
				if(input > 0 && input < 26) {
					String result = Long.toString(factorial(input));
					outputArea.setText(result);
				} else {
					outputArea.setText("ERROR");
				}
			}

			private long factorial(long input) {
				long result = 1;
				while(input > 0) {
					result *= input;
					input--;
				}				
				return result;
			}			
		});		
		
		JButton clear = new JButton("CLR");
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Calibri", Font.BOLD, 20));
		clear.setFocusPainted(false);
		clear.setContentAreaFilled(false);
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputArea.setText("0");
			}			
		});
		
		
		JButton equal = new JButton("=");
		equal.setForeground(Color.WHITE);
		equal.setFont(new Font("Calibri", Font.BOLD, 20));
		equal.setFocusPainted(false);
		equal.setContentAreaFilled(false);
		
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String output = outputArea.getText();
				if(!output.contains("/ 0") && !output.contains("ERROR")) {
					output.replaceAll("\\s","");
					
					ScriptEngineManager scm = new ScriptEngineManager();
					ScriptEngine jsEngine = scm.getEngineByName("JavaScript");
					try {
						outputArea.setText(jsEngine.eval(output).toString());
					} catch (ScriptException se) {
						System.out.println("Error - could not perform calculation");
						se.printStackTrace();
					}			
				} else {
					outputArea.setText("ERROR");
				}			
			}			
		});		
		
		JLabel myName = new JLabel("VK");
		myName.setForeground(Color.WHITE);
		myName.setFont(new Font("Calibri", Font.BOLD, 20));
		myName.setHorizontalAlignment(SwingConstants.CENTER);
		
		centerPanel.add(seven);
		centerPanel.add(eight);
		centerPanel.add(nine);
		centerPanel.add(delete);
		centerPanel.add(four);
		centerPanel.add(five);
		centerPanel.add(six);
		centerPanel.add(clear);

		centerPanel.add(one);
		centerPanel.add(two);
		centerPanel.add(three);
		centerPanel.add(factorial);
		
		centerPanel.add(dot);
		centerPanel.add(zero);
		centerPanel.add(equal);
		centerPanel.add(myName);	
		
		add(centerPanel, BorderLayout.CENTER);		
		
		//Centers window in the screen
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setVisible(true);
	}
}
