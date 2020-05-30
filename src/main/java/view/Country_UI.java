package view;

import control.*;
import control.Control.Criteria;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import org.jfree.ui.RefineryUtilities;

import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.image.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Country_UI extends JFrame {
	int i = 0;
	public JTextField txtSearchForA;
	
	public State ob;
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Country_UI frame = new Country_UI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public Country_UI() {
			getContentPane().setBackground(new Color(175, 238, 238));
			getContentPane().setLayout(null);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1487, 934);
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(36, 16, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			Control.fillAllStates();
			
			JLabel lblNewLabel_1 = new JLabel("CDC Covid-19 Case Database");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(300, 27, 560, 55);
			getContentPane().add(lblNewLabel_1);
			COVIDPieChartTest chart = new COVIDPieChartTest("Distribution of COVID-19 Cases");

			JLabel lblNewLabel = new JLabel("US Map");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(386, 125, 342, 250);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon("corona.jpg"));
			
			JLabel lblTotalCases = new JLabel("TOTAL CASES:");
			lblTotalCases.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalCases.setBounds(26, 101, 193, 60);
			getContentPane().add(lblTotalCases);
			
			JLabel label = new JLabel(/*Double.toString(Control.getTotalCasesUS())*/ "#");
			label.setFont(new Font("Tahoma", Font.PLAIN, 25));
			label.setBounds(216, 104, 211, 55);
			getContentPane().add(label);
			
			JLabel lblTotalDeaths = new JLabel("TOTAL DEATHS:");
			lblTotalDeaths.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalDeaths.setBounds(939, 101, 211, 60);
			getContentPane().add(lblTotalDeaths);
			
			JLabel label_2 = new JLabel(/*Double.toString(Control.getTotalDeathsUS())*/ "#");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			label_2.setBounds(1165, 104, 285, 55);
			getContentPane().add(label_2);
			
			JPanel panel = new JPanel();

			panel.setBounds(300, 400, 560, 367);

			getContentPane().add(panel);

			//test
			ChartPanel chPanel = new ChartPanel(chart.getChart());
			panel.add(chPanel);
			chPanel.setPreferredSize(new Dimension(560, 367)); //size according to my window
			chPanel.setMouseWheelEnabled(true);
			
			JLabel lblMostDeaths = new JLabel("Most Deaths By State");
			lblMostDeaths.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblMostDeaths.setBounds(939, 163, 269, 66);
			getContentPane().add(lblMostDeaths);
			
			JLabel label_3 = new JLabel("1.");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3.setBounds(939, 206, 38, 55);
			getContentPane().add(label_3);
			
			JLabel label_3_1 = new JLabel("2.");
			label_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_1.setBounds(939, 260, 38, 55);
			getContentPane().add(label_3_1);
			
			JLabel label_3_2 = new JLabel("3.");
			label_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_2.setBounds(939, 320, 38, 55);
			getContentPane().add(label_3_2);
			
			JLabel label_3_3 = new JLabel("4.");
			label_3_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_3.setBounds(939, 383, 38, 55);
			getContentPane().add(label_3_3);
			
			JLabel label_3_4 = new JLabel("5.");
			label_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_4.setBounds(939, 444, 38, 55);
			getContentPane().add(label_3_4);
			
			//TOP DEATHS
			Control.sortAllStates(Criteria.TOTALDEATHS);
			//state 1 cases
			JLabel lblNewLabel_2 = new JLabel((Control.allStates.get(0)).getStateName());
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2.setBounds(974, 223, 229, 20);
			getContentPane().add(lblNewLabel_2);
			
			//state 2 cases
			JLabel lblNewLabel_2_1 = new JLabel((Control.allStates.get(1)).getStateName());
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_1.setBounds(974, 277, 211, 20);
			getContentPane().add(lblNewLabel_2_1);
			
			//state 3 cases
			JLabel lblNewLabel_2_2 = new JLabel((Control.allStates.get(2)).getStateName());
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_2.setBounds(974, 337, 229, 20);
			getContentPane().add(lblNewLabel_2_2);
			
			//state 4 cases
			JLabel lblNewLabel_2_3 = new JLabel((Control.allStates.get(3)).getStateName());
			lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_3.setBounds(974, 400, 248, 20);
			getContentPane().add(lblNewLabel_2_3);
			
			//state 5 cases
			JLabel lblNewLabel_2_4 = new JLabel((Control.allStates.get(4)).getStateName());
			lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_4.setBounds(974, 461, 229, 20);
			getContentPane().add(lblNewLabel_2_4);
			
			JLabel lblMostCasesBy = new JLabel("Most Cases By State");
			lblMostCasesBy.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblMostCasesBy.setBounds(26, 163, 269, 66);
			getContentPane().add(lblMostCasesBy);
			
			JLabel label_3_5 = new JLabel("1.");
			label_3_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_5.setBounds(26, 206, 38, 55);
			getContentPane().add(label_3_5);
			
			JLabel label_3_1_1 = new JLabel("2.");
			label_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_1_1.setBounds(26, 260, 38, 55);
			getContentPane().add(label_3_1_1);
			
			JLabel label_3_2_1 = new JLabel("3.");
			label_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_2_1.setBounds(26, 320, 38, 55);
			getContentPane().add(label_3_2_1);
			
			JLabel label_3_3_1 = new JLabel("4.");
			label_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_3_1.setBounds(26, 383, 38, 55);
			getContentPane().add(label_3_3_1);
			
			JLabel label_3_4_1 = new JLabel("5.");
			label_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_4_1.setBounds(26, 444, 38, 55);
			getContentPane().add(label_3_4_1);
			
			//TOP CASES
			Control.sortAllStates(Criteria.TOTALCASES);
			//state 1 deaths
			JLabel lblNewLabel_2_5 = new JLabel((Control.allStates.get(0)).getStateName());
			lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_5.setBounds(55, 223, 240, 20);
			getContentPane().add(lblNewLabel_2_5);
			
			//state 2 deaths
			JLabel lblNewLabel_2_6 = new JLabel((Control.allStates.get(1)).getStateName());
			lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_6.setBounds(55, 281, 199, 20);
			getContentPane().add(lblNewLabel_2_6);
			
			//staet 3 deaths
			JLabel lblNewLabel_2_7 = new JLabel((Control.allStates.get(2)).getStateName());
			lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_7.setBounds(55, 337, 176, 20);
			getContentPane().add(lblNewLabel_2_7);
			
			//state 4 deaths
			JLabel lblNewLabel_2_8 = new JLabel((Control.allStates.get(3)).getStateName());
			lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_8.setBounds(55, 400, 176, 20);
			getContentPane().add(lblNewLabel_2_8);
			
			//state 5 deaths
			JLabel lblNewLabel_2_9 = new JLabel((Control.allStates.get(4)).getStateName());
			lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_9.setBounds(55, 461, 230, 20);
			getContentPane().add(lblNewLabel_2_9);
			
			/*JTextField*/ txtSearchForA = new JTextField();
			txtSearchForA.setForeground(Color.BLACK);
			txtSearchForA.setFont(new Font("Big Caslon", Font.PLAIN, 16));
			txtSearchForA.setText("Search for a State:");
			txtSearchForA.setBounds(903, 33, 266, 39);
			getContentPane().add(txtSearchForA);
			txtSearchForA.setColumns(10);
			
			/*String input = txtSearchForA.getText();
			String actual = (input.substring(0,1)).toUpperCase() + input.substring(1);
			//Control.fillAllStates();
			ob = Control.getStateObject(actual);*/
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//need to add check if search input is in data set 
						/*String input = txtSearchForA.getText();
						String actual = (input.substring(0,1)).toUpperCase() + input.substring(1);
						Control.fillAllStates();
						State ob = Control.getStateObject(actual);
						if(Control.allStates.indexOf(ob)>=0)
						{
							State_UI f = new State_UI();
							//f.lblNewLabel_1.setText(actual);
							f.setVisible(true);
						}
						else
						{
							//add later
						}*/
					setData();
	
				}
			});
			
			btnSearch.setFont(new Font("Big Caslon", Font.BOLD, 16));
			btnSearch.setForeground(Color.BLACK);
			btnSearch.setBounds(1184, 33, 117, 39);
			getContentPane().add(btnSearch);

			
		}
		
		public void setData()
		{
			String input = txtSearchForA.getText();
			String actual = (input.substring(0,1)).toUpperCase() + input.substring(1);
			Control.fillAllStates();
			State ob = Control.getStateObject(actual);
			if(Control.allStates.indexOf(ob)>=0)
			{
				State_UI f = new State_UI();
				f.lblNewLabel_1.setText(actual);
				f.label.setText(ob.getTotalCases());
				f.label_1.setText(ob.getTotalDeaths());
				f.label_2.setText(ob.getTotalOver65());
				f.label_3.setText(ob.getPercentOlderAdults()+ " %");
				f.txtrPreventionPolicies.setText("Social Distancing Measures: " + ob.getDistancingMeasures());
				f.setVisible(true);
			}
			else
			{
				//add later
			}
		}
}

