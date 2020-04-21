package view;


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

import Control.SearchMain;
import Model.Product.PRODUCT_TYPE;
import View.Generic_UI;

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
			setBounds(100, 100, 1322, 890);
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(36, 16, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			JLabel lblNewLabel_1 = new JLabel("CDC Covid-19 Case Database");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(300, 29, 560, 55);
			getContentPane().add(lblNewLabel_1);
			COVIDPieChartTest chart = new COVIDPieChartTest("Distribution of COVID-19 Cases");

			JLabel lblNewLabel = new JLabel("US Map");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(875, 531, 306, 225);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon("corona.jpg"));
			
			JLabel lblTotalCases = new JLabel("TOTAL CASES:");
			lblTotalCases.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalCases.setBounds(26, 101, 193, 60);
			getContentPane().add(lblTotalCases);
			
			JLabel label = new JLabel("#");
			label.setFont(new Font("Tahoma", Font.PLAIN, 31));
			label.setBounds(216, 104, 38, 55);
			getContentPane().add(label);
			
			JLabel lblTotalRecovered = new JLabel("TOTAL RECOVERED:");
			lblTotalRecovered.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalRecovered.setBounds(414, 100, 269, 60);
			getContentPane().add(lblTotalRecovered);
			
			JLabel label_1 = new JLabel("#");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			label_1.setBounds(684, 104, 38, 55);
			getContentPane().add(label_1);
			
			JLabel lblTotalDeaths = new JLabel("TOTAL DEATHS:");
			lblTotalDeaths.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalDeaths.setBounds(892, 99, 211, 60);
			getContentPane().add(lblTotalDeaths);
			
			JLabel label_2 = new JLabel("#");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
			label_2.setBounds(1112, 104, 38, 55);
			getContentPane().add(label_2);
			
			JPanel panel = new JPanel();

			panel.setBounds(300, 400, 560, 367);

			getContentPane().add(panel);

			
			ChartPanel chPanel = new ChartPanel(chart.getChart());
			panel.add(chPanel);
			chPanel.setPreferredSize(new Dimension(560, 367)); //size according to my window
			chPanel.setMouseWheelEnabled(true);
			
			JLabel lblMostDeaths = new JLabel("Most Deaths By State");
			lblMostDeaths.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblMostDeaths.setBounds(892, 152, 269, 66);
			getContentPane().add(lblMostDeaths);
			
			JLabel label_3 = new JLabel("1.");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3.setBounds(892, 206, 38, 55);
			getContentPane().add(label_3);
			
			JLabel label_3_1 = new JLabel("2.");
			label_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_1.setBounds(892, 260, 38, 55);
			getContentPane().add(label_3_1);
			
			JLabel label_3_2 = new JLabel("3.");
			label_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_2.setBounds(892, 320, 38, 55);
			getContentPane().add(label_3_2);
			
			JLabel label_3_3 = new JLabel("4.");
			label_3_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_3.setBounds(892, 372, 38, 55);
			getContentPane().add(label_3_3);
			
			JLabel label_3_4 = new JLabel("5.");
			label_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_4.setBounds(892, 430, 38, 55);
			getContentPane().add(label_3_4);
			
			JLabel lblNewLabel_2 = new JLabel("State");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2.setBounds(931, 223, 69, 20);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("State");
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_1.setBounds(931, 277, 69, 20);
			getContentPane().add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2_2 = new JLabel("State");
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_2.setBounds(931, 337, 69, 20);
			getContentPane().add(lblNewLabel_2_2);
			
			JLabel lblNewLabel_2_3 = new JLabel("State");
			lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_3.setBounds(931, 393, 69, 20);
			getContentPane().add(lblNewLabel_2_3);
			
			JLabel lblNewLabel_2_4 = new JLabel("State");
			lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_4.setBounds(931, 451, 69, 20);
			getContentPane().add(lblNewLabel_2_4);
			
			JLabel lblMostCasesBy = new JLabel("Most Cases By State");
			lblMostCasesBy.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
			label_3_3_1.setBounds(26, 372, 38, 55);
			getContentPane().add(label_3_3_1);
			
			JLabel label_3_4_1 = new JLabel("5.");
			label_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			label_3_4_1.setBounds(26, 430, 38, 55);
			getContentPane().add(label_3_4_1);
			
			JLabel lblNewLabel_2_5 = new JLabel("State");
			lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_5.setBounds(55, 223, 69, 20);
			getContentPane().add(lblNewLabel_2_5);
			
			JLabel lblNewLabel_2_6 = new JLabel("State");
			lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_6.setBounds(55, 281, 69, 20);
			getContentPane().add(lblNewLabel_2_6);
			
			JLabel lblNewLabel_2_7 = new JLabel("State");
			lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_7.setBounds(55, 337, 69, 20);
			getContentPane().add(lblNewLabel_2_7);
			
			JLabel lblNewLabel_2_8 = new JLabel("State");
			lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_8.setBounds(55, 389, 69, 20);
			getContentPane().add(lblNewLabel_2_8);
			
			JLabel lblNewLabel_2_9 = new JLabel("State");
			lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel_2_9.setBounds(55, 447, 69, 20);
			getContentPane().add(lblNewLabel_2_9);
			
			JTextField txtSearchForA = new JTextField();
			txtSearchForA.setForeground(new Color(34, 139, 34));
			txtSearchForA.setFont(new Font("Big Caslon", Font.PLAIN, 16));
			txtSearchForA.setText("Search for a State:");
			txtSearchForA.setBounds(329, 22, 266, 39);
			getContentPane().add(txtSearchForA);
			txtSearchForA.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Big Caslon", Font.BOLD, 16));
			btnSearch.setForeground(new Color(34, 139, 34));
			btnSearch.setBounds(753, 22, 117, 39);
			getContentPane().add(btnSearch);

			
		}
}

