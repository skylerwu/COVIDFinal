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
import javax.swing.JButton;
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
			setBounds(100, 100, 685, 459);
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(16, 11, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			JLabel lblNewLabel = new JLabel("Picture of State");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(30, 88, 263, 160);
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("State Name");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(209, 21, 275, 55);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblCases = new JLabel("# Cases: ");
			lblCases.setBounds(305, 88, 112, 16);
			getContentPane().add(lblCases);
			
			JLabel lblNewLabel_2 = new JLabel("# Dead:");
			lblNewLabel_2.setBounds(414, 88, 96, 16);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("# Recovered:");
			lblNewLabel_3.setBounds(522, 88, 138, 16);
			getContentPane().add(lblNewLabel_3);
			
			JLabel lblOfPop = new JLabel("% of Pop > 80:");
			lblOfPop.setBounds(305, 129, 126, 16);
			getContentPane().add(lblOfPop);
			
			JLabel lblOfPop_1 = new JLabel("% of Pop 40 - 60:");
			lblOfPop_1.setBounds(305, 167, 138, 16);
			getContentPane().add(lblOfPop_1);
			
			JLabel lblOfPop_2 = new JLabel("% of Pop < 40:");
			lblOfPop_2.setBounds(305, 207, 115, 16);
			getContentPane().add(lblOfPop_2);
			
			JLabel lblNewLabel_4 = new JLabel("Population Density:");
			lblNewLabel_4.setBounds(305, 250, 163, 16);
			getContentPane().add(lblNewLabel_4);
			
			JTextArea txtrMajorEducationalInstitutions = new JTextArea();
			txtrMajorEducationalInstitutions.setText("Major Educational Institutions Closed: ");
			txtrMajorEducationalInstitutions.setBounds(37, 278, 623, 39);
			getContentPane().add(txtrMajorEducationalInstitutions);
			
			JTextArea txtrCorporationsAtRisk = new JTextArea();
			txtrCorporationsAtRisk.setText("Corporations At Risk:");
			txtrCorporationsAtRisk.setBounds(37, 329, 624, 39);
			getContentPane().add(txtrCorporationsAtRisk);
			
			JTextArea txtrPreventionPolicies = new JTextArea();
			txtrPreventionPolicies.setText("Prevention Policies:");
			txtrPreventionPolicies.setBounds(37, 380, 623, 43);
			getContentPane().add(txtrPreventionPolicies);
			
		}
}
