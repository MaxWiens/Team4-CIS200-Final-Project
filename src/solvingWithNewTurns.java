
public class solvingWithNewTurns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void solve(char[][][] sides) {
		part3(sides);// find the second layer
		part4(sides);// find yellow cross, flip over, add method l
		part5(sides);// swap yellow edges
		part6(sides);// position yellow corners
		part7(sides);// orient yellow corners
	}
	
	public char[][][] part2(char[][][] atP2){//part 2
		boolean cw = false, lft = false, blt = false, rbt = false, frt = false;
		while(!lft || !blt || !rbt || !frt) {

		for(int i=0; i <4; i++) {
			while(!cw) { //checks if a white corner is showing white on top but is in the wrong place
				if(atP2[0][2][2] == atP2[0][1][1]) {
					if((atP2[3][0][0] == atP2[3][1][1]) && (atP2[1][0][2] == atP2[1][1][1])) { //checks if showing white and correct
						cw = true;
					}
					else { // if showing and incorrect, moves the block out of the spot
						//rotate(3, false);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
						//rotate(5, false);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
						//rotate(3, true);
						//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					}
				}
				else
					cw = true;
			} // end !cw loop, loops until there isnt an incorrect white, as one may have been replaced with another on first switch
			

				if(!lft) { //corner at left, front, top isnt correct
					if((atP2[0][2][0] == atP2[0][1][1]) && (atP2[1][0][0] == atP2[1][1][1]) && (atP2[2][0][2] == atP2[2][1][1])) { //checks if all 3 sides of the corner are correct
						lft = true;
					}
				}// end if !lft
				
				if(!blt) { //corner at left, back, top isnt correct
					if((atP2[0][0][0] == atP2[0][1][1]) && (atP2[4][0][2] == atP2[4][1][1]) && (atP2[2][0][2] == atP2[2][1][1])) { //checks if all 3 sides of the corner are correct
						blt = true;
					}
				}//end if !blt
				
				if(!rbt) { //corner at right, back, top isnt correct
					if((atP2[0][0][2] == atP2[0][1][1]) && (atP2[4][0][0] == atP2[4][1][1]) && (atP2[3][0][2] == atP2[3][1][1])) { //checks if all 3 sides of the corner are correct
						rbt = true;
					}
				}//end if !rbt
				
				if(!frt) { //corner at right, front, top isnt correct
					if((atP2[0][2][2] == atP2[0][1][1]) && (atP2[3][0][0] == atP2[3][1][1]) && (atP2[1][0][2] == atP2[1][1][1])) { //checks if all 3 sides of the corner are correct
						frt = true;
					}
				}//end if !frt
				
			if(atP2[3][2][0] == atP2[0][1][1] && (atP2[1][2][2] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[5][0][2])) {
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
			
			}
			if(atP2[1][2][2] == atP2[0][1][1] && (atP2[5][0][2] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[3][2][0])) {
				//rotate(1, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(1, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the front Side counter clockwise"));
			}
			if(atP2[5][0][2] == atP2[0][1][1] && (atP2[3][2][0] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[1][2][2])) {
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
			}
			if(atP2[1][0][2] == atP2[0][1][1] && (atP2[1][1][1] == atP2[3][0][0]) && (atP2[0][2][2] == atP2[3][1][1])) {
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
			}
			if(atP2[3][0][0] == atP2[0][1][1] && (atP2[1][1][1] == atP2[0][2][2]) && (atP2[1][2][0] == atP2[3][1][1])) {
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(5, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
				//rotate(5, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the bottom Side counter clockwise"));
				//rotate(3, true);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
				//rotate(3, false);
				//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
			
			}
			//turnCube(false);
			cw = false;
		}//end for

		
		}//end while != all 
		
		while(atP2[1][0][1] != atP2[1][1][1]) { //sets the front color back to red for consistency 
			//rotate(0, true);
			//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
		}
		
	return atP2;
	}
	
	public char[][][] part3(char[][][] atP3){
		//turnCube(true);
		//turnCube(true);
		boolean br = false, rg = false, go = false, ob = false;
		while(!br || !rg || !go || !ob) {
			if(atP3[1][1][0] == atP3[1][1][1] && atP3[2][1][2] == atP3[2][1][1]) {
				rg = true;
			}
			if(atP3[4][1][2] == atP3[4][1][1] && atP3[2][1][1] == atP3[2][1][0]) {
				go = true;
			}
			if(atP3[4][1][0] == atP3[4][1][1] && atP3[3][1][2] == atP3[3][1][1]) {
				ob = true;
			}
			if(atP3[1][1][2] == atP3[1][1][1] && atP3[3][1][0] == atP3[3][1][1]) {
				br = true;
			}
			
			if(atP3[1][1][2] != atP3[1][1][1] || atP3[3][1][0] != atP3[3][1][1]) { // if the second layer isnt already correct he
				if(atP3[1][1][2] == atP3[3][1][1] && atP3[3][1][0] == atP3[1][1][1]) {//if it is in the right spot but opposite of one another
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(1, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side counter clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(1, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(1, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side counter clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(1, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side clockwise"));

				}
				else if(atP3[1][0][1] == atP3[1][1][1] && atP3[0][2][1] == atP3[2][1][1]) { //left algorithm
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(2, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side counter clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(2, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the left Side clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(1, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(1, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side counter clockwise"));
					
				}
				else if(atP3[1][0][1] == atP3[1][1][1] && atP3[0][2][1] == atP3[3][1][1]) { // right algorithm
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(3, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(3, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the right Side counter clockwise"));
					//rotate(0, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side counter clockwise"));
					//rotate(1, false);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side counter clockwise"));
					//rotate(0, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the top Side clockwise"));
					//rotate(1, true);
					//instructions.add(new SolveInstruction(copyState(sides), "Turn the front side clockwise"));
				}
			}
			//turnHorizontal(0 true);
		}//end while ! all
		
		
		return atP3;// part3, finding second layer 
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
			//turnCube(false);
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
			}//end complete check
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
			else if(((atP7[1][0][2] == atP7[1][1][1] && atP7[3][0][0] == atP7[3][1][1]) &&
					(atP7[4][0][2] == atP7[4][1][1] && atP7[2][0][0] == atP7[2][1][1])) &&
					(atP7[0][2][0] != atP7[0][1][1]) && (atP7[0][0][2] != atP7[0][1][1])) {
				//2 correct across from each other
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
			
			}// end need 2 across from one another
		//turnCube(false);
		
		}//end while !complete
		return atP7;
	}//end method part7

	}//end class


