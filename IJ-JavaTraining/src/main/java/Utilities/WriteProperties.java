package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperties {

	public static void main(String[] args) {

		Properties prop = new Properties();		//lo uso para escribir las propiedades y mas abajo para escribirle el codigo al archivo con prop.store
		OutputStream writeFile = null;		//para escribir el archivo uso el objeto OutputStream

		try {
			writeFile = new FileOutputStream("config.properties");	//aca va el nombre con su extensión y la ubicacion del archivo a crear

			prop.setProperty("DBServer", "ins01.kui02.anshul");	//(key, value)
			prop.setProperty("DBName", "db_anshul");
			prop.setProperty("DBPass", "testpassword");
			prop.setProperty("username", "root");

			prop.store(writeFile, null);
			System.out.println("Create Properties Successfully");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (writeFile != null) {
				try {
					writeFile.close();		//tengo que cerrar el archivo
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
