package app;

import classes.Car;
import classes.User;

import java.lang.reflect.Field;

public class Program {

	public static void main(String[] args) {

		User user = new User();
		String name = null;

		try {

			Field field = user.getClass().getDeclaredField("firstName");
			field.setAccessible(true);
			name = (String) field.get(user);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();

		}

		System.out.println(name);

	}
}
