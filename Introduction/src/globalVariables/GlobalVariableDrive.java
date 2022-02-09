package globalVariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalVariableDrive {

	public static void main(String[] args) throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Naser\\SeleniumPaidTrainingAttempt2\\Introduction\\src\\config.properties");
	prop.load(fis);
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("url"));
	
	prop.setProperty("browser", "fireFox");
	System.out.println(prop.getProperty("browser"));
	FileOutputStream fos = new FileOutputStream("C:\\Naser\\SeleniumPaidTrainingAttempt2\\Introduction\\src\\config.properties");
	prop.store(fos, "");
	}

}

