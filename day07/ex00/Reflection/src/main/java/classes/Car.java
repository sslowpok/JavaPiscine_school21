package classes;

import java.util.StringJoiner;

public class Car {

	private String color;
	private int maxSpeed;
	private int fuelVolume;

	public Car(String color, int maxSpeed, int fuelVolume) {
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.fuelVolume = fuelVolume;
	}

	public Car() {
		this.color = "default";
		this.maxSpeed = 0;
		this.fuelVolume = 0;
	}

	public int increaseFuelVolume(int amount) {
		this.fuelVolume += amount;
		return this.fuelVolume;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
				.add("color='" + color + "'")
				.add("maxSpeed=" + maxSpeed)
				.add("fuelVolume=" + fuelVolume)
				.toString();
	}
}
