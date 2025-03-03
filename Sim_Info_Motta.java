/***********************************
 * Filename: Sim_Info_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 4/15/2024
 * Modified: 4/21/2024
 * Purpose: The database for the values obtained from the file input
 *
 *
 * Attributes:
 * - SimInfo: ArrayList<Simulation_Motta>
 * - mass: double
 * - initialFuel: double
 * - velExhaust: double
 * - timeOfBurn: double
 * - initialVel: double
 * - LenghtOrDiam: double
 * - WidAstrBatt: double
 *
 * Methods:
 * +<<constructor>> Sim_Info_Motta()
 * +getFuel(): double
 * +setFuel(double): void
 * +getLengDia(): double
 * +setLengDia(double): void
 * +getWidtAstBat(): double
 * +setWidtAstBat(double): void
 * +getInitialVel(): double
 * +setInitialVel(double): void
 * +getVelExhaust(): double
 * +setVelExhaust(double): void
 * +getMass(): double
 * +setMass(double): void
 * +getTimeOfBurn(): double
 * +setTimeOfBurn(double): void
 * +addInfo(Simulation_Motta): void
 ***********************************/

import java.util.ArrayList;

public class Sim_Info_Motta {

	private ArrayList<Simulation_Motta> SimInfo = new ArrayList<>();

	private double mass;
	private double initialFuel;
	private double velExhaust;
	private double timeOfBurn;
	private double initialVel;
	private double LenghtOrDiam;
	private double WidAstrBatt;

	public Sim_Info_Motta()
	{
		mass = 0;
		initialFuel = 0;
		velExhaust = 0;
		timeOfBurn = 0;
		initialVel = 0;
		LenghtOrDiam = 0;
		WidAstrBatt = 0;
	}

	public double getFuel() {return initialFuel;}
	public void setFuel(double Fuel) {
		if(Fuel<0) {
			initialFuel = 0;
		}else {
			initialFuel = Fuel;	
		}
	}

	public double getLengDia() {return LenghtOrDiam;}
	public void setLengDia(double LeDi) {
		if(LeDi<0) {
			LenghtOrDiam = 0;
		}else {
			LenghtOrDiam = LeDi;	
		}	
	}

	public double getWidtAstBat() {return WidAstrBatt;}
	public void setWidtAstBat(double WiAsBa) {
		if(WiAsBa < 0) {
			WidAstrBatt = 0;
		}else {
			WidAstrBatt = WiAsBa;
		}

	}

	public double getInitialVel() {return initialVel;}
	public void setInitialVel(double VelInitial) {
		if(VelInitial<0) {
			initialVel = 0;
		}else {
			initialVel = VelInitial;
		}
	}


	public double getVelExhaust() {return velExhaust;}
	public void setVelExhaust(double ExhVel) {
		if(ExhVel<0) {
			velExhaust = 0;
		}else {
			velExhaust = ExhVel;
		}
	}


	public double getMass() {return mass;}
	public void setMass(double Mass) {
		if(Mass<0)
		{
			Mass = 0;
		}else {
			mass = Mass;
		}
	}


	public double getTimeOfBurn() {return timeOfBurn;}
	public void setTimeOfBurn(double BurnTime) {
		if(BurnTime<0) {
			timeOfBurn = 0;
		}else {
			timeOfBurn = BurnTime;
		}
	}


	public void addInfo(Simulation_Motta sim)
	{
		if (sim != null) {
			SimInfo.add(sim);
		}
	}

}