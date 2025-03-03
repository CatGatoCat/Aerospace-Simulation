/***********************************
 * Filename: RoverSimulation_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 3/20/2024
 * Modified: 3/28/2024
 * Purpose: The child class for Simulation_Motta, called when Rover Launch Simulation is called
 *
 *
 * Attributes:
 * - LoadCurrent: double
 * - length: double
 * - batteryCap: double
 * - sim:Sim_Info_Motta
 *
 * Methods:
 * +<<constructor>> RoverSimulation_Motta(Sim_Info_Motta)
 * +toString(): String
 * +MaxVel(): void
 * -Battery(): double
 ***********************************/

public class RoverSimulation_Motta extends Simulation_Motta{
	
	//111855/12.6	
	private static double loadCurrent = 8877.38;
	
	private double length;
	private double batteryCap;
	private Sim_Info_Motta sim;	

	
	public RoverSimulation_Motta(Sim_Info_Motta sim)
	{
		super(2,sim);
		this.length = sim.getLengDia();
	    this.batteryCap = sim.getWidtAstBat();
	    this.sim = sim;
	}
	
	@Override
	public void MaxVel()
	{
		
		double MaxVel = sim.getVelExhaust()*Math.log(sim.getMass()*length)- gravity*sim.getTimeOfBurn();
		
		setMaxSpeed(MaxVel);
	}

	private double Battery()
	{
		double batteryLife = batteryCap/loadCurrent;
		return batteryLife;
	}
	
	public String toString()
	{
		MaxVel();
		/*Overrides the toString() method in Simulation_Motta class
		 * Returns the printed out values gotten
		 * */
		return super.toString() + "\nBattery Capacity = " + Battery() + "\n";
	
	}
}
