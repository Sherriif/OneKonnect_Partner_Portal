package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;


public class DataReader {
    // Login data reader
    public static Object[] getLoginData(String resourcePath) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(DataReader.class.getClassLoader().getResourceAsStream(resourcePath))
        );
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");

        return new Object[]{username, password};
    }

    // EDI form reader
    public static JSONObject getEDIFormData(String resourcePath) throws Exception {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new InputStreamReader(DataReader.class.getClassLoader().getResourceAsStream(resourcePath))
        );
    }
}




