package dataPull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetHTML {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(pullHTML());
    }

    public static String pullHTML() throws IOException, InterruptedException{
        String code = "";
        Process p = Runtime.getRuntime().exec(new String[] {"apcs/bin/python", "src/main/pullHTML.py"});
        System.out.println("Getting html");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null)  {
                code += line + "\n";
            }
        }

        return code;
    }
}
