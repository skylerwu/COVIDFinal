package control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.DeflaterOutputStream;

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
	private double totalCases;
	private double totalDeaths;
	private String distancingMeasures; //blank or has a dash, then leave out; if present, then add to String.
	//private boolean isStayAtHome;
	private double totalOver65;
	private double percentOlderAdults;
	
	public State (String name, String totCases, String deathTotal, 
	String measuresDistancing, String over65, String oldPercent)
	{
		stateName = name;
		if (totCases != null) {
			totalCases = Double.parseDouble(totCases);
		}

		if (deathTotal != null) {
			totalDeaths = Double.parseDouble(deathTotal);
		}

		if (!measuresDistancing.isEmpty()) {
			distancingMeasures = measuresDistancing;
		}
		else {
			distancingMeasures = "";
		}

		if (!over65.isEmpty()) {
			totalOver65 = Double.parseDouble(over65);
		}
		if (!oldPercent.isEmpty()) {
			percentOlderAdults = Double.parseDouble(oldPercent);
		}
	}

	public String getName()
	{return stateName;}
	
	public String getTotalCases()
	{return Double.toString(totalCases);}
	
	public String getTotalDeaths()
	{return Double.toString(totalDeaths);}
	
	public String getDistancingMeasures()
	{return distancingMeasures;}
	
	public String getTotalOver65()
	{return Double.toString(totalOver65);}
	
	public String getPercentOlderAdults()
	{return Double.toString(percentOlderAdults);}
	
	public String toString()
	{return stateName;}
}
