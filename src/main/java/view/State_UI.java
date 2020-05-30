package view;


import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class State_UI extends JFrame {
	int i = 0;
	JLabel lblNewLabel_1;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	JTextArea txtrPreventionPolicies;
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						State_UI frame = new State_UI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public State_UI() {
			getContentPane().setBackground(new Color(175, 238, 238));
			getContentPane().setLayout(null);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1006, 838);
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(37, 30, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			lblNewLabel_1 = new JLabel("State Name");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(349, 22, 275, 55);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblCases = new JLabel("# Cases: ");
			lblCases.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblCases.setBounds(137, 97, 139, 43);
			getContentPane().add(lblCases);
			
			JLabel lblNewLabel_2 = new JLabel("# Dead:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel_2.setBounds(553, 93, 126, 55);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblOfPop = new JLabel("Total People Over 65:");
			lblOfPop.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblOfPop.setBounds(137, 194, 327, 43);
			getContentPane().add(lblOfPop);
			
			JLabel lblOfPop_2 = new JLabel("% of Population Older Adults:");
			lblOfPop_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblOfPop_2.setBounds(545, 194, 354, 43);
			getContentPane().add(lblOfPop_2);
			
			txtrPreventionPolicies = new JTextArea();
			txtrPreventionPolicies.setFont(new Font("Tahoma", Font.PLAIN, 26));
			txtrPreventionPolicies.setText("Social Distancing Measures:");
			txtrPreventionPolicies.setBounds(31, 357, 889, 384);
			txtrPreventionPolicies.setWrapStyleWord(true);
			txtrPreventionPolicies.setLineWrap(true);
			getContentPane().add(txtrPreventionPolicies);
			
			label = new JLabel("#");
			label.setFont(new Font("Tahoma", Font.PLAIN, 30));
			label.setBounds(266, 101, 139, 34);
			getContentPane().add(label);
			
			label_1 = new JLabel("#");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			label_1.setBounds(683, 103, 139, 34);
			getContentPane().add(label_1);
			
			label_2 = new JLabel("#");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			label_2.setBounds(222, 253, 139, 34);
			getContentPane().add(label_2);
			
			label_3 = new JLabel("#");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
			label_3.setBounds(683, 253, 139, 34);
			getContentPane().add(label_3);
			
		}
}
