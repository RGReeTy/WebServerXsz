package Thread.home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;



public class CopyFileTaskThread implements Task, Runnable {
	private final long sourceSize;
	private final Path sourcePath;
	private final Path destinationPath;
	private final Thread thread;
	private volatile long copied;

	public CopyFileTaskThread(Path sourcePath, Path destinationPath, long sourceSize) throws IOException {
		super();
		this.sourcePath = sourcePath;
		this.destinationPath = destinationPath;
		this.sourceSize = sourceSize;
		this.copied = 0;
		this.thread = new Thread(this, "CopyFileTaskThread");
	}

	@Override
	public void run() {
		byte[] buffer = new byte[8192];
		try (InputStream in = new FileInputStream(sourcePath.toFile());
				OutputStream out = new FileOutputStream(destinationPath.toFile())) {
				while(!Thread.interrupted()) {
					int read = in.read(buffer);
					if (read == -1) {
						break;
					}
					out.write(buffer, 0, read);
					copied +=read;
				}
	} catch (IOException e){
		System.err.println("Copy failed:" + e.getMessage());
		e.printStackTrace();
			}
		}

	@Override
	public void start() {
		if(thread.getState() != Thread.State.NEW) {
			throw new IllegalArgumentException("CopyFileTask already executed");
		}
		this.thread.start();
		
	}

	@Override
	public void interrupt() {
		this.thread.interrupt();
		
	}

	@Override
	public int getPercentProgress() {
		return (int) (this.copied *100 / sourceSize);
	}

}
