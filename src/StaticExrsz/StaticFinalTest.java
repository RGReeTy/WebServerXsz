package StaticExrsz;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class StaticFinalTest {
	public static final String OK = "OK";
	public static final long CLASS_LOADED;
	static {
		CLASS_LOADED = System.currentTimeMillis();
	}
	public final String ok = "OK";
	public final long objectCreated;

	public StaticFinalTest() {
		objectCreated = System.currentTimeMillis();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new Date(CLASS_LOADED));
		TimeUnit.SECONDS.sleep(1);
		System.out.println(new StaticFinalTest().objectCreated);

	}

}
