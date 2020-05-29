package dataPull;

import DynamoDB.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.eclipse.jetty.util.IO;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class UpdateData {
    public static void main (String args[]) {
        try {
            dataUpdate();
        }
        catch(Exception e) {

        }
    }
    public static void dataUpdate() throws IOException, Exception {
        //calls python script and writes data to HTMLCodeKFF.txt
        GetHTML.pullHTML();

        //parses html data into JSONObjects
        //state policy
        JSONObject statePolicy = KffDataToJSON.htmlToJSON();

        //cases and deaths
        JSONObject caseDeath = CaseDeathData.TableToJson(CaseDeathData.readWebsite());

        //Fill aws Table
        FillTable.updateTable(mergeData(caseDeath, statePolicy));
    }

    private static JSONObject mergeData(JSONObject source, JSONObject target) {
        for (String key: JSONObject.getNames(source)) {
            Object value = source.get(key);
            if (!target.has(key)) {
                // new value for "key":
                target.put(key, value);
            } else {
                // existing value for "key" - recursively deep merge:
                if (value instanceof JSONObject) {
                    JSONObject valueJson = (JSONObject)value;
                    mergeData(valueJson, target.getJSONObject(key));
                } else {
                    target.put(key, value);
                }
            }
        }
        return target;
    }
}
