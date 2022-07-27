package app;

import classes.Car;
import classes.User;



public class Program {

	public static void main(String[] args) {

		ReflectionClasses reflectionClasses = new ReflectionClasses();

//		try {
//
//			Field field = user.getClass().getDeclaredField("firstName");
//			field.setAccessible(true);
//			name = (String) field.get(user);
//
//		} catch (NoSuchFieldException | IllegalAccessException e) {
//			e.printStackTrace();
//
//		}



//		Provide info about classes in classes package

		reflectionClasses.showClasses();
		System.out.println("---------------------");

//		Enable user to create objects of a specified class with specific field values

//		Display info about created class object

//		Call class methods




	}
}
