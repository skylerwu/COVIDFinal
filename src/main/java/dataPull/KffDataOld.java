package dataPull;

import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class KffDataOld {

    public static void main(String[] args) throws Exception {
        System.out.println(pullHTML());
        for (String[] element: parseData(pullHTML())){
            for(String under: element) {
                System.out.println(under);
            }
        }
        System.out.println(toJSON(parseData(pullHTML())).toString());

    }

    private static String processLine(String line) {
        line = line.replace("&quot", "").replace(",;", "").
                replace("null","").replace("<div kff-indicator-components data-app-js=","");

        line = line.substring(line.indexOf(";,[")+3, line.indexOf("Notes"));
        return line;
    }

    private static ArrayList<String> pullHTML() throws Exception {

        // Make a URL to the web page
        URL url = new URL("https://www.kff.org/health-costs/issue-brief/state-data-and-policy-actions-to-address-" +
                "coronavirus/");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;

        ArrayList<String> htmlData = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (line.contains("kff-indicator-components")) {
                System.out.println(line);
                htmlData.add(processLine(line));
            }
        }
        is.close();
        return htmlData;
    }

    private static ArrayList<String[]> parseData(ArrayList<String> unparsed) {
        ArrayList<String[]> parsed = new ArrayList<>();

        for (int i=0; i<unparsed.size(); i++) {
            String[] line = unparsed.get(i).split("],");
            for (int j=0; j < line.length; j++) {
                line[j] = line[j].replace("[", "").replace("]", "").replaceAll(
                        ";$", "").replaceAll("^;", "");
            }
            parsed.add(line);
        }
        return parsed;
    }

    private static JSONObject toJSON(ArrayList<String[]> source) {
        JSONObject jsonParentObject = new JSONObject();

        for(int k=2; k < 3; k++) {
            String[] table = source.get(k);

            String[] headers = table[0].replaceAll("[,\\-/]", "").split(";");
            for (String row : table) {
                try {
                    row = row.replaceAll("[,\\-/]", "");
                    String[] parsedRow = row.split(";");

                    System.out.println(headers.toString());
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 0; i < headers.length; i++) {
                        jsonObject.accumulate(headers[i], parsedRow[i + 1]);
                    }

                    jsonParentObject.put(parsedRow[0], jsonObject);
                } catch (Exception e) {
                    System.out.println("Warning, element may be missing");
                }

            }
        }
        return jsonParentObject;
    }

    public static JSONObject dataMain() throws Exception{
        return toJSON(parseData(pullHTML()));
    }
}


