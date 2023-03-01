package com.ReadFromFiles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJSON {
    public static String readFile(String key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader read = new FileReader(System.getProperty(("user.dir")+"/testData/testData.json"));
        Object obj = jsonParser.parse(read);

        JSONObject jsonObject =(JSONObject) obj;
        String value =jsonObject.get(key).toString();
        return value;
    }
}
