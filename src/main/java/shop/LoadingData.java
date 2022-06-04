package shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface LoadingData {
    static String readString(String file) {
        String line;
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json.toString().replaceAll("\\s+", "");
    }
}
