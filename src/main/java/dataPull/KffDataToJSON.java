package dataPull;


import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.File;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KffDataToJSON {
    public static JSONObject htmlToJSON() {
        try {
            //pull body from html code
            Document code = parseHTML();

            //parse data into arraylist
            ArrayList<String> states = getStates(code);
            ArrayList<Map<String,String>> rows = parseRow(code);

            //convert to JSON Object and return
            return (mergeArray(rowToJSON(rows, states)));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(htmlToJSON().toString());
    }

    private static Document parseHTML() throws Exception {
        File kffcode = new File("src/main/java/dataPull/HTMLCodeKff");
        Scanner fileReader = new Scanner(kffcode);
        String htmlCode = "";

        while (fileReader.hasNextLine()) {
            htmlCode += fileReader.nextLine() + "\n" ;
        }
        fileReader.close();

        Document doc = Jsoup.parseBodyFragment(htmlCode);

        return doc;
    }

    private static ArrayList<String> getStates(Document code) {
        ArrayList<String> states = new ArrayList<>();
        Elements elements = code.select("[class*=\"ag-row\"]");

        for (Element element: elements) {
            String state = element.children().select("[colid=\"Location\"]").text().replaceAll("[^A-Za-z ]+", "").trim().toUpperCase();
            if (!state.isEmpty()) {
                states.add(state);
            }
        }

        return states;
    }

    private static ArrayList<Map<String,String>> parseRow(Document code) {
        Elements elements = code.select("[class*=\"ag-row\"]");

        ArrayList<Map<String, String>> rows = new ArrayList<>();

        for (Element element: elements) {
            Map<String, String> row = new HashMap<>();

            for (Element node: element.children()) {
                String colid = node.attr("colid");
                //System.out.println(colid + ": " + node.text() + " " + colid.equals("Location"));
                if (!colid.equals("Location") && !colid.isEmpty()) {
                    row.put(colid, node.text());
                }
            }

            if (!row.isEmpty()) {
                rows.add(row);
            }
        }

        return rows;
    }

    private static JSONObject rowToJSON(ArrayList<Map<String, String>> rows, ArrayList<String> states) {
        JSONObject jsonParentObject = new JSONObject();

        for (int i=0; i < rows.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            for (String key: rows.get(i).keySet()) {
                jsonObject.accumulate(key, rows.get(i).get(key));
            }

            jsonParentObject.accumulate(states.get(i), jsonObject);
        }

        return jsonParentObject;
    }

    private static JSONObject mergeArray(JSONObject jsonParentObject) {
        JSONObject finalJSON = new JSONObject();
        for (String key: jsonParentObject.keySet()) {
            JSONObject combinedRow = new JSONObject();
            JSONArray arrayRow = jsonParentObject.getJSONArray(key);
            System.out.println(arrayRow.getJSONObject(0).getClass());
            for (int i=0; i < arrayRow.length(); i++) {
                for(String key2: arrayRow.getJSONObject(i).keySet()) {
                    combinedRow.accumulate(key2, arrayRow.getJSONObject(i).getString(key2));
                }
            }
            finalJSON.put(key, combinedRow);
        }

        return finalJSON;
    }

}
