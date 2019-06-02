package IO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.List;

import com.oracle.tools.packager.IOUtils;

public class DefaultIOUtilsTest {

	public static void main(String[] args) throws IOException {

		IOUtils ioUtils = new DefaultIOUtils();

		StringReader in = new StringReader("1234567890");
		String inChars = "357";
		String outChars = "480";
		StringWriter out = new StringWriter();

		ioUtils.replaceChars(in, out, inChars, outChars);
		System.out.println(out.toString());

		List<Path> foundPath = ioUtils.findText(Path.get("test"), "purpose", true);
		if (foundPaths.isEmpty()) {
			System.out.println("Files not found");
		} else {
			for (Path file : foundPaths) {
				System.out.println(file);
			}
		}

	}

}
