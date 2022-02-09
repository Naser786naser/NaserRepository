package log4jpackage;

import org.apache.logging.log4j.*;

public class Demo2 {
	private static Logger log = LogManager.getLogger(Demo2.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.info("There is no error");
		log.fatal("Object is not found");
		log.error("Test didn't pass");
		log.debug("This is debug message");

		System.out.println("Hello");

	}

}
