
public class solvingWithNewTurns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void solve(char[][][] sides) {
		part4(sides);//flip over, add method l
		
	}
	
	public char[][][] part4(char[][][] atP4){// part4, finding yellow cross 
		boolean yellowcross = false;
	
		while(!yellowcross) {
			if(atP4[1][0][1] == 'Y' && atP4[2][0][1] == 'Y' && atP4[3][0][1] == 'Y' &&atP4[4][0][1] == 'Y') {
				//rotate(1, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(1, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side counter clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//rotate(1, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(1, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side counter clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//rotate(1, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(1, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side counter clockwise"));
				yellowcross = true;
			}
			else {
				for(int i =0; i<4; i++) {
					if(atP4[1][0][1] == 'Y' && atP4[3][0][1] == 'Y') {
						//rotate(1, true);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side clockwise"));
						//rotate(0, true);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
						//rotate(3, true);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
						//rotate(0, false);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
						//rotate(3, false);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
						//rotate(1, false);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side counter clockwise"));
						yellowcross = true;
					}
					else {
						//turnCube(false);
					}
				}
			}
		}
		return atP4; 
	}// end part 4 finding yellow cross
	public char[][][] part5(char[][][] atP5){//part5, 
		
		return atP5;	
	}
}
