package singleton;

public class 懒汉 {
	private static 懒汉 singleton = null;

	private 懒汉() {
	}

	public static final 懒汉 getInstance() {
		if (null == singleton) {
			synchronized (懒汉.class) {
				if (null == singleton) {
					singleton = new 懒汉();
				}
			}
		}

		return singleton;
	}
}
