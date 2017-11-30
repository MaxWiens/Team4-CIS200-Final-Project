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
private char[][][] sides;

//No-arg constructor initializes solved cube
public Cube(){
	sides = new char[6][3][3];
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[0][i][j] = 'W';
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[1][i][j] = 'R';
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[2][i][j] = 'G';
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[3][i][j] = 'B';
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[4][i][j] = 'O';
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<3; j++){
			sides[5][i][j] = 'Y';
		}
	}
}

public String toString(){
	String spaces = "    ";
	StringBuilder sb = new StringBuilder();
	sb.append(spaces);
	sb.append(sides[0][0][0]);
	sb.append(sides[0][0][1]);
	sb.append(sides[0][0][2]);
	sb.append("\n");
	sb.append(spaces);
	sb.append(sides[0][1][0]);
	sb.append(sides[0][1][1]);
	sb.append(sides[0][1][2]);
	sb.append("\n");
	sb.append(spaces);
	sb.append(sides[0][2][0]);
	sb.append(sides[0][2][1]);
	sb.append(sides[0][2][2]);
	sb.append("\n");
	sb.append(sides[2][0][0]);
	sb.append(sides[2][0][1]);
	sb.append(sides[2][0][2]);
	sb.append(" ");
	sb.append(sides[1][0][0]);
	sb.append(sides[1][0][1]);
	sb.append(sides[1][0][2]);
	sb.append(" ");
	sb.append(sides[3][0][0]);
	sb.append(sides[3][0][1]);
	sb.append(sides[3][0][2]);
	sb.append(" ");
	sb.append(sides[4][0][0]);
	sb.append(sides[4][0][1]);
	sb.append(sides[4][0][2]);
	sb.append("\n");
	sb.append(sides[2][1][0]);
	sb.append(sides[2][1][1]);
	sb.append(sides[2][1][2]);
	sb.append(" ");
	sb.append(sides[1][1][0]);
	sb.append(sides[1][1][1]);
	sb.append(sides[1][1][2]);
	sb.append(" ");
	sb.append(sides[3][1][0]);
	sb.append(sides[3][1][1]);
	sb.append(sides[3][1][2]);
	sb.append(" ");
	sb.append(sides[4][1][0]);
	sb.append(sides[4][1][1]);
	sb.append(sides[4][1][2]);
	sb.append("\n");
	sb.append(sides[2][2][0]);
	sb.append(sides[2][2][1]);
	sb.append(sides[2][2][2]);
	sb.append(" ");
	sb.append(sides[1][2][0]);
	sb.append(sides[1][2][1]);
	sb.append(sides[1][2][2]);
	sb.append(" ");
	sb.append(sides[3][2][0]);
	sb.append(sides[3][2][1]);
	sb.append(sides[3][2][2]);
	sb.append(" ");
	sb.append(sides[4][2][0]);
	sb.append(sides[4][2][1]);
	sb.append(sides[4][2][2]);
	sb.append("\n");
	sb.append(spaces);
	sb.append(sides[5][0][0]);
	sb.append(sides[5][0][1]);
	sb.append(sides[5][0][2]);
	sb.append("\n");
	sb.append(spaces);
	sb.append(sides[5][1][0]);
	sb.append(sides[5][1][1]);
	sb.append(sides[5][1][2]);
	sb.append("\n");
	sb.append(spaces);
	sb.append(sides[5][2][0]);
	sb.append(sides[5][2][1]);
	sb.append(sides[5][2][2]);
	
	return sb.toString();
}


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

//0=top, 1=middle, 2=bottom; true=clockwise, false=counterclockwise
//Rotates a horizontal section of the cube based on the parameters
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
}//end turnHorizontal


