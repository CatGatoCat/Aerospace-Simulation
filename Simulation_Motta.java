/***********************************
 * Filename: Simulation_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 3/20/2024
 * Modified: 4/21/2024
 * Purpose: The parent class for different types of simulations. Used in
 *	the inheritance implementation of the simulations.
 *
 * Attributes:
 * + gravity: double
 * - mass2: double
 * - initialFuel2: double
 * - initialVel2: double
 * - velExhaust2: double
 * - timeOfBurn2: double
 * 
 * - maxHeight: double
 * - maxVel: double
 * - totalTime: double
 * - FuelUsed: double
 * - Successful: boolean
 * 
 * - simType: int
 *
 * Methods:
 * +<<constructor>> Simulation_Motta(int, Sim_Info_Motta)
 * -setValues(Sim_Info_Motta): void
 * +getMass2(): double
 * +getVelExhaust2(): double
 * +getTimeOfBurn2(): double
 * +getMaxHeight(): double
 * +getSimType(): int
 * +setMaxSpeed(double): void
 * +getMaxSpeed(): double
 * +getTotalTime(): double
 * +MaxVel(): void
 * -setMaxHeight(): double
 * -FuelUsage(): double
 * -Success(): boolean
 * -setTotalTime(): double
 * +toString(): String
 ***********************************/

// parent class

public abstract class Simulation_Motta {

	//parameters
	
	public static double gravity = 9.81;

	private double mass2;
	private double initialFuel2;
	private double initialVel2;
	private double velExhaust2;
	private double timeOfBurn2;	


	private double maxHeight;
	private double maxVel;
	private double totalTime;
	private double FuelUsed;
	private boolean Successful;

	private int simType;

	//constructor
	public Simulation_Motta(int choice, Sim_Info_Motta val)
	{
		simType = choice;


		maxHeight = 0;
		maxVel = 0;
		totalTime = 0;
		FuelUsed = 0;
		Successful = false;
		
		setValues(val);
	}


	private void setValues(Sim_Info_Motta val) {
		mass2 = val.getMass();
		initialFuel2 = val.getFuel();
		initialVel2 = val.getInitialVel();
		velExhaust2 = val.getVelExhaust();
		timeOfBurn2 = val.getTimeOfBurn();
	}

	//setters and getters

	public double getMass2() {return mass2;}
	public double getVelExhaust2() {return velExhaust2;}
	public double getTimeOfBurn2() {return timeOfBurn2;}
	
	
	public double getMaxHeight() { return setMaxHeight(); }

	public int getSimType() {return simType; }

	public void setMaxSpeed(double MaxVel) {maxVel = MaxVel;}

	public double getMaxSpeed() { return maxVel;}
	
	public double getTotalTime() {return setTotalTime();}


	//Overridden method
	public abstract void MaxVel();


	//extra calculations

	private double setMaxHeight()
	{
		if (getMaxSpeed() != 0 && initialVel2 != 0) {
			maxHeight = (Math.pow(getMaxSpeed(),2)-Math.pow(initialVel2,2))/(2*gravity);
		}

		return maxHeight;
	}

	private double FuelUsage() {

		double massFinal;

		massFinal = mass2*(Math.exp(initialVel2/(velExhaust2-1)));

		FuelUsed = initialFuel2 - massFinal;

		if(FuelUsed < 0)
		{
			FuelUsed = 0;
		}

		return FuelUsed;
	}

	private boolean Success() {

		boolean Success;

		if(getMaxHeight() > 10000) {
			Success = true;
		} else{
			Success = false;
		}

		Successful = Success;

		return Successful;
	}



	private double setTotalTime() {
		double Time = 0;
		Time = getMaxSpeed()/initialVel2;
		totalTime = Time;
		return totalTime;
	}



	//print out the calculations
	public String toString()
	{


		String s = "";



		if(simType==1) {
			s += "Satellite Simulation\n";
		}
		if(simType ==2 ) {
			s += "Rover Simulation\n";
		}
		if(simType == 3) {
			s += "Aircraft Simulation\n";
		}

		return s + "\nSuccess = " + Success() + "\nMaximum Height = " + getMaxHeight() + "\nTotal Mission Time = " + getTotalTime() + "\nFuel Usage = " + FuelUsage() + "\nMaximum Velocity = " + getMaxSpeed();

	}
	
}