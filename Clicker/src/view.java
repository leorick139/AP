import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view {

	/**
	 * Create The Variables
	 */
	private JFrame frame;
	private JLabel label;
	private JButton btnClick;
	private JButton btnReset;
	private Updates up;
	/**
	 * Booter
	 */
	public static void main(String[] args) {
		/*
		 * It creates a try catch
		 * In the try section we check if the window itself would invoke an error
		 * if it does that error will be printed in the console
		 * Otherwise the code keeps running
		 * */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view window = new view();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor
	 */
	public view() {
		initialize();// Initialize the frame
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		up= new Updates();
		/*
		 * Creates a JFrame Window and sets it size and position on screen when oppened
		 * The windows close operation is also set to close on exit.
		 * */
		frame = new JFrame();
		frame.setBounds(100, 100, 207, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		/*
		 * Creates a JLabel with the starting value int the cnt
		 * Then places the label in the middle of the Window.
		 * */
		label = new JLabel(""+ up.CNTget());
		label.setHorizontalAlignment(SwingConstants.CENTER);		
		frame.getContentPane().add(label, BorderLayout.CENTER);
		
		/*
		 * Creates A J Button named Reset
		 * It has an actionListner that sets the CNT to 0
		 * And rewrites the screen
		 * Then the button is placed onto the Left hand side of the screen.
		 * */
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				up.CNTset(0);
				rewrite();
			}
		});
		frame.getContentPane().add(btnReset, BorderLayout.WEST);
		
		/*
		 * Creates A J Button named Click
		 * It has an actionListner that increase the CNT by 1
		 * And rewrites the screen
		 * Then the button is placed onto the Right hand side of the screen.
		 * */
		JButton btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up.CNTup();
				rewrite();
			}
		});
		frame.getContentPane().add(btnClick, BorderLayout.EAST);

	
	}
	/**
	 * Rewrites the contents of the frame.
	 */
	protected void rewrite() {
		label.setText(""+ up.CNTget());//sets the label to show the current value of CNT
	}

}