//0=left, 1=middle, 2=right; true=forward(front --> bottom), false=backward
//Rotates a horizontal section of the cube based on the parameters
public void turnVertical(int verticalIndex, boolean isForward){
	char[][][] copy = copyState(sides);
	//LEFT FORWARD
	if (verticalIndex==0 && isForward){
		//change left
		copy[2][0][0] = sides[2][2][0];
		copy[2][0][1] = sides[2][1][0];
		copy[2][0][2] = sides[2][0][0];
		copy[2][1][0] = sides[2][2][1];
		copy[2][1][2] = sides[2][0][1];
		copy[2][2][0] = sides[2][2][2];
		copy[2][2][1] = sides[2][1][2];
		copy[2][2][2] = sides[2][0][2];
		//change top
		copy[0][0][0] = sides[4][2][2];
		copy[0][1][0] = sides[4][1][2];
		copy[0][2][0] = sides[4][0][2];
		//change front
		copy[1][0][0] = sides[0][0][0];
		copy[1][1][0] = sides[0][1][0];
		copy[1][2][0] = sides[0][2][0];
		//change bottom
		copy[5][0][0] = sides[1][0][0];
		copy[5][1][0] = sides[1][1][0];
		copy[5][2][0] = sides[1][2][0];
		//change back
		copy[4][0][2] = sides[5][2][0];
		copy[4][1][2] = sides[5][1][0];
		copy[4][2][2] = sides[5][0][0];	
	}
	//LEFT BACKWARD
	else if (verticalIndex==0){
		//change left
		copy[2][0][0] = sides[2][0][2];
		copy[2][0][1] = sides[2][1][2];
		copy[2][0][2] = sides[2][2][2];
		copy[2][1][0] = sides[2][0][1];
		copy[2][1][2] = sides[2][2][1];
		copy[2][2][0] = sides[2][0][0];
		copy[2][2][1] = sides[2][1][0];
		copy[2][2][2] = sides[2][2][0];
		//change top
		copy[0][0][0] = sides[1][0][0];
		copy[0][1][0] = sides[1][1][0];
		copy[0][2][0] = sides[1][2][0];
		//change front
		copy[1][0][0] = sides[5][0][0];
		copy[1][1][0] = sides[5][1][0];
		copy[1][2][0] = sides[5][2][0];
		//change bottom
		copy[5][0][0] = sides[4][2][2];
		copy[5][1][0] = sides[4][1][2];
		copy[5][2][0] = sides[4][0][2];
		//change back
		copy[4][0][2] = sides[0][2][0];
		copy[4][1][2] = sides[0][1][0];
		copy[4][2][2] = sides[0][0][0];
	}
	//MIDDLE FORWARD
	else if (verticalIndex==1 && isForward){
		//change top
		copy[0][0][1] = sides[4][2][1];
		copy[0][1][1] = sides[4][1][1];
		copy[0][2][1] = sides[4][0][1];
		//change front
		copy[1][0][1] = sides[0][0][1];
		copy[1][1][1] = sides[0][1][1];
		copy[1][2][1] = sides[0][2][1];
		//change bottom
		copy[5][0][1] = sides[1][0][1];
		copy[5][1][1] = sides[1][1][1];
		copy[5][2][1] = sides[1][2][1];
		//change back
		copy[4][0][1] = sides[5][2][1];
		copy[4][1][1] = sides[5][1][1];
		copy[4][2][1] = sides[5][0][1];
	}
	//MIDDLE BACKWARD
	else if (verticalIndex==1){
		//change top
		copy[0][0][1] = sides[1][0][1];
		copy[0][1][1] = sides[1][1][1];
		copy[0][2][1] = sides[1][2][1];
		//change front
		copy[1][0][1] = sides[5][0][1];
		copy[1][1][1] = sides[5][1][1];
		copy[1][2][1] = sides[5][2][1];
		//change bottom
		copy[5][0][1] = sides[4][2][1];
		copy[5][1][1] = sides[4][1][1];
		copy[5][2][1] = sides[4][0][1];
		//change back
		copy[4][0][1] = sides[0][2][1];
		copy[4][1][1] = sides[0][1][1];
		copy[4][2][1] = sides[0][0][1];
	}
	//RIGHT FORWARD
	else if (verticalIndex==2 && isForward){
		//change right
		copy[3][0][0] = sides[3][0][2];
		copy[3][0][1] = sides[3][1][2];
		copy[3][0][2] = sides[3][2][2];
		copy[3][1][0] = sides[3][0][1];
		copy[3][1][2] = sides[3][2][1];
		copy[3][2][0] = sides[3][0][0];
		copy[3][2][1] = sides[3][1][0];
		copy[3][2][2] = sides[3][2][0];
		//change top
		copy[0][0][2] = sides[4][2][0];
		copy[0][1][2] = sides[4][1][0];
		copy[0][2][2] = sides[4][0][0];
		//change front
		copy[1][0][2] = sides[0][0][2];
		copy[1][1][2] = sides[0][1][2];
		copy[1][2][2] = sides[0][2][2];
		//change bottom
		copy[5][0][2] = sides[1][0][2];
		copy[5][1][2] = sides[1][1][2];
		copy[5][2][2] = sides[1][2][2];
		//change back
		copy[4][0][0] = sides[5][2][2];
		copy[4][1][0] = sides[5][1][2];
		copy[4][2][0] = sides[5][0][2];	
	}
	//RIGHT BACKWARD
	else{
		//change right
		copy[3][0][0] = sides[3][2][0];
		copy[3][0][1] = sides[3][1][0];
		copy[3][0][2] = sides[3][0][0];
		copy[3][1][0] = sides[3][2][1];
		copy[3][1][2] = sides[3][0][1];
		copy[3][2][0] = sides[3][2][2];
		copy[3][2][1] = sides[3][1][2];
		copy[3][2][2] = sides[3][0][2];
		//change top
		copy[0][0][2] = sides[1][0][2];
		copy[0][1][2] = sides[1][1][2];
		copy[0][2][2] = sides[1][2][2];
		//change front
		copy[1][0][2] = sides[5][0][2];
		copy[1][1][2] = sides[5][1][2];
		copy[1][2][2] = sides[5][2][2];
		//change bottom
		copy[5][0][2] = sides[4][2][0];
		copy[5][1][2] = sides[4][1][0];
		copy[5][2][2] = sides[4][0][0];
		//change back
		copy[4][0][0] = sides[0][2][2];
		copy[4][1][0] = sides[0][1][2];
		copy[4][2][0] = sides[0][0][2];
	}
	sides = copyState(copy);
}//end turnVertical


