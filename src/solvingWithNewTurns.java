
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
		boolean correct = false;
		while(!correct) {
			if(atP5[1][0][1] == atP5[1][2][1] && atP5[2][0][1] == atP5[2][2][1] && atP5[3][0][1] == atP5[3][2][1] && atP5[4][0][1] == atP5[4][2][1]){
				correct = true;
			}
			else if(atP5[1][0][1] == atP5[2][2][1] && atP5[2][0][1] == atP5[1][2][1]) { // 2 next to one another swapped
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
			}
			else if(atP5[1][0][1] == atP5[4][2][1] && atP5[4][0][1] == atP5[1][2][1]) { // across from one another swapped
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//turnCube(false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the cube clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
			}
			//turnCube(false);
		}//end while
		return atP5;	
	}//end p5
	public char[][][] part6(char[][][] atP6){//part 6, position yellow corners
		boolean correct = false;
		while(!correct) {
			if(!(atP6[1][0][2] == atP6[1][1][1] && atP6[3][0][0] == atP6[3][1][1])) { //if none are in right spot
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(2, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(2, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side clockwise"));

			}//end if has no corners
			//checks if 2 corners are in place, which means the whole cube is correct, bc the only possible permutations are 0, 1, or 4 done
			if((atP6[1][0][2] == atP6[1][1][1] && atP6[3][0][0] == atP6[3][1][1]) && (atP6[2][0][0] == atP6[2][1][1] && atP6[4][0][2] == atP6[4][1][1])) {
				correct = true;
			}//end if has all sides
			else if(atP6[1][0][2] == atP6[1][1][1] && atP6[3][0][0] == atP6[3][1][1]) { // has 1 corner in correct spot, may need to be revisited im not sure if
				//its possible for the thing to be in the correct 'spot but not oriented correctly. may need another method or 2, possible bigger if.
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(2, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side counter clockwise"));
				//rotate(0, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(0, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
				//rotate(2, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side clockwise"));

			}//end if 1 corner
			
		}// end if !correct
		return atP6;
		}// end part 6
	
	public char[][][] part7(char[][][] atP7){//part 7 orient yellow corners
		boolean cubeComplete = false;
		//turnCube(false);
		//turnCube(false);
		while(!cubeComplete) {
			if((atP7[1][0][2] == atP7[1][1][1] && atP7[3][0][0] == atP7[3][1][1]) &&
				(atP7[2][0][2] == atP7[2][1][1] && atP7[1][0][0] == atP7[1][1][1]) &&
				(atP7[4][0][2] == atP7[4][1][1] && atP7[2][0][0] == atP7[2][1][1]) &&
				(atP7[3][0][2] == atP7[3][1][1] && atP7[4][0][0] == atP7[4][1][1])) {
				//if entirely complete
				cubeComplete = true;
			}
			else if((atP7[4][0][2] == atP7[4][1][1] && atP7[2][0][0] == atP7[2][1][1]) &&
			(atP7[3][0][2] == atP7[3][1][1] && atP7[4][0][0] == atP7[4][1][1])) {
				//2 corners complete
				if((atP7[1][0][0] == atP7[0][1][1]) && (atP7[1][0][2] == atP7[0][1][1])) {
					//2 missing corners with yellow facing forward on each 
					
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
						//break
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));

				}//end 2 with yellows both facing forward
				else{//if yellows not facing forward
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));

				} // end other missing 2
			} //end if 2 corners complete
			else if((atP7[4][0][2] == atP7[4][1][1] && atP7[2][0][0] == atP7[2][1][1]) && 
					(atP7[0][2][0] != atP7[0][1][1]) && 
					(atP7[0][2][2] != atP7[0][1][1]) &&
					(atP7[0][0][2] != atP7[0][1][1])) {
					//if 1 correct 3 incorrect
				//if it meets the specific requirements for 4x execution
				if((atP7[2][0][2] == atP7[0][1][1] && atP7[1][0][0] == atP7[2][1][1] && atP7[0][2][0] == atP7[1][1][1]) &&
				   (atP7[1][0][2] == atP7[0][1][1] && atP7[0][2][2] == atP7[3][1][1] && atP7[3][0][0] == atP7[1][1][1]) &&
				   (atP7[3][0][2] == atP7[0][1][1] && atP7[0][0][2] == atP7[4][1][1] && atP7[4][0][0] == atP7[3][0][0])) {
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				}//ends if special 3
				else {// if it doesnt meet the 4x solution standards
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(5, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(5, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
				
				}//end else 3
			}//end if 3 need master
			else if(1== 1) {
				//2 correct across from each other
			}// end need 2 across from one another
		
		
		}//end while !complete
		return atP7;
	}//end method part7

	}//end class


