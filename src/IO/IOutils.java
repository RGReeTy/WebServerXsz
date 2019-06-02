package IO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public interface IOutils {
	
	void replaceChars(Reader in, Writer out, String inChars, String outChars) throws NullPointerException, IllegalArgumentException, IOException;
	
	List<Path> findText(Path rootDir, String textToField, boolean ignoreCase) throws NullPointerException, IllegalArgumentException, IOException;

}