//0=front, 1=middle, 2=back; true=clockwise, false=counterclockwise
//Rotates a horizontal section of the cube based on the parameters
public void turnFace(int faceIndex, boolean isClockWise){
	char[][][] copy = copyState(sides);
	//FRONT CW
	if (faceIndex==0 && isClockWise){
		//change front
		copy[1][0][0] = sides[1][2][0];
		copy[1][0][1] = sides[1][1][0];
		copy[1][0][2] = sides[1][0][0];
		copy[1][1][0] = sides[1][2][1];
		copy[1][1][2] = sides[1][0][1];
		copy[1][2][0] = sides[1][2][2];
		copy[1][2][1] = sides[1][1][2];
		copy[1][2][2] = sides[1][0][2];
		//change top
		copy[0][2][0] = sides[2][2][2];
		copy[0][2][1] = sides[2][1][2];
		copy[0][2][2] = sides[2][0][2];
		//change left
		copy[2][0][2] = sides[5][0][0];
		copy[2][1][2] = sides[5][0][1];
		copy[2][2][2] = sides[5][0][2];
		//change right
		copy[3][0][0] = sides[0][2][0];
		copy[3][1][0] = sides[0][2][1];
		copy[3][2][0] = sides[0][2][2];
		//change bottom
		copy[5][0][0] = sides[3][2][0];
		copy[5][0][1] = sides[3][1][0];
		copy[5][0][2] = sides[3][0][0];
	}
	//FRONT CCW
	else if (faceIndex==0){
		//change front
		copy[1][0][0] = sides[1][0][2];
		copy[1][0][1] = sides[1][1][2];
		copy[1][0][2] = sides[1][2][2];
		copy[1][1][0] = sides[1][0][1];
		copy[1][1][2] = sides[1][2][1];
		copy[1][2][0] = sides[1][0][0];
		copy[1][2][1] = sides[1][1][0];
		copy[1][2][2] = sides[1][2][0];
		//change top
		copy[0][2][0] = sides[3][0][0];
		copy[0][2][1] = sides[3][1][0];
		copy[0][2][2] = sides[3][2][0];
		//change left
		copy[2][0][2] = sides[0][2][2];
		copy[2][1][2] = sides[0][2][1];
		copy[2][2][2] = sides[0][2][0];
		//change right
		copy[3][0][0] = sides[5][0][2];
		copy[3][1][0] = sides[5][0][1];
		copy[3][2][0] = sides[5][0][0];
		//change bottom
		copy[5][0][0] = sides[2][0][2];
		copy[5][0][1] = sides[2][1][2];
		copy[5][0][2] = sides[2][2][2];
	}
	//MIDDLE CW
	else if (faceIndex==1 && isClockWise){
		//change top
		copy[0][1][0] = sides[2][2][1];
		copy[0][1][1] = sides[2][1][1];
		copy[0][1][2] = sides[2][0][1];
		//change left
		copy[2][0][1] = sides[5][1][0];
		copy[2][1][1] = sides[5][1][1];
		copy[2][2][1] = sides[5][1][2];
		//change right
		copy[3][0][1] = sides[0][1][0];
		copy[3][1][1] = sides[0][1][1];
		copy[3][2][1] = sides[0][1][2];
		//change bottom
		copy[5][1][0] = sides[3][0][1];
		copy[5][1][1] = sides[3][1][1];
		copy[5][1][2] = sides[3][2][1];	
	}
	//MIDDLE CCW
	else if (faceIndex==1){
		//change top
		copy[0][1][0] = sides[3][0][1];
		copy[0][1][1] = sides[3][1][1];
		copy[0][1][2] = sides[3][2][1];
		//change left
		copy[2][0][1] = sides[0][1][2];
		copy[2][1][1] = sides[0][1][1];
		copy[2][2][1] = sides[0][1][0];
		//change right
		copy[3][0][1] = sides[5][1][2];
		copy[3][1][1] = sides[5][1][1];
		copy[3][2][1] = sides[5][1][0];
		//change bottom
		copy[5][1][0] = sides[2][0][1];
		copy[5][1][1] = sides[2][1][1];
		copy[5][1][2] = sides[2][2][1];	
	}
	//BACK CW
	else if (faceIndex==2 && isClockWise){
		//change back
		copy[4][0][0] = sides[4][2][0];
		copy[4][0][1] = sides[4][1][0];
		copy[4][0][2] = sides[4][0][0];
		copy[4][1][0] = sides[4][2][1];
		copy[4][1][2] = sides[4][0][1];
		copy[4][2][0] = sides[4][2][2];
		copy[4][2][1] = sides[4][1][2];
		copy[4][2][2] = sides[4][0][2];
		//change top
		copy[0][0][0] = sides[3][0][2];
		copy[0][0][1] = sides[3][1][2];
		copy[0][0][2] = sides[3][2][2];
		//change left
		copy[2][0][0] = sides[0][0][2];
		copy[2][1][0] = sides[0][0][1];
		copy[2][2][0] = sides[0][0][0];
		//change right
		copy[3][0][2] = sides[5][2][2];
		copy[3][1][2] = sides[5][2][1];
		copy[3][2][2] = sides[5][2][0];
		//change bottom
		copy[5][2][0] = sides[2][0][0];
		copy[5][2][1] = sides[2][1][0];
		copy[5][2][2] = sides[2][2][0];	
	}
	//BACK CCW
	else{
		//change back
		copy[4][0][0] = sides[4][0][2];
		copy[4][0][1] = sides[4][1][2];
		copy[4][0][2] = sides[4][2][2];
		copy[4][1][0] = sides[4][0][1];
		copy[4][1][2] = sides[4][2][1];
		copy[4][2][0] = sides[4][0][0];
		copy[4][2][1] = sides[4][1][0];
		copy[4][2][2] = sides[4][2][0];
		//change top
		copy[0][0][0] = sides[2][2][0];
		copy[0][0][1] = sides[2][1][0];
		copy[0][0][2] = sides[2][0][0];
		//change left
		copy[2][0][0] = sides[5][2][0];
		copy[2][1][0] = sides[5][2][1];
		copy[2][2][0] = sides[5][2][2];
		//change right
		copy[3][0][2] = sides[0][0][0];
		copy[3][1][2] = sides[0][0][1];
		copy[3][2][2] = sides[0][0][2];
		//change bottom
		copy[5][2][0] = sides[3][2][2];
		copy[5][2][1] = sides[3][1][2];
		copy[5][2][2] = sides[3][0][2];
	}
	sides = copyState(copy);
}//end turnFace

}//end class
