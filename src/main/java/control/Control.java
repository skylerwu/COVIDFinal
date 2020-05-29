package control;
import java.util.*;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import java.util.Iterator;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class Control {
	private static ArrayList<State> allStates = new ArrayList<>();
	
	public static void fillAllStates()
	{
		
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. ",
                    e);
        }
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        	.withCredentials(credentialsProvider)
            .withRegion("us-west-1")
            .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Covid19Data");

        ScanSpec scanSpec = new ScanSpec();


                ItemCollection<ScanOutcome> items = table.scan(scanSpec);

                Iterator<Item> iter = items.iterator();
                while (iter.hasNext()) {
                    Item item = iter.next();

                    //create the String distancingMeasures
                    //create State object and add to ArrayList
                    String atHome = "Stay at Home Order: " + insertAttribute(item, "Stay at Home Order");
                    String largeGatherings = "Ban on Large Gatherings: " + insertAttribute(item, "Large Gatherings Ban");
                    String businessClosures = "Non-Essential Business Closures: " + insertAttribute(item, "Non-Essential Business Closures");
                    String distancingMeasures = atHome + " | " + largeGatherings + " | " + businessClosures;
                    String totalOver65 = removeCommas(insertAttribute(item, "Adults Age 65 and Older__Total number, adults age 65 and older"));
                    String percentOver65 = removePercent(insertAttribute(item, "Adults Age 65 and Older__Older adults, as a share of all at-risk adults"));

                    allStates.add(
                    		new State(
                    				insertAttribute(item, "State"),
                    				insertAttribute(item, "Cases"),
                    				insertAttribute(item, "Deaths"),
                    				distancingMeasures,
                    				totalOver65,
                    				percentOver65)
                    		);
                    System.out.println(allStates.get(allStates.size()-1).toString());

                //System.err.println("Unable to scan the table:");
            }
        
	
	}

	private static String insertAttribute (Item item, String attribute) {
		if (item.isPresent(attribute)) {
			return item.getString(attribute);
		}
		else {
			return "0";
		}
	}
	
	
	
	//must have called fillAllStates()
	public static State getStateObject(String stateName)
	{
		int i = 0;
		while(i<allStates.size())
		{
			if(allStates.get(i).getName().equalsIgnoreCase(stateName))
			{
				return allStates.get(i);
			}
			i++;
		}
		
		return null;
	}
	
	enum Criteria{TOTALCASES,TOTALDEATHS,TOTALOVER65,PERCENTOVER65}
	
	public static void sortAllStates(Criteria crit)
	{
		switch(crit) {
		case TOTALCASES:
			{
				//insert sorting code here.
				break;
			}
		case TOTALDEATHS:
			{
				//insert sorting code here.
				break;
			}
		case TOTALOVER65:
			{
				//insert sorting code here.
				break;
			}
		case PERCENTOVER65:
			{
				//insert sorting code here.
				break;
			}
		default:
			{
				//insert default option here.	
			}
		
		}
			
	}
	
	
	
	
	public static String removePercent(String input)
	{
		return input.replace("%", "");
	}
	
	public static String removeCommas(String input)
	{
		return input.replace(",", "");
	}
	
	public static void main(String[] args)
	{
		fillAllStates();
	}
	
	
	
}
