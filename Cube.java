import java.util.*;
public class Cube {
	private char[][][] sides;
	private ArrayList <SolveInstruction> Instructions = new ArrayList <> ();
	private int currentStep;
	
	/** (this method scrambles the cube so it can be solved)
	 */ 
	public void scramble()
	{
		boolean clockwise = true;
		Random ran = new Random();
		int tv = ran.nextInt(50)+25; //finds random number for amount of turns for turning vertical
		int th = ran.nextInt(50)+25; //finds random number for amount of turns for turning horizontal
		turnVertical(tv, clockwise);
		turnHorizontal(th, clockwise);

	}
	
	/** (this method gets the instruction at passed in index)
	* @param (passes in a index for the instructions)
	* @return (a set instruction at set index)
	 */ 
	public SolveInstruction getStep(int stepIndex)
	{
		int index = stepIndex;
		return Instructions.get[index];
	}
	
	/** (this method determines whether there is a next step (if the cube solved) and increments the currentStep variable)
	* @return (returns solveInstructions.get(currentStep))
	 */ 
	public SolveInstruction nextStep()
	{
		currentStep++;
		return Instructions.get[currentStep];
	}
	
	/** (this method checks if there is a previous step before currentStep, decrements the currentStep variable)
	* @return (returns solveInstructions[currentStep])
	 */ 
	public SolveInstruction previousStep()
	{
		if currentStep > 0
		{
			currentStep--;
		}
		return Instructions[currentStep];
	}
	
	/** (this method returns the face value at a certain index)
	* @param (passes in an index value)
	* @return (a char[][] face index)
	 */ 
	public char[][] getFace(int index)
	{
		return sides[index][index][index];
	}
}