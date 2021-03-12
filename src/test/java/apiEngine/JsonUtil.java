package apiEngine;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonUtil {

    public static String getJsonElement(Response response, String key) {
        String responseStr = response.asString();
        JsonPath js = new JsonPath(responseStr);
        return js.get(key).toString();
    }

    public static String getJsonString(String path) {
        InputStream is = null;
        try {
            File jsonFile = new File(System.getProperty("user.dir") + "/src/test/resources/__files/" + path);
            is = new FileInputStream(jsonFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONTokener jsonTokener = new JSONTokener(is);
        return new JSONObject(jsonTokener).toString();
    }
}