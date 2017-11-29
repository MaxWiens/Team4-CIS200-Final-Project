
public class Cube {

/*[side][row][column]
 * [side]:
 * * 0=top
 * * 1=front
 * * 2=left
 * * 3=right
 * * 4=back
 * * 5=bottom
 * 
 * [row]:
 * * 0=top
 * * 1=middle
 * * 2=bottom
 * 
 * [column]:
 * * 0=left
 * * 1=center
 * * 2=right
 */
 //turnVertical: true=forward(front --> bottom), false=backward
private char[][][] sides;

//Returns a copy of the cube's current state
private char[][][] copyState(char[][][] original){
	char[][][] copy = new char[6][3][3];
	for (int a = 0; a<6; a++){
		for (int b=0; b<3; b++){
			for (int c=0; c<3; c++){
				copy[a][b][c] = original[a][b][c];
			}
		}
	}
	return copy;
}

//True rotates the top of the cube clockwise, false rotates it counterclockwise
public void turnHorizontal(int horizontalIndex, boolean isClockWise){
	char[][][] copy = copyState(sides);
	//TOP CW
	if (horizontalIndex==0 && isClockWise){
		//change top
		copy[0][0][0] = sides[0][2][0];
		copy[0][0][1] = sides[0][1][0];
		copy[0][0][2] = sides[0][0][0];
		copy[0][1][0] = sides[0][2][1];
		copy[0][1][2] = sides[0][0][1];
		copy[0][2][0] = sides[0][2][2];
		copy[0][2][1] = sides[0][1][2];
		copy[0][2][2] = sides[0][0][2];
		//change front
		copy[1][0][0] = sides[3][0][0];
		copy[1][0][1] = sides[3][0][1];
		copy[1][0][2] = sides[3][0][2];
		//change left
		copy[2][0][0] = sides[1][0][0];
		copy[2][0][1] = sides[1][0][1];
		copy[2][0][2] = sides[1][0][2];
		//change right
		copy[3][0][0] = sides[4][0][0];
		copy[3][0][1] = sides[4][0][1];
		copy[3][0][2] = sides[4][0][2];
		//change back
		copy[4][0][0] = sides[2][0][0];
		copy[4][0][1] = sides[2][0][1];
		copy[4][0][2] = sides[2][0][2];	
	}
	//TOP CCW
	else if (horizontalIndex==0){
		//change top
		copy[0][0][0] = sides[0][0][2];
		copy[0][0][1] = sides[0][1][2];
		copy[0][0][2] = sides[0][2][2];
		copy[0][1][0] = sides[0][0][1];
		copy[0][1][2] = sides[0][2][1];
		copy[0][2][0] = sides[0][0][0];
		copy[0][2][1] = sides[0][1][0];
		copy[0][2][2] = sides[0][2][0];
		//change front
		copy[1][0][0] = sides[2][0][0];
		copy[1][0][1] = sides[2][0][1];
		copy[1][0][2] = sides[2][0][2];
		//change left
		copy[2][0][0] = sides[4][0][0];
		copy[2][0][1] = sides[4][0][1];
		copy[2][0][2] = sides[4][0][2];
		//change right
		copy[3][0][0] = sides[1][0][0];
		copy[3][0][1] = sides[1][0][1];
		copy[3][0][2] = sides[1][0][2];
		//change back
		copy[4][0][0] = sides[3][0][0];
		copy[4][0][1] = sides[3][0][1];
		copy[4][0][2] = sides[3][0][2];
	}
	//MIDDLE CW
	else if (horizontalIndex==1 && isClockWise){
		//change front
		copy[1][1][0] = sides[3][0][0];
		copy[1][1][1] = sides[3][0][1];
		copy[1][1][2] = sides[3][0][2];
		//change left
		copy[2][1][0] = sides[1][0][0];
		copy[2][1][1] = sides[1][0][1];
		copy[2][1][2] = sides[1][0][2];
		//change right
		copy[3][1][0] = sides[4][0][0];
		copy[3][1][1] = sides[4][0][1];
		copy[3][1][2] = sides[4][0][2];
		//change back
		copy[4][1][0] = sides[2][0][0];
		copy[4][1][1] = sides[2][0][1];
		copy[4][1][2] = sides[2][0][2];	
	}
	//MIDDLE CCW
	else if (horizontalIndex==1){
		//change front
		copy[1][1][0] = sides[2][0][0];
		copy[1][1][1] = sides[2][0][1];
		copy[1][1][2] = sides[2][0][2];
		//change left
		copy[2][1][0] = sides[4][0][0];
		copy[2][1][1] = sides[4][0][1];
		copy[2][1][2] = sides[4][0][2];
		//change right
		copy[3][1][0] = sides[1][0][0];
		copy[3][1][1] = sides[1][0][1];
		copy[3][1][2] = sides[1][0][2];
		//change back
		copy[4][1][0] = sides[3][0][0];
		copy[4][1][1] = sides[3][0][1];
		copy[4][1][2] = sides[3][0][2];
	}
	//BOTTOM CW
	else if (horizontalIndex==2 && isClockWise){
		//change bottom
		copy[5][0][0] = sides[5][2][0];
		copy[5][0][1] = sides[5][1][0];
		copy[5][0][2] = sides[5][0][0];
		copy[5][1][0] = sides[5][2][1];
		copy[5][1][2] = sides[5][0][1];
		copy[5][2][0] = sides[5][2][2];
		copy[5][2][1] = sides[5][1][2];
		copy[5][2][2] = sides[5][0][2];
		//change front
		copy[1][2][0] = sides[2][2][0];
		copy[1][2][1] = sides[2][2][1];
		copy[1][2][2] = sides[2][2][2];
		//change left
		copy[2][2][0] = sides[4][2][0];
		copy[2][2][1] = sides[4][2][1];
		copy[2][2][2] = sides[4][2][2];
		//change right
		copy[3][2][0] = sides[1][2][0];
		copy[3][2][1] = sides[1][2][1];
		copy[3][2][2] = sides[1][2][2];
		//change back
		copy[4][2][0] = sides[3][2][0];
		copy[4][2][1] = sides[3][2][1];
		copy[4][2][2] = sides[3][2][2];	
	}
	//BOTTOM CCW
	else{
		//change bottom
		copy[5][0][0] = sides[5][0][2];
		copy[5][0][1] = sides[5][1][2];
		copy[5][0][2] = sides[5][2][2];
		copy[5][1][0] = sides[5][0][1];
		copy[5][1][2] = sides[5][2][1];
		copy[5][2][0] = sides[5][0][0];
		copy[5][2][1] = sides[5][1][0];
		copy[5][2][2] = sides[5][2][0];
		//change front
		copy[1][2][0] = sides[3][2][0];
		copy[1][2][1] = sides[3][2][1];
		copy[1][2][2] = sides[3][2][2];
		//change left
		copy[2][2][0] = sides[1][2][0];
		copy[2][2][1] = sides[1][2][1];
		copy[2][2][2] = sides[1][2][2];
		//change right
		copy[3][2][0] = sides[4][2][0];
		copy[3][2][1] = sides[4][2][1];
		copy[3][2][2] = sides[4][2][2];
		//change back
		copy[4][2][0] = sides[2][2][0];
		copy[4][2][1] = sides[2][2][1];
		copy[4][2][2] = sides[2][2][2];
	}
	sides = copyState(copy);
}//end rotateTop

}//end class
