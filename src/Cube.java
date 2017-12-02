import java.util.ArrayList;
import java.util.Random;

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
	private ArrayList <SolveInstruction> instructions = new ArrayList <> ();
	private int currentStep;
	
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
		
		instructions = new ArrayList<>(1);
		instructions.add(new SolveInstruction(sides,""));
		currentStep = 0;
	}
	

	public void rotate(int face, boolean isClockwise) {
		switch(face) {
			case 0:
				rotateTop(isClockwise);
				break;
			case 1:
				rotateFront(isClockwise);
				break;
			case 2:
				rotateLeft(isClockwise);
				break;
			case 3:
				rotateRight(isClockwise);
				break;
			case 4:
				rotateBack(isClockwise);
				break;
			case 5:
				rotateBottom(isClockwise);
				break;
		}
	}
	
	/**
	 * Rotates the front facing side of the rubiks cube, this is assumed to be the red side.
	 * @param clockwise
	 */
	private void rotateFront(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		//This will need to be removed, update temp
		
		//rotate face
		rotateFace(1);
		
		temp = copyState(sides);
		//rotates bottom to left
		temp[2][0][2] = sides[5][0][0];
		temp[2][1][2] = sides[5][0][1];
		temp[2][2][2] = sides[5][0][2];
		
		//rotates left to top
		temp[0][2][2] = sides[2][0][2];
		temp[0][2][1] = sides[2][1][2];
		temp[0][2][0] = sides[2][2][2];
		
		//rotates top to right
		temp[3][0][0] = sides[0][2][0];
		temp[3][1][0] = sides[0][2][1];
		temp[3][2][0] = sides[0][2][2];
		
		//rotates right to bottom
		temp[5][0][2] = sides[3][0][0];
		temp[5][0][1] = sides[3][1][0];
		temp[5][0][0] = sides[3][2][0];
		
		sides = copyState(temp);
		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateFront(true);
			rotateFront(true);
		}
		
		
	}
	
	private void rotateBack(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		//This will need to be removed, update temp
		
		//rotate face
		rotateFace(4);
		
		temp = copyState(sides);
		
		//rotates right to top
		temp[0][0][0] = sides[3][0][2];
		temp[0][0][1] = sides[3][1][2];
		temp[0][0][2] = sides[3][2][2];
		
		//rotates top to left
		temp[2][2][0] = sides[0][0][0];
		temp[2][1][0] = sides[0][0][1];
		temp[2][0][0] = sides[0][0][2];
		
		//rotates left to bottom
		temp[5][2][2] = sides[2][2][0];
		temp[5][2][1] = sides[2][1][0];
		temp[5][2][0] = sides[2][0][0];
		
		//rotates bottom to right
		temp[3][0][2] = sides[5][2][2];
		temp[3][1][2] = sides[5][2][1];
		temp[3][2][2] = sides[5][2][0];
		
		sides = copyState(temp);
		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateBack(true);
			rotateBack(true);
		}
	}
	
	
	private void rotateLeft(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		//This will need to be removed, update temp
		
		//rotate face
		rotateFace(2);
		
		temp = copyState(sides);
		//rotates bottom to back
		temp[4][0][2] = sides[5][2][0];
		temp[4][1][2] = sides[5][1][0];
		temp[4][2][2] = sides[5][0][0];
		
		//rotates back to top
		temp[0][2][0] = sides[4][0][2];
		temp[0][1][0] = sides[4][1][2];
		temp[0][0][0] = sides[4][2][2];
		
		//rotates top to front
		temp[1][0][0] = sides[0][0][0];
		temp[1][1][0] = sides[0][1][0];
		temp[1][2][0] = sides[0][2][0];
		
		//rotates front to bottom
		temp[5][0][0] = sides[1][0][0];
		temp[5][1][0] = sides[1][1][0];
		temp[5][2][0] = sides[1][2][0];

		sides = copyState(temp);
		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateLeft(true);
			rotateLeft(true);
		}
	}
	
	private void rotateRight(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		
		//rotate face
		rotateFace(3);
		
		temp = copyState(sides);
		//rotates front to top
		temp[0][0][2] = sides[1][0][2];
		temp[0][1][2] = sides[1][1][2];
		temp[0][2][2] = sides[1][2][2];
		
		//rotates top to back
		temp[4][2][0] = sides[0][0][2];
		temp[4][1][0] = sides[0][1][2];
		temp[4][0][0] = sides[0][2][2];
		
		//rotates back to bottom
		temp[5][0][2] = sides[4][2][0];
		temp[5][1][2] = sides[4][1][0];
		temp[5][2][2] = sides[4][0][0];
		
		//rotates bottom to front
		temp[1][0][2] = sides[5][0][2];
		temp[1][1][2] = sides[5][1][2];
		temp[1][2][2] = sides[5][2][2];

		sides = copyState(temp);
		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateRight(true);
			rotateRight(true);
		}
		
		
	}
	
	/**
	 * Rotates the top facing side of the rubiks cube, this is assumed to be the white side.
	 */
	private void rotateTop(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		//This will need to be removed, update temp
		rotateFace(0);
		temp = copyState(sides);
		
		//rotate left to back
		temp[4][0][0] = sides[2][0][0];
		temp[4][0][1] = sides[2][0][1];
		temp[4][0][2] = sides[2][0][2];
		
		//rotate back to right
		temp[3][0][0] = sides[4][0][0];
		temp[3][0][1] = sides[4][0][1];
		temp[3][0][2] = sides[4][0][2];
		
		//rotate right to front
		temp[1][0][0] = sides[3][0][0];
		temp[1][0][1] = sides[3][0][1];
		temp[1][0][2] = sides[3][0][2];
		
		//rotate front to left
		temp[2][0][0] = sides[1][0][0];
		temp[2][0][1] = sides[1][0][1];
		temp[2][0][2] = sides[1][0][2];
		
		sides = copyState(temp);
		
		if(!clockwise)
		{
			rotateTop(true);
			rotateTop(true);
		}
		
		
	}
	
	/**
	 * 
	 * @param clockwise
	 */
	private void rotateBottom(boolean clockwise)
	{
		char[][][] temp = copyState(sides);
		//This will need to be removed, update temp
		rotateFace(5);
		temp = copyState(sides);
		
		//rotate front to right
		temp[3][2][0] = sides[1][2][0];
		temp[3][2][1] = sides[1][2][1];
		temp[3][2][2] = sides[1][2][2];
		
		//rotate right to back
		temp[4][2][0] = sides[3][2][0];
		temp[4][2][1] = sides[3][2][1];
		temp[4][2][2] = sides[3][2][2];
		
		//rotate back to left
		temp[2][2][0] = sides[4][2][0];
		temp[2][2][1] = sides[4][2][1];
		temp[2][2][2] = sides[4][2][2];
		
		//rotate left to front
		temp[1][2][0] = sides[2][2][0];
		temp[1][2][1] = sides[2][2][1];
		temp[1][2][2] = sides[2][2][2];
		
		sides = copyState(temp);
		
		if(!clockwise)
		{
			rotateBottom(true);
			rotateBottom(true);
		}
		
		
	}
	
	
	//Helper method for rotating a side.
	private void rotateFace(int side)
	{
		char[][][] temp = copyState(sides);
		temp[side][0][0] = sides[side][2][0];
		temp[side][0][1] = sides[side][1][0];
		temp[side][0][2] = sides[side][0][0];
		
		temp[side][1][2] = sides[side][0][1];
		temp[side][2][2] = sides[side][0][2];
		
		temp[side][2][1] = sides[side][1][2];
		temp[side][2][0] = sides[side][2][2];
		
		temp[side][1][0] = sides[side][2][1];
		sides = copyState(temp);
	}
	

	public void solve() {
		
		//--------------------//
		//SOLVE RED/WHITE EDGE//
		//--------------------//
		int[][] rw = searchForEdge('R', 'W');
		
		if(!(rw[0][0]==1 && rw[1][0]==0)) { //check if rw cord is already in position or gets it in position
		
			if(!(rw[0][1]==0 && rw[0][2]==1)) {
				StringBuilder message = new StringBuilder();
				message.append("Turn the ");
				int rotateCount = 0;
				int rotatedFace = 0;
				while(!(rw[0][1]==0  && rw[0][2]==1)) {//while the red tile is not in the top square rotate until its there
					rotatedFace = rw[0][0];
					rotate(rotatedFace, true);
					rotateCount++;
					rw = searchForEdge('R','W');
				}
				message.append(getFaceName(rotatedFace));
				if(rotateCount >=3) {
					message.append("side coutner clock-wise 1 time");
				}
				else {
					message.append("side clock-wise ");
					message.append(rotateCount);
					if(rotateCount > 1)
						message.append(" times");
					else
						message.append(" time");
				}
				instructions.add(new SolveInstruction(copyState(sides),message.toString()));
			}
			
			switch(rw[0][0]) {
				case 0:
					rotate(4, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side coutner clock-wise 1 time"));
					rotate(3, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side coutner clock-wise 1 time"));
					rotate(0, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the top side clock-wise 1 time"));
					break;
				case 1:
					break;
				case 5:
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side coutner clock-wise 1 time"));
					rotate(2, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side coutner clock-wise 1 time"));
					rotate(1, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the front side clock-wise 1 time"));
					break;
				default:
					StringBuilder instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the ");
					int rotateCount = 0;
					int rotatedFace = 1;
					while(rw[0][0] != 1){ //while the red tile is not on the red side
						rotatedFace = getRotatableSide(rw[0][0], rw[0][1], rw[0][2]);
						rotate(rotatedFace,true);
						rotateCount++;
						rw = searchForEdge('R', 'W');
					} 
					instructionMessage.append(getFaceName(rotatedFace));
					if(rotateCount >=3) {
						instructionMessage.append(" side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise ");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
			}
		}

		//----------------------//
		//SOLVE GREEN/WHITE EDGE//
		//----------------------//
		int[][] gw = searchForEdge('G', 'W');
		if(!(gw[0][0]==2&&gw[1][0]==0)) {//checks if it is already in position
			int rotateCount = 0;
			int rotatedFace = 1;
			if(!(gw[0][1] == 2 && gw[0][2] == 1)) {
				StringBuilder instructionMessage = new StringBuilder(); 
				instructionMessage.append("Turn the ");
				
				while(!(gw[0][1] == 2 && gw[0][2] == 1)) { //while the green tile is not in the bottom square rotate until its there
					rotatedFace = gw[0][0];
					rotate(rotatedFace,true);
					rotateCount++;
					gw = searchForEdge('G', 'W');
				}
				instructionMessage.append(getFaceName(rotatedFace));
				if(rotateCount >=3) {
					instructionMessage.append(" side coutner clock-wise 1 time");
				}
				else {
					instructionMessage.append(" side clock-wise ");
					instructionMessage.append(rotateCount);
					if(rotateCount > 1)
						instructionMessage.append(" times");
					else
						instructionMessage.append(" time");
				}
				instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
			}
			
			switch(gw[0][0]) {
				case 0:
					rotate(1, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the front side coutner clock-wise 1 time"));
					for(int i=0;i<rotateCount;i++) {
						rotate(0, false);
					}
					StringBuilder instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the top ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append("side clock-wise ");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					rotate(2, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side coutner clock-wise 1 time"));
					break;
				case 1:
					System.out.print("s");
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side counter clock-wise 1 time"));
	
					for(int i=0;i<rotateCount;i++) {
						rotate(1, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the top ");
					if(rotateCount >=3) {
						instructionMessage.append(" side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));

					
					rotate(2, true);
					rotate(2, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side clock-wise 2 times"));
					break;
				case 2:
					rotate(2, true);
					rotate(2, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side clock-wise 2 times"));
					break;
				case 5:
					rotate(4, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side coutner clock-wise 1 time"));
					rotate(2, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side clock-wise 1 time"));
					break;
				default:
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the ");
					rotateCount = 0;
					rotatedFace = 0;
					while(gw[0][0] != 2) { //while the green tile is not on the green side
						rotatedFace = 5;
						rotate(rotatedFace,true);
						rotateCount++;
						gw = searchForEdge('G','W');
					}
					instructionMessage.append(getFaceName(rotatedFace));
					if(rotateCount >=3) {
						instructionMessage.append(" side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
					rotate(2, false);
					rotate(2, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the left side counter clock-wise 2 times"));
			}
		}
		
		//
		//SOLVE ORANGE/WHITE EDGE
		//
		int[][] ow = searchForEdge('O', 'W');
		if(!(ow[0][0]==4&&ow[1][0]==0)) {//checks if it is already in position
			int rotateCount = 0;
			int rotatedFace = 1;
			if(!(ow[0][1] == 2 && ow[0][2] == 1)) {
				StringBuilder instructionMessage = new StringBuilder(); 
				instructionMessage.append("Turn the ");
				
				while(!(ow[0][1] == 2 && ow[0][2] == 1)) { //while the green tile is not in the bottom square rotate until its there
					rotatedFace = ow[0][0];
					rotate(rotatedFace,true);
					rotateCount++;
					ow = searchForEdge('O', 'W');
				}
				instructionMessage.append(getFaceName(rotatedFace));
				if(rotateCount >=3) {
					instructionMessage.append(" side coutner clock-wise 1 time");
				}
				else {
					instructionMessage.append(" side clock-wise");
					instructionMessage.append(rotateCount);
					if(rotateCount > 1)
						instructionMessage.append(" times");
					else
						instructionMessage.append(" time");
				}
				instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
			}
			
			switch(ow[0][0]) {
				case 0:
					rotate(1, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the front side clock-wise 1 time"));
					for(int i=0;i<rotateCount;i++) {
						rotate(0, false);
					}
					StringBuilder instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the top ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append("side clock-wise ");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					rotate(3, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side counter clock-wise 1 time"));
					rotate(5, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side clock-wise 1 time"));
					rotate(4, true);
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 2 times"));
					break;
				case 1:
					rotate(5, true);
					rotate(5, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side clock-wise 2 times"));
	
					for(int i=0;i<rotateCount;i++) {
						rotate(1, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the front ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));

					
					rotate(4, true);
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 2 times"));
					break;
				case 2:
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side counter clock-wise 1 time"));
					
					for(int i=0;i<rotateCount;i++) {
						rotate(2, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the left ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					
					rotate(4, true);
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 2 times"));
					break;
				case 4:
					rotate(4, true);
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 2 times"));
					break;
				case 5:
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side coutner clock-wise 1 time"));
					rotate(3, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side counter clock-wise 1 time"));
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 1 time"));
					break;
				default:
					System.out.println("yeeeeee");
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the ");
					rotateCount = 0;
					rotatedFace = 0;
					while(ow[0][0] != 4) { //while the green tile is not on the green side
						rotatedFace = 5;
						rotate(rotatedFace,true);
						rotateCount++;
						ow = searchForEdge('O','W');
					}
					instructionMessage.append(getFaceName(rotatedFace));
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append("side clock-wise ");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
					rotate(4, false);
					rotate(4, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side counter clock-wise 2 times"));
			}
		}
		
		
		//
		//SOLVE BLUE/WHITE EDGE
		//
		int[][] bw = searchForEdge('B', 'W');
		if(!(bw[0][0]==3&&bw[1][0]==0)) {//checks if it is already in position
			int rotateCount = 0;
			int rotatedFace = 1;
			if(!(bw[0][1] == 2 && bw[0][2] == 1)) {
				StringBuilder instructionMessage = new StringBuilder(); 
				instructionMessage.append("Turn the ");
				
				while(!(bw[0][1] == 2 && bw[0][2] == 1)) { //while the green tile is not in the bottom square rotate until its there
					rotatedFace = bw[0][0];
					rotate(rotatedFace,true);
					rotateCount++;
					bw = searchForEdge('B', 'W');
				}
				instructionMessage.append(getFaceName(rotatedFace));
				if(rotateCount >=3) {
					instructionMessage.append(" side coutner clock-wise 1 time");
				}
				else {
					instructionMessage.append(" side clock-wise");
					instructionMessage.append(rotateCount);
					if(rotateCount > 1)
						instructionMessage.append(" times");
					else
						instructionMessage.append(" time");
				}
				instructions.add(new SolveInstruction(copyState(sides),instructionMessage.toString()));
			}
			
			switch(bw[0][0]) {
				case 0:
					rotate(1, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the top side clock-wise 1 time"));
					for(int i=0;i<rotateCount;i++) {
						rotate(0, false);
					}
					StringBuilder instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the top ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append("side clock-wise ");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 1 time"));
					break;
				case 1:
					rotate(5, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side clock-wise 1 time"));
	
					for(int i=0;i<rotateCount;i++) {
						rotate(1, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the front ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));

					
					rotate(3, true);
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 2 times"));
					break;
				case 2:
					rotate(5, false);
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side clock-wise 2 times"));
					
					for(int i=0;i<rotateCount;i++) {
						rotate(2, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the left ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					
					rotate(3, true);
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 2 times"));
					break;
				case 3:
					rotate(3, true);
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 2 times"));
					break;
				case 4:
					rotate(5, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the bottom side counter clock-wise 1 time"));
					
					for(int i=0;i<rotateCount;i++) {
						rotate(4, false);
					}
					
					instructionMessage = new StringBuilder(); 
					instructionMessage.append("Turn the back ");
					if(rotateCount >=3) {
						instructionMessage.append("side coutner clock-wise 1 time");
					}
					else {
						instructionMessage.append(" side clock-wise");
						instructionMessage.append(rotateCount);
						if(rotateCount > 1)
							instructionMessage.append(" times");
						else
							instructionMessage.append(" time");
					}
					instructions.add(new SolveInstruction(copyState(sides), instructionMessage.toString()));
					
					rotate(3, true);
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 2 times"));
					break;
				case 5:
					rotate(4, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side clock-wise 1 time"));
					rotate(3, true);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 1 time"));
					rotate(4, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the back side counter clock-wise 1 time"));
					rotate(3, false);
					rotate(3, false);
					instructions.add(new SolveInstruction(copyState(sides),"Turn the right side clock-wise 2 times"));
					break;
			}
		}
	}
	
	public String getFaceName(int f) {
		switch(f) {
			case 0:
				return "top";
			case 1:
				return "front";
			case 2:
				return "left";
			case 3:
				return "right";
			case 4:
				return "back";
			case 5:
				return "bottom";
		}
		return "";
	}
	
	public int getRotatableSide(int f, int row, int col) {
		switch(f) {
			case 0:
				if(row==0&&col==1) {
					return 4;
				}
				if(row==1&&col==0) {
					return 2;
				}
				if(row==1&&col==2) {
					return 3;
				}
				if(row==2&&col==1) {
					return 1;
				}
				break;
			case 1:
				if(row==0&&col==1) {
					return 0;
				}
				if(row==1&&col==0) {
					return 2;
				}
				if(row==1&&col==2) {
					return 3;
				}
				if(row==2&&col==1) {
					return 5;
				}
				break;
			case 2:
				if(row==0&&col==1) {
					return 0;
				}
				if(row==1&&col==0) {
					return 4;
				}
				if(row==1&&col==2) {
					return 1;
				}
				if(row==2&&col==1) {
					return 5;
				}
				break;
			case 3:
				if(row==0&&col==1) {
					return 0;
				}
				if(row==1&&col==0) {
					return 1;
				}
				if(row==1&&col==2) {
					return 4;
				}
				if(row==2&&col==1) {
					return 5;
				}
				break;
			case 4:
				if(row==0&&col==1) {
					return 0;
				}
				if(row==1&&col==0) {
					return 3;
				}
				if(row==1&&col==2) {
					return 2;
				}
				if(row==2&&col==1) {
					return 5;
				}
				break;
			case 5:
				if(row==0&&col==1) {
					return 1;
				}
				if(row==1&&col==0) {
					return 2;
				}
				if(row==1&&col==2) {
					return 3;
				}
				if(row==2&&col==1) {
					return 4;
				}
		}
		return -1;
	}
	
	public int[][] searchForEdge(char c1, char c2) {
		int[][] cords = {{-1,-1,-1},{-1,-1,-1}};
		for(int f=0;f<sides.length;f++) {
			//for(int r=0;r<sides[f].length;r++) {
				if(sides[f][0][1]==c1) {
					int[] corCords = getCorrespondingEdge(f, 0, 1);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[1] = corCords;
						cords[0][0] = f; cords[0][1] = 0; cords[0][2] = 1;
						return cords;
					}
				}
				if(sides[f][1][0]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 0);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[1] = corCords;
						cords[0][0] = f; cords[0][1] = 1; cords[0][2] = 0;
						return cords;
					}
				}
				if(sides[f][1][2]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 2);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[1] = corCords;
						cords[0][0] = f; cords[0][1] = 1; cords[0][2] = 2;
						return cords;
					}
				}
				if(sides[f][2][1]==c1) {
					int[] corCords = getCorrespondingEdge(f, 2, 1);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[1] = corCords;
						cords[0][0] = f; cords[0][1] = 2; cords[0][2] = 1;
						return cords;
					}
				}
			//}
		}
		return cords;
	}
	
	public int[] getCorrespondingEdge(int f, int row, int col) {
		switch(f) {
			case 0:
				if(row==0&&col==1) {
					int[] cords = {4,0,1};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {2,0,1};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {3,0,1};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {1,0,1};
					return cords;
				}
				break;
			case 1:
				if(row==0&&col==1) {
					int[] cords = {0,2,1};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {2,1,2};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {3,1,0};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {5,0,1};
					return cords;
				}
				break;
			case 2:
				if(row==0&&col==1) {
					int[] cords = {0,1,0};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {4,1,2};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {1,1,0};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {5,1,0};
					return cords;
				}
				break;
			case 3:
				if(row==0&&col==1) {
					int[] cords = {0,1,2};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {1,1,2};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {4,1,0};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {5,1,2};
					return cords;
				}
				break;
			case 4:
				if(row==0&&col==1) {
					int[] cords = {0,0,1};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {3,1,2};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {2,1,0};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {5,2,1};
					return cords;
				}
				break;
			case 5:
				if(row==0&&col==1) {
					int[] cords = {1,2,1};
					return cords;
				}
				else if(row==1&&col==0) {
					int[] cords = {2,2,1};
					return cords;
				}
				else if(row==1&&col==2) {
					int[] cords = {3,2,1};
					return cords;
				}
				else if(row==2&&col==1) {
					int[] cords = {4,2,1};
					return cords;
				}
		}
		return null;
	}
	

	/** (this method scrambles the cube so it can be solved)
	 */ 
	public void scramble()
	{
		Random ran = new Random();
		int range = ran.nextInt(50)+50;
		for(int i=0; i<range;i++) {
			int turnFace = ran.nextInt(6);
			boolean cw = ran.nextBoolean();
			rotate(turnFace, cw);
		}
		instructions.clear();
		currentStep = 0;
		instructions.add(new SolveInstruction(copyState(sides),"Start"));
		solve();
	}
	
	/** (this method gets the instruction at passed in index)
	* @param (passes in a index for the instructions)
	* @return (a set instruction at set index)
	 */ 
	public SolveInstruction getStep(int stepIndex)
	{
		if(stepIndex<instructions.size() && stepIndex>=0) {
			currentStep = stepIndex;
		}
		return instructions.get(currentStep);
	}
	
	/** this method gets the previous instruction
	 * @return a set instruction at set index
	 */ 
	public SolveInstruction getPreviousStep()
	{
		if(currentStep>0) {
			currentStep--;
		}
		return instructions.get(currentStep);
	}
	
	/** this method gets the next instruction
	 * @return a set instruction at set index
	 */ 
	public SolveInstruction getNextStep()
	{
		if(currentStep<instructions.size()-1) {
			currentStep++;
		}
		return instructions.get(currentStep);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTotalSteps() {
		return instructions.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentStepIndex() {
		return currentStep;
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
	

}//end class
