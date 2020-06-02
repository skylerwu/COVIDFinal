package view;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import control.Control;
import control.Control.Criteria;
import control.State;
 
public class COVIDPieChartTotalCases extends ApplicationFrame {
	
	private static JFreeChart chart;
   
   public COVIDPieChartTotalCases( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   //Data is completely made up. DO NOT ACTUALLY USE!
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      for(State location: Control.allStates)
      {
    	  dataset.setValue(location.getStateName(), Double.parseDouble(location.getTotalCases()));
      }
      
      /*dataset.setValue( "New York" , 40);  
      dataset.setValue( "California" , 20);   
      dataset.setValue( "Washington" , 20);    
      dataset.setValue( "Other States" , 10);*/  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "COVID-19 Case Distribution",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   
   public static JFreeChart getChart( )
   {
	   return chart;
   }

   public static void main( String[ ] args ) {
	   Control.fillAllStates();
	   Control.sortAllStates(Criteria.TOTALCASES);
	   COVIDPieChartTotalCases demo = new COVIDPieChartTotalCases( "Distribution of COVID-19 Cases" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
