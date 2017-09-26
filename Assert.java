
public class Assert {
	
	public static void notFalse(boolean expr) {
		if (!expr)
			throw new IllegalArgumentException();
	}

}
