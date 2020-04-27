package dataPull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class DataToJSON {

    private static String readWebsite() throws Exception{
        // Make a URL to the web page
        URL url = new URL("https://github.com/nytimes/covid-19-data/blob/master/us-states.csv");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String startLine = "<table class=\"js-csv-data csv-data js-file-line-container\">";
        String endLine = "</table>";
        boolean tableData = false;
        String line = null;

        String htmlData = "";

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            line = line.replaceFirst("    ", "");
            if (tableData && !(line.contains("<td "))) {
                if (line.contains("<tr")) {
                    int startIndex = line.indexOf("<tr");
                    line = line.substring(startIndex, startIndex + 3) + ">";
                    for (int i=0; i < startIndex; i++) {
                        line = " " + line;
                    }
                }
                htmlData += line + "\n";
            }

            if (line.equals(startLine)) {
                tableData = true;
                htmlData += "<table>\n";

            }

            if (line.equals(endLine)) {
                System.out.println("done");
                tableData = false;
            }

        }

        return htmlData;
    }

    public static String TableToJson(String source) throws JSONException {
        Document doc = Jsoup.parse(source);
        JSONObject jsonParentObject = new JSONObject();
        for (Element table : doc.select("tbody")) {
            for (Element row : table.select("tr")) {
                JSONObject jsonObject = new JSONObject();
                Elements tds = row.select("td");
                String Date = tds.get(0).text();
                String State = tds.get(1).text();
                String Cases = tds.get(3).text();
                String Deaths = tds.get(4).text();
                jsonObject.put("Date", Date);
                jsonObject.put("State", State);
                jsonObject.put("Cases", Cases);
                jsonObject.put("Deaths", Deaths);
                jsonParentObject.put(State +":"+ Date, jsonObject);
            }
        }
        return jsonParentObject.toString();
    }

    private static String removeDigits(String inp) {
        String filteredString = inp;
        for (int i=0; i<10; i++) {
            filteredString.replace(i + "", "");
        }
        return (filteredString);
    }

    public static void main(String[] args) {
        try {
            System.out.println("reading data");
            String htmldata = readWebsite();
            System.out.println(htmldata);
            String json = TableToJson(htmldata);
            System.out.println(json);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("done");
    }
}
