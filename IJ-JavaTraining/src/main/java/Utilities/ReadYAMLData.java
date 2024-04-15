package Utilities;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;        //hacemos referencia el al jar externo
import com.esotericsoftware.yamlbeans.YamlReader;

public class ReadYAMLData {

    public static void main(String[] args) throws FileNotFoundException, YamlException {

        String filepath = System.getProperty("user.dir") + "//testData.yml";    //ubicacion del archivo
        FileReader file = new FileReader(filepath);

        YamlReader reader = new YamlReader(file);

        //Map - JSONObject
        //List - JSONArray

        Map testData = (Map)reader.read();  // este es todo el objeto JSON, y lo guarda como si fuese una coleccion, de tipo MAP

        List testCases = (List) testData.get("testdata");   //aca guardamos todo el objeto testData anterior, que era todo el JSON, y lo hacemos como si fuese una Lista, o sea un Array
        System.out.println(testCases);

        Map loginTestData = (Map) testCases.get(0);
        System.out.println(loginTestData.get("testName"));

        List loginTestDataData = (List) loginTestData.get("data");
        System.out.println(loginTestDataData);

    }

}
