package control;

import java.util.HashMap;
import java.util.Iterator;

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

public class State {
//INSTANCE VARIABLES
	private String stateName;
	private String totalCases;
	private String casesPerMillion;
	private String totalDeaths;
	private String deathsPerMillion;
	
	//NOT CREATED IN TABLE YET
	private double fatalityRate;
	private String distancingMeasures;
	private boolean isStayAtHome;
	private int totalOver65;
	private double percentOlderAdults;
	
	public State (String name)
	{
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/johnmortensen/.aws/credentials), and is in valid format.",
                    e);
        }
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        		.withCredentials(credentialsProvider)
                .withRegion("us-west-1")
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Covid19Data");
        Item item = table.getItem("State",name);
        
        //initialize instance variables
        stateName = item.getString("State");
        totalCases = item.getString("Number of COVID-19 Cases");
        casesPerMillion = item.getString("COVID-19 Cases per 1,000,000 Population");
        totalDeaths = item.getString("Deaths from COVID-19");
        deathsPerMillion = item.getString("COVID-19 Deaths per 1,000,000 Population");
	}
	
	public String getName()
	{return stateName;}
	
	public String getTotalCases()
	{return totalCases;}
	
	public String getCasesPerMillion()
	{return casesPerMillion;}
	
	public String getTotalDeaths()
	{return totalDeaths;}
	
	public String getDeathsPerMillion()
	{return deathsPerMillion;}
	
}
