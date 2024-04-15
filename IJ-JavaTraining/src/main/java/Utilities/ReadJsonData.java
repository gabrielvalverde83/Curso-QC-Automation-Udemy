package Utilities;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonData {

    public static void main(String[] args) throws IOException, ParseException {

        String filepath = System.getProperty("user.dir") + "//testData.json";   //archivo donde esta el JSON
        FileReader file = new FileReader(filepath);

        JSONParser parser = new JSONParser();   //parser = analizador, extrae toda la info del json para luego convertirlo en atributos y valores de un objeto?
        JSONObject json = (JSONObject) parser.parse(file);

        System.out.println(json.toJSONString());

        JSONArray testData = (JSONArray) json.get("testdata");  //este era el primer titulo
//		System.out.println(testData.toJSONString());
//
//	    //para trabajar en un objeto JSON dentro del ppal:
//
//		JSONObject logintest = (JSONObject) testData.get(0);
//		System.out.println(logintest.toJSONString());
//		System.out.println(logintest.get("testName"));
//
//		JSONArray loginTestSet = (JSONArray) logintest.get("data");
//		JSONObject LoginTestSetData1 = (JSONObject) loginTestSet.get(1);
//		System.out.println(LoginTestSetData1.get("browser"));

        /*crea un objeto llamado testCase donde cada objeto que lo compone va a ser un objeto que saca del testData que fue creado en la linea 27, que era una matriz*/

        for (int i = 0; i < testData.size(); i++) {

            JSONObject testCase = (JSONObject) testData.get(i);
            System.out.println("Test Case Name is --  " + testCase.get("testName"));

            /*data es un JSON Array, asi que para trabajarlo, solo lo imprimimos, usamos JSON Array*/
            /*para trabajarlo hay que crearlo*/
            JSONArray testCaseData = (JSONArray) testCase.get("data");
            for (int j = 0; j < testCaseData.size(); j++) {

                JSONObject currentTestData = (JSONObject) testCaseData.get(j);
                Set<String> keys = currentTestData.keySet();
                Iterator<String> it = keys.iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String value = (String) currentTestData.get(key);
                    System.out.println(key + " -- " + value);
                }


            }


        }








    }

}
