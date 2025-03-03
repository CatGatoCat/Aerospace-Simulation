/***********************************
 * Filename: AircraftSimulation_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 3/20/2024
 * Modified: 3/28/2024
 * Purpose: The child class for Simulation_Motta, called when Rover Aircraft Simulation is called
 *
 *
 * Attributes:
 * - OxygenPerPerson: double
 * - ratio: double
 * - astronauts: int
 * - sim:Sim_Info_Motta
 *
 * Methods:
 * +<<constructor>> AircraftSimulation_Motta(Sim_Info_Motta)
 * +toString(): String
 * +MaxVel(): void
 * -OxygenNeeded(): double
 ***********************************/

public class AircraftSimulation_Motta extends Simulation_Motta{

	private static double OxygenPerPerson = 0.0000972;


	private double ratio;
	private int astronauts;
	private Sim_Info_Motta sim;


	public AircraftSimulation_Motta(Sim_Info_Motta sim)
	{
		super(3,sim);
		ratio = 0;
		astronauts = 0;
		this.sim = sim;
	}

	@Override
	public void MaxVel()
	{
		double MaxVel = 0;
		ratio = sim.getLengDia()/2;
		
		MaxVel = (getVelExhaust2()*Math.log(getMass2()*ratio))- (gravity*getTimeOfBurn2());

		setMaxSpeed(MaxVel);


	}


	private double OxygenNeeded()
	{
		//0.035 kg (0.077 pounds) per human/hour // 0.035 kg per 1 human/ 3600 sec
		// 0.035 kg hum |   l..
		// 3600 sec     |

		double Oxygen = 0;
		astronauts = (int)sim.getWidtAstBat();


		if(getTotalTime() != 0) {
			Oxygen = (OxygenPerPerson*astronauts)/getTotalTime();
		}		
		return Oxygen;
	}
		
	public String toString()
	{
		MaxVel();
		/*Overrides the toString() method in Simulation_Motta class
		 * Returns the printed out values gotten
		 * */
		return super.toString() + "\nOxygen needed = " + OxygenNeeded() + "\n";
	}



	
}
