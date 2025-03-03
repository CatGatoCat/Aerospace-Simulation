/***********************************
 * Filename: MainDisplay_Motta
 * Author: Nicole Motta
 * Collaborators: Logan Luna, Laurel Grein, Anthony Fuentes
 * Created: 3/20/2024
 * Modified: 4/21/2024
 * Purpose: Contains the main() method to run the Simulation with inheritance
 *	implemented for the simulations.
 *
 * Attributes:
 * - SimData: ArrayList<Double>
 * -String: toStringMain
 *
 * Methods:
 * +main(String[]): void
 * -runSim(int, Sim_Info_Motta, MainDisplay_Motta, Scanner): void
 * +ChooseSim(Scanner, String): int
 * -readFromFile(String): ArrayList<String>
 * +parseDataFromFile(String, Sim_Info_Motta): boolean
 * -RunAgain(Scanner, String): int
 * -writeToFile(String): void
 ***********************************/

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MainDisplay_Motta {

	private ArrayList<Double> SimData = new ArrayList<Double>();
	private static String toStringMain;



	public static void main(String[] args) {
		MainDisplay_Motta main = new MainDisplay_Motta();

		Sim_Info_Motta simInfo = new Sim_Info_Motta();

		Scanner scan = new Scanner(System.in);

		int choose = 0;
		int ask;

		System.out.println("Welcome to the Aerospace Simulatior");

		while(true) {

			if(choose == 0) {
				choose = main.ChooseSim(scan, "Choose which simulation you want to run");
			}

			main.parseDataFromFile("Simulator_info.csv", simInfo);

			main.runSim(choose, simInfo, main, scan);

			ask = main.RunAgain(scan, "Do you want to run a simulation again? (Y/N) ");


			if (ask == 0) {
				break;
			} else if(ask ==2) {
				choose = 0;
			}

		}


	}


	private void runSim(int choose, Sim_Info_Motta simInfo, MainDisplay_Motta main, Scanner scan) {
		if(choose == 1)
		{
			SatelliteSimulation_Motta sat = new SatelliteSimulation_Motta(simInfo);
			toStringMain = sat.toString();
		}
		if(choose == 2) {
			RoverSimulation_Motta rov = new RoverSimulation_Motta(simInfo);
			toStringMain = rov.toString();
		}
		if(choose == 3) {
			AircraftSimulation_Motta air = new AircraftSimulation_Motta(simInfo);
			toStringMain = air.toString();
		}

		System.out.println("\n" + toStringMain + "\n");
		main.writeToFile("results.txt");
	}

	private int ChooseSim(Scanner scan, String prompt)
	{
		int choice;

		System.out.println("\n" + prompt + "\n");

		System.out.println("Satellite Launch: 1");
		System.out.println("Rover Launch: 2");
		System.out.println("Aircraft Launch: 3");


		while (true) {
			try {
				choice = scan.nextInt();
				scan.nextLine();
				if (choice == 1 || choice == 2 || choice == 3) {
					break;
				} else {
					System.out.println("Invalid choice, please enter 1, 2, or 3:");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please type in a number");
				scan.next();  // clear the invalid input
			}
		}




		return choice;
	}

	//read information from the file and put them in the arrayList
	private ArrayList<String> readFromFile(String filename) 
	{
		ArrayList<String> data = new ArrayList<>();
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);

			while(scan.hasNext()) {
				String line = scan.nextLine().trim();
				data.add(line);
			}

			scan.close();

		} catch(Exception e) {
			System.out.println("Exception occured while reading from file.");
			e.printStackTrace();
		}
		return data;

	}

	//check if there is more information 
	public boolean parseDataFromFile(String filename, Sim_Info_Motta simInfo) //throws FileNotFoundException
	{
		ArrayList<String> data = readFromFile(filename);
		if (data == null || data.isEmpty()) {
			return false;
		} 

		for (int i = 1; i < data.size(); i++) {
			System.out.println(data.get(i));
			String[] info = data.get(i).split(",");

			String label = info[0];
			double value = Double.parseDouble(info[1]);

			SimData.add(value);

			if(label.equalsIgnoreCase("mass")) {
				simInfo.setMass(value);
			}
			if(label.equalsIgnoreCase("Initial Fuel")) {
				simInfo.setFuel(value);
			}
			if(label.equalsIgnoreCase("Exhaust Velocity")) {
				simInfo.setVelExhaust(value);
			}
			if(label.equalsIgnoreCase("Time of Burn")) {
				simInfo.setTimeOfBurn(value);
			}
			if(label.equalsIgnoreCase("Initial Velocity")) {
				simInfo.setInitialVel(value);
			}
			if(label.equalsIgnoreCase("length") || label.equalsIgnoreCase("diameter")) {
				simInfo.setLengDia(value);
			}
			if(label.equalsIgnoreCase("width") || label.equalsIgnoreCase("Astronauts") || label.equalsIgnoreCase("Battery capacity")) {
				simInfo.setWidtAstBat(value);
			} 



		}

		return false;
	}

	//ask if the user wants to run a simulation again
	private int RunAgain(Scanner scan, String prompt)
	{
		int other = 0;

		System.out.println(prompt);

		String answer = scan.nextLine();


		if(answer.equalsIgnoreCase("Y")) {

			System.out.println("Do you wish to run the same one or another one? (Same/Another)");
			answer = scan.nextLine();

			if (answer.equalsIgnoreCase("Same")) {
				other = 1;
			} else if (answer.equalsIgnoreCase("Another")) {
				other = 2;
			}
		}else {

			System.out.println("Thank you for using the Aerospace Simulator!");
		}

		return other;

	}


	private void writeToFile(String filename) {
		try {
			FileWriter myWriter = new FileWriter("results.txt");
			myWriter.write(toStringMain);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
