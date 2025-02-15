package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream readFile = null;        //para leer el archivo uso el objeto InputStream

        try{
            readFile = new FileInputStream("config.properties");

            prop.load(readFile);

            System.out.println(prop.getProperty("DBServer"));
            System.out.println(prop.getProperty("DBPass"));
            System.out.println(prop.getProperty("DBName"));
            System.out.println(prop.getProperty("username"));
        } catch(IOException io){
            io.printStackTrace();
        } finally {
            if(readFile!=null){
                try {
                    readFile.close();       //cierro el archivo por seguridad
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

