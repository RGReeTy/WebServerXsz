package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		try (InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("server.properties")) {
			prop.load(in);
		}
		System.out.println("webapp.static.dir.root=" + prop.getProperty("webapp.static.dir.root"));
		System.out.println("webapp.static.notfound=" + prop.getProperty("webapp.static.notfound"));
	}

}
