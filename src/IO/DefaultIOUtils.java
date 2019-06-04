package IO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
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
	public List<Path> findText(Path rootDir, String textToFind, final boolean ignoreCase)
			throws NullPointerException, IllegalArgumentException, IOException {
		Objects.requireNonNull(rootDir, "rootDir should be not null");
		Objects.requireNonNull(textToFind, "textToFind should be not null");
		if (!Files.isDirectory(rootDir)) {
			throw new IllegalArgumentException("rootDir is not directory: " + rootDir);
		}
		final List<Path> foundPaths = new ArrayList<>();
		Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (fileContainsText2(file, textToFind, ignoreCase)) {
					foundPaths.add(file);
				}
				return FileVisitResult.CONTINUE;
			}
		});

		return foundPaths;
	}

	private boolean fileContainsText2(Path file, String textToFind, boolean ignoreCase) throws IOException {
		String text = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
		if (ignoreCase) {
			text = text.toLowerCase();
		}
		return text.contains(textToFind);
	}

	private boolean fileContainsText1(Path file, String textToFind, boolean ignoreCase) throws IOException{
		int bufferSize = getBufferSize(textToFind);
		char[] ch1 = new char[bufferSize];
		int offset = 0;
		try (Reader r = Files.newBufferedReader(file)){
			while(true) {
			int read = r.read(ch1, offset, bufferSize-offset);
				if(read ==-1) {
					return false;
				}
				String text = new String(ch1, 0, read+offset);
				boolean contains = contains(text, textToFind, ignoreCase);
				if (contains) {
					return true;
				}
				int half = (read + offset)/2;
				for (int i=half; i<read+offset; i++) {
					ch1[i-half]=ch1[i];
				}
				offset = half;
	}

}}

	private boolean contains(String text, String textToFind, boolean ignoreCase) {
		if (ignoreCase) {
			text = text.toLowerCase();
			textToFind = textToFind.toLowerCase();
		}
		return text.contains(textToFind);
	}

	private int getBufferSize(String textToFind) {
		int minBufferSize = 1024 * 1024;
		int bufferSize = textToFind.length() * 4;
		return bufferSize < minBufferSize ? minBufferSize : bufferSize;
	}
}