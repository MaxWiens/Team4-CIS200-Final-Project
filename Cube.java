import java.util.*;
public class Cube {
	private char[][][] sides;
	private ArrayList <SolveInstruction> Instructions = new ArrayList <> ();
	private int currentStep;
	
	/** (this method scrambles the cube so it can be solved)
	 */ 
	public void scramble()
	{
		//Scrambles the cube, Could possibly randomly turn random size for a range of time
		//rnHorizontal(int horizontalIndex, boolean isClockWise)optional 
		//-turnVerticial(int verticialIndex) optional
		//-turnVerticial(int verticialIndex, boolean isClockWise) optional
		Random ran = new Random();
		int tv = ran.nextInt(50)+1; //finds random number for amount of turns for turning verticle
		int th = ran.nextInt(50)+1; //finds random number for amount of turns for turning horizontal
		for(int i = 0; i < tv; i++)
		{
			//call turnVertical
		}
		for(int i = 0; i < th; i++)
		{
			//call turnHorizontal
		}

	}
	
	/** (this method gets the instruction at passed in index)
	* @param (passes in a index for the instructions)
	* @return (a set instruction at set index)
	 */ 
	public SolveInstruction getStep(int stepIndex)
	{
		//returns the SolveInstruction at the stepIndex
		int index = stepIndex;
		return SolveInstruction.get[index];
	}
	
	/** (this method determines whether there is a next step (if the cube solved) and increments the currentStep variable)
	* @return (returns solveInstructions.get(currentStep))
	 */ 
	public SolveInstruction nextStep()
	{
		//needs to see if the cube is solved or if there is a next step;
		//checks if there is a next step after currentStep, increments the currentStep variable
		//then returns solveInstructions.get(currentStep)
		currentStep++;
		return solveInstruction.get[currentStep];
	}
	
	/** (this method checks if there is a previous step before currentStep, decrements the currentStep variable)
	* @return (returns solveInstructions[currentStep])
	 */ 
	public SolveInstruction previousStep()
	{
		// check if there is a previous step before currentStep, decrements the currentStep variable
		//then returns solveInstructions[currentStep]
		return solveInstructions[currentStep];
	}
	
	/** (this method returns the face value at a certain index)
	* @param (passes in an index value)
	* @return (a char[][] face index)
	 */ 
	public char[][] getFace(int index)
	{
		char[][] faceIndex = new char [index][index];
		returns faceIndex;
	}
}