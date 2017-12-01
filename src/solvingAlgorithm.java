
public class solvingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solve(cube);
	}
	public solvingAlgorithm(char[][] qtFace, char[][] qfFace, char[][] qlFace, char[][] qrFace, char[][] qbFace, char[][] qdFace) {
		char[][][] tc = new char[6][3][3];
		
		char[][] tFace = {{'R','Y','G'},
						  {'O','W','G'},
						  {'O','W','G'}};
		
		char[][] fFace = {{'G','R','R'},
						  {'R','R','B'},
						  {'Y','G','Y'}};
		
		char[][] lFace = {{'Y','W','Y'},
						  {'R','G','Y'},
						  {'W','B','B'}};
		
		char[][] rFace = {{'W','R','W'},
						  {'Y','B','G'},
						  {'B','O','W'}};
		
		char[][] bFace = {{'O','O','G'},
						  {'Y','O','B'},
						  {'B','B','B'}};
		
		char[][] dFace = {{'R','W','O'},
					  	  {'W','Y','G'},
					  	  {'O','O','R'}};
		
	}
	public void solve(char[][][] cube){
		part1(cube); // finding the white +
		part2(cube); // finding white corners
		part3(cube); // finding the second layers
		part4(cube); // finding the yellow cross
	}
	
	//part 1, finding the white plus
	public char[][][] part1(char[][][] atP1){
		boolean fw = false, bw = false, lw = false, rw = false;
		if(atP1[5][0][1] == 'W'){ //if the front-top plus square is on the bottom, flips it to the top
			//turnFace(0, true);
			//turnFace(0, true);
			fw = true;
		}
		if(atP1[5][2][1] == 'W'){ //if the back-top plus square is on the bottom, flips it to the top
			//turnFace(1, true);
			//turnFace(1, true);
			bw = true;
		}
		if(atP1[5][1][0] == 'W'){//if the left-top plus square is on the bottom, flips it to the top
			//turnVertical(0, true);
			//turnVertical(0, true);
			lw = true;
		}
		if(atP1[5][1][2] == 'W'){ //if the right-top plus square is on the bottom, flips it to the top
			//turnVertical(2, true);
			//turnVertical(2, true);
			rw = true;
		}
		while(!fw || !bw || !lw || !rw) { //while a section of the plus isnt white
			
			while(!fw) { //while the piece in front isnt white 
				if(atP1[0][2][1] == ('W')) // if the piece is white, makes bool true
					fw = true;
				else if(atP1[1][0][1] == 'W') { //top
					//turnFace(0, true);
					//turnVertical(2, false); // verts seem to mirror
					//turnHorizontal(2, true); //horiz seem to stay the same
					//turnVertical(2, true);
					//turnFace(0, true);
					//turnFace(0, true);
					fw = true;
				}
				else if(atP1[1][1][0] == 'W') { //left
					//turnFace(0, false);
					//turnFace(0, false);
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnFace(0, true);
					//turnFace(0, true);
					fw = true;
				}
				else if(atP1[1][1][2] == 'W') { //right
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnFace(0, true);
					//turnFace(0, true);
					fw = true;	
				}
				else if(atP1[1][2][1] == 'W') { //bottom
					//turnFace(0, false);
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnFace(0, true);
					//turnFace(0, true);
					fw = true;
				}
				
					
			}//end while !fw
			
			while(!bw) { // while piece between top and back is not white
				if(atP1[0][0][1] == ('W')) // if the piece is white, makes bool true
					bw = true;
				else if(atP1[4][0][1] == 'W') { // top
					//turnFace(1, false);
					//turnVertical(0, true);
					//turnHorizontal(2, true);
					//turnVertical(0, false);
					//turnFace(1, true);
					//turnFace(1, true);
					bw = true;
				}
				else if(atP1[4][1][0] == 'W') {	//left
					//turnFace(1, false);
					//turnFace(1, false);
					//turnVertical(2, false);
					//turnHorizontal(0, true);
					//turnVertical(2, true);
					//turnFace(1, true);
					//turnFace(1, true);
					bw = true;
				}
				else if(atP1[4][1][2] == 'W') { //right
					//turnVertical(2, false);
					//turnHorizontal(0, true);
					//turnVertical(2, true);
					//turnFace(1, true);
					//turnFace(1, true);
					bw = true;	
				}
				else if(atP1[4][2][1] == 'W') { //bottom
					//turnFace(0, false);
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnFace(0, true);
					//turnFace(0, true);
					bw = true;
				}
			} //end of while !bw
			while(!lw) { // top face left square of plus
				if(atP1[0][1][0] == ('W')) // if the piece is white, makes bool true
					lw = true;
				else if(atP1[2][0][1] == 'W') { //top
					//turnVertical(0, true);
					//turnFace(0, false); 
					//turnHorizontal(2, true); 
					//turnFace(0, true);
					//turnVertical(0, true);
					//turnVertical(0, true);
					lw = true;
				}
				else if(atP1[2][1][0] == 'W') { //left
					//turnVertical(0, true);
					//turnVertical(0, true);
					//turnFace(0, false); 
					//turnHorizontal(2, true); 
					//turnFace(0, true);
					//turnVertical(0, true);
					//turnVertical(0, true);
					lw = true;
				}
				else if(atP1[2][1][2] == 'W') { //right
					//turnFace(0, false); 
					//turnHorizontal(2, true); 
					//turnFace(0, true);
					//turnVertical(0, true);
					//turnVertical(0, true);
					lw = true;	
				}
				else if(atP1[2][2][1] == 'W') { //bottom
					//turnVertical(0, false);
					//turnFace(0, false); 
					//turnHorizontal(2, true); 
					//turnFace(0, true);
					//turnVertical(0, true);
					//turnVertical(0, true);
					lw = true;
				}
			}//end while !lw
			while(!rw) {
				if(atP1[0][1][2] == ('W')) // if the piece is white, makes bool true
					rw = true;
				else if(atP1[3][0][1] == 'W') { //top
					//turnVertical(2, false);
					//turnFace(1, true); 
					//turnHorizontal(2, true);
					//turnFace(1, false);
					//turnVertical(2, true);
					//turnVertical(2, true);
					rw = true;
				}
				else if(atP1[3][1][0] == 'W') { //left
					//turnVertical(2, false);
					//turnVertical(2, false);
					//turnFace(1, true); 
					//turnHorizontal(2, true);
					//turnFace(1, false);
					//turnVertical(2, true);
					//turnVertical(2, true);
					rw = true;
				}
				else if(atP1[3][1][2] == 'W') { //right
					//turnFace(1, true); 
					//turnHorizontal(2, true);
					//turnFace(1, false);
					//turnVertical(2, true);
					//turnVertical(2, true);
					rw = true;
				}
				else if(atP1[3][2][1] == 'W') { //bottom
					//turnVertical(2, true);
					//turnFace(1, true); 
					//turnHorizontal(2, true);
					//turnFace(1, false);
					//turnVertical(2, true);
					//turnVertical(2, true);
					rw = true;
				}
			}//end while !rw
			
		}//end while any !=
		while(atP1[1][0][1] != 'R') { //sets the front color back to red for consistency 
			//turnHorizontal(0, true);
		}
		while(atP1[1][0][1] != atP1[1][1][1]) { //sets the middle of each side equal to the top middle of each side
			//turnHorizontal(1, true);
		}
		return atP1;
	}//end part 1
	
	public char[][][] part2(char[][][] atP2){ // part2, finding white corners
			boolean cw = false, lft = false, blt = false, rbt = false, frt = false;
			while(!lft || !blt || !rbt || !frt) {

			for(int i=0; i <4; i++) {
				while(!cw) { //checks if a white corner is showing white on top but is in the wrong place
					if(atP2[0][2][2] == 'W') {
						if((atP2[3][0][0] == atP2[3][1][1]) && (atP2[1][0][2] == atP2[1][1][1])) { //checks if showing white and correct
							cw = true;
						}
						else { // if showing and incorrect, moves the block out of the spot
							//turnVertical(2, false);
							//turnHorizontal(2, false);
							//turnVertical(2, true);
						}
					}
					else
						cw = true;
				} // end !cw loop, loops until there isnt an incorrect white, as one may have been replaced with another on first switch
				

					if(!lft) { //corner at left, front, top isnt correct
						if((atP2[0][2][0] == 'W') && (atP2[1][0][0] == atP2[1][1][1]) && (atP2[2][0][2] == atP2[2][1][1])) { //checks if all 3 sides of the corner are correct
							lft = true;
						}
					}// end if !lft
					
					if(!blt) { //corner at left, back, top isnt correct
						if((atP2[0][0][0] == 'W') && (atP2[4][0][2] == atP2[4][1][1]) && (atP2[2][0][2] == atP2[2][1][1])) { //checks if all 3 sides of the corner are correct
							blt = true;
						}
					}//end if !blt
					
					if(!rbt) { //corner at right, back, top isnt correct
						if((atP2[0][0][2] == 'W') && (atP2[4][0][0] == atP2[4][1][1]) && (atP2[3][0][2] == atP2[3][1][1])) { //checks if all 3 sides of the corner are correct
							rbt = true;
						}
					}//end if !rbt
					
					if(!frt) { //corner at right, front, top isnt correct
						if((atP2[0][2][2] == 'W') && (atP2[3][0][0] == atP2[3][1][1]) && (atP2[1][0][2] == atP2[1][1][1])) { //checks if all 3 sides of the corner are correct
							frt = true;
						}
					}//end if !frt
					
				if(atP2[3][2][0] == 'W' && (atP2[1][2][2] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[5][0][2])) {
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
				}
				if(atP2[1][2][2] == 'W' && (atP2[5][0][2] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[3][2][0])) {
					//turnFace(0, true);
					//turnHorizontal(2, true);
					//turnFace(0, false);
				}
				if(atP2[5][0][2] == 'W' && (atP2[3][2][0] == atP2[1][1][1]) && (atP2[3][1][1] == atP2[1][2][2])) {
					//turnVertical(2, false);
			 		//turnHorizontal(2, true);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
				}
				if(atP2[1][0][2] == 'W' && (atP2[1][1][1] == atP2[3][0][0]) && (atP2[0][2][2] == atP2[3][1][1])) {
					//turnVertical(2, false);
					//turnHorizontal(2, false);
					//turnVertical(2, true);
					//turnHorizontal(2, true);
					//turnVertical(2, false);
					//turnHorizontal(2, false);
					//turnVertical(2, true);
					//turnHorizontal(2, true);
				}
				if(atP2[3][0][0] == 'W' && (atP2[1][1][1] == atP2[0][2][2]) && (atP2[1][2][0] == atP2[3][1][1])) {
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnHorizontal(2, false);
					//turnVertical(2, false);
					//turnHorizontal(2, true);
					//turnVertical(2, true);
					//turnHorizontal(2, false);
				}
				//turnHorizontal(0, true);
				//turnHorizontal(1, true);
				//turnHorizontal(2, true);
				cw = false;
			}//end for

			
			}//end while != all 
			
			while(atP2[1][0][1] != 'R') { //sets the front color back to red for consistency 
				//turnHorizontal(0, true);
			}
			while(atP2[1][0][1] != atP2[1][1][1]) { //sets the middle of each side equal to the top middle of each side
				//turnHorizontal(1, true);
			}
		return atP2;

}
	public char[][][] part3(char[][][] atP3){
		//turnVertical(0, true);
		//turnVertical(0, true);
		//turnVertical(1, true);
		//turnVertical(1, true);
		//turnVertical(2, true);
		//turnVertical(2, true);

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
					//turnHorizontal(0, true);
					//turnVertical(2, false);
					//turnHorizontal(0, false);
					//turnVertical(2, true);
					//turnHorizontal(0, false);
					//turnFace(0, false);
					//turnHorizontal(0, true);
					//turnFace(0, true);
					//turnHorizontal(0, false);
					//turnVertical(2, false);
					//turnHorizontal(0, false);
					//turnVertical(2, true);
					//turnHorizontal(0, false);
					//turnFace(0, false);
					//turnHorizontal(0, true);
					//turnFace(0, true);
				}
				else if(atP3[1][0][1] == atP3[1][1][1] && atP3[0][2][1] == atP3[2][1][1]) { //left algorithm
					//turnHorizontal(0, false);
					//turnVertical(0, true);
					//turnHorizontal(0, true);
					//turnVertical(0, false);
					//turnHorizontal(0, true);
					//turnFace(0, true);
					//turnHorizontal(0, false);
					//turnFace(0, false);
				}
				else if(atP3[1][0][1] == atP3[1][1][1] && atP3[0][2][1] == atP3[3][1][1]) { // right algorithm
					//turnHorizontal(0, true);
					//turnVertical(2, false);
					//turnHorizontal(0, false);
					//turnVertical(2, true);
					//turnHorizontal(0, false);
					//turnFace(0, false);
					//turnHorizontal(0, true);
					//turnFace(0, true);
				}
			}
			//turnHorizontal(0 true);
		}//end while ! all
		
		
		return atP3;
}//end part 3
	public char[][][] part4(char[][][] atP4){// part4, finding the second layer 
		
		
		return atP4; 
	}

}//end class 
