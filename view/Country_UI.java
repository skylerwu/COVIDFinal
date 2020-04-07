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
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
			setBounds(100, 100, 961, 730);
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(16, 11, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			JLabel lblNewLabel_1 = new JLabel("CDC Covid-19 Case Database");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(208, 30, 560, 55);
			getContentPane().add(lblNewLabel_1);
			
			JPanel panel = new JPanel();
			panel.setBounds(208, 335, 560, 367);
			getContentPane().add(panel);
			COVIDPieChartTest chart = new COVIDPieChartTest("Distribution of COVID-19 Cases");
			ChartPanel chPanel = new ChartPanel(chart.getChart()); //creating the chart panel, which extends JPanel
			chPanel.setPreferredSize(new Dimension(560, 367)); //size according to my window
			chPanel.setMouseWheelEnabled(true);
			panel.add(chPanel); //add the chart viewer to the JPanel


			JLabel lblNewLabel = new JLabel("US Map");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(262, 87, 450, 236);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon("corona.jpg"));
			
		}
}

