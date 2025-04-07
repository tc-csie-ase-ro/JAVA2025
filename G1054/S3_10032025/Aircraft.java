package eu.ase.lab3;

public abstract class Aircraft implements Operable {

	private int enginesNo;
	private float maxSpeed;
	private float maxAltitude;
	
	public Aircraft(int enginesNo, float maxSpeed, float maxAltitude) {
		this.enginesNo = enginesNo;
		this.maxSpeed = maxSpeed;
		this.maxAltitude = maxAltitude;
	}

	public int getEnginesNo() {
		return enginesNo;
	}

	public void setEnginesNo(int enginesNo) {
		this.enginesNo = enginesNo;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public float getMaxAltitude() {
		return maxAltitude;
	}

	public void setMaxAltitude(float maxAltitude) {
		this.maxAltitude = maxAltitude;
	}
	
	public abstract void takeOff();
	public abstract void navigate();
	public abstract void land();
	
	public float speedPerEngine() {
		return this.getMaxSpeed() / this.getEnginesNo();
	}
	
}
