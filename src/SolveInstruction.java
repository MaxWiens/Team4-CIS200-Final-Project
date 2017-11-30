
public class SolveInstruction {
	private char[][][] sides;
	private String instruction;
	
	public SolveInstruction() {
		instruction = "None";
		sides = new char[6][3][3];
	}
	
	public SolveInstruction (char[][][] sides, String message) {
		instruction = message;
		this.sides = sides;
	}
	
	public char[][][] getCube() {
		return sides;
	}
	public String getInstruction() {
		return instruction;
	}
	
}
