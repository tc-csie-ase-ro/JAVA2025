package eu.ase.lab3;

public class Helicopter extends Aircraft {

	private int rotorBlades;
	
	protected Helicopter(int rotorBlades, int enginesNo, float maxSpeed, float maxAltitude) {
		super(enginesNo, maxSpeed, maxAltitude);
		this.rotorBlades = rotorBlades;
	}
	
	public int getRotorBlades() {
		return rotorBlades;
	}

	public void setRotorBlades(int rotorBlades) {
		this.rotorBlades = rotorBlades;
	}

	@Override
	public void takeOff() {
		System.out.println("The helicopter is taking off vertically");
	}

	@Override
	public void navigate() {
		System.out.println("The helicopter is navigating");
	}

	@Override
	public void land() {
		System.out.println("The helicopter is landing vertically");
	}

	@Override
	public String toString() {
		return String.format("The helicopter has %d rotor blades, %d engines, %.2f maximum speed and %.2f maximum altitude", this.getRotorBlades(), this.getEnginesNo(), this.getMaxSpeed(), this.getMaxAltitude());
	}

	@Override
	public float speedPerEngine() {
		return this.getMaxSpeed() / this.getEnginesNo() / this.getRotorBlades();
	}

	@Override
	public void startEngine() {
		for (int i = 0; i < this.getEnginesNo(); i++) {
			System.out.println(String.format("Engine %d is starting", (i + 1)));
		}
		System.out.println(String.format("The %d blades of the rotor started spinning", this.getRotorBlades()));
	}

	@Override
	public void stopEngine() {
		for (int i = 0; i < this.getEnginesNo(); i++) {
			System.out.println(String.format("Engine %d is stopping", (i + 1)));
		}
		System.out.println(String.format("The %d blades of the rotor stopped spinning", this.getRotorBlades()));
	}
	
	
}
