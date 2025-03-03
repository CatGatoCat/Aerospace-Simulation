/***********************************
 * Filename: SatelliteSimulation_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 3/20/2024
 * Modified: 4/21/2024
 * Purpose: The child class for Simulation_Motta, called when Satellite Launch Simulation is called
 *
 *
 * Attributes:
 * - length: double
 * - width: double
 * - sim: Sim_Info_Motta
 *
 * Methods:
 * +<<constructor>> SatelliteSimulation_Motta(Sim_Info_Motta)
 * +MaxVel(): void
 * +toString(): String
 ***********************************/


public class SatelliteSimulation_Motta extends Simulation_Motta{

	//parameters
	private double length;
	private double width;
	private Sim_Info_Motta sim;
	
	public SatelliteSimulation_Motta(Sim_Info_Motta sim)
	{
		/*Constructor for the SatelliteLaunch_Motta child class
		 * */
		super(1, sim);
		this.length = sim.getLengDia();
		this.width = sim.getWidtAstBat();
		this.sim = sim;
		
		
		
	}
	
	@Override
	public void MaxVel()
	{
		/*Overrides the MaxVel() method in Simulation_Motta class
		 * Returns the maximum Velocity achieved during the mission
		 * */
		double maxVel = 0;
		double dim =length*width;
		
		maxVel = (sim.getVelExhaust()*Math.log(sim.getMass()*dim) - gravity*sim.getTimeOfBurn());
		
		setMaxSpeed(maxVel);
	}
	
	public String toString()
	{
		MaxVel();
		return super.toString() + "\n";
	}

}
