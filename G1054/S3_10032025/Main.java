package eu.ase.lab3;

public class Main {

	public static void main(String[] args) {
		
		Aircraft airplane = new Airplane(80f, 4, 925, 11000);
		Aircraft helicopter = new Helicopter(4, 2, 240, 6000);
		
		System.out.println(airplane.toString());
		airplane.takeOff();
		airplane.navigate();
		airplane.land();
		
		System.out.println("------------------------");
		
		System.out.println(helicopter.toString());
		helicopter.takeOff();
		helicopter.navigate();
		helicopter.land();
		
		Aircraft[] aircrafts = new Aircraft[2];
		aircrafts[0] = airplane;
		aircrafts[1] = helicopter;
		
		System.out.println("------------------------");
		
		for (Aircraft aircraft : aircrafts) {
			System.out.println(aircraft.toString());
			aircraft.takeOff();
			aircraft.navigate();
			aircraft.land();
			System.out.println();
		}
		
		System.out.println(airplane.speedPerEngine());
		System.out.println(helicopter.speedPerEngine());

//		Operable.workingEngine();
//		System.out.println(Operable.a);
		
		System.out.println("------------------------");

		
		Airplane newAirplane = new Airplane(80f, 4, 925, 11000);
		
		newAirplane.startEngine();
		newAirplane.stopEngine();
		
		Helicopter newHelicopter = new Helicopter(4, 2, 240, 6000);
		
		newHelicopter.startEngine();
		newHelicopter.stopEngine();
 
		airplane.startEngine();
	}

}
