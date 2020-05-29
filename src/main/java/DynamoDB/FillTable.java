package DynamoDB;


import java.util.Iterator;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import dataPull.KffDataToJSON;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

public class FillTable {
    public static void main(String[] args) throws Exception {
        updateTable(KffDataToJSON.htmlToJSON());
    }

    public static void updateTable(JSONObject jsonData) {

        ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (/Users/AllenYang/.aws/credentials), and is in valid format.",
                    e);
        }
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion("us-west-1")
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Covid19Data");

        Iterator<String> iter = jsonData.keys();

        while (iter.hasNext()) {
            String state = iter.next();

            try {
                Item row = new Item().withPrimaryKey("State", state);

                Map<String, Object> info = jsonData.getJSONObject(state).toMap();

                for (Map.Entry<String, Object> entry: info.entrySet()) {
                    row.withString(entry.getKey(), entry.getValue().toString());
                }

                //data.putItem(new Item().withPrimaryKey("State", state).withJSON("info",
                //jsonData.getJSONObject(state).toString()));
                table.putItem(row);
                System.out.println("PutItem succeeded: " + state);

            }
            catch (Exception e) {
                System.err.println("Unable to add state: " + state);
                System.err.println(e.getMessage());
                break;
            }
        }
    }

}
