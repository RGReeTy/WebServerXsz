package IO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class DefaultIOUtils implements IOutils {
	@Override
	public void replaceChars(Reader in, Writer out, String inChars, String outChars)
			throws NullPointerException, IllegalArgumentException, IOException {
		Objects.requireNonNull(in, "Reader should be not null");
		Objects.requireNonNull(out, "Writer should be not null");
		if (inChars == null) {
			inChars = "";
		}
		if (outChars == null) {
			outChars = "";
		}
		if (inChars.length() != outChars.length()) {
			throw new IllegalArgumentException("inChars.length()!= outChars.length()");
		}
		try (Reader r = in; Writer wr = out) {
			char[] buffer = new char[8192];
			while (true) {
				int read = r.read(buffer);
				if (read == -1) {
					break;
				} else {
					transformCharArray(buffer, read, inChars, outChars);
					wr.write(buffer, 0, read);
				}
			}
			wr.flush();
		}
	}

	private void transformCharArray(char[] buffer, int read, String inChars, String outChars) {
		for (int i = 0; i < read; i++) {
			int index = inChars.indexOf(buffer[i]);
			if (index != -1) {
				buffer[i] = outChars.charAt(index);
			}
		}
	}

	@Override
	public List<Path> findText(Path rootDir, String textToField, boolean ignoreCase)
			throws NullPointerException, IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
