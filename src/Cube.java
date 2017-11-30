import java.util.ArrayList;

public class Cube {
	private char [][][] sides;
	private ArrayList<SolveInstruction> instructions;
	private int currentStep;
	
	public Cube() {
		instructions = new ArrayList<SolveInstruction>(1);
		instructions.add(new SolveInstruction());
	}
	public void solve() {}
	public void scramble() {}
	public SolveInstruction getStep(int stepIndex) {
		return instructions.get(stepIndex);
	}
	public SolveInstruction getNextStep() {
		return instructions.get(++currentStep);
	}
	public SolveInstruction getPreviousStep() {
		return instructions.get(--currentStep);
	}
	
	public int getTotalSteps() {
		return instructions.size();
	}
}
