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

		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateFront(true);
			rotateFront(true);
		}
		
		sides = copyState(temp);
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

		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateBack(true);
			rotateBack(true);
		}
		
		sides = copyState(temp);
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

		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateFront(true);
			rotateFront(true);
		}
		
		sides = copyState(temp);
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

		
		//If we need to rotate counter clockwise, we can simply rotate clockwise twice more, this is done using recursion.
		if(!clockwise)
		{
			rotateRight(true);
			rotateRight(true);
		}
		
		sides = copyState(temp);
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
		
		if(!clockwise)
		{
			rotateTop(true);
			rotateTop(true);
		}
		
		sides = copyState(temp);
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
		
		if(!clockwise)
		{
			rotateBottom(true);
			rotateBottom(true);
		}
		
		sides = copyState(temp);
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
		int[][] wr = searchForEdge('Y', 'W');
		System.out.println("Y: "+wr[0][0]+" "+wr[0][1]+" "+wr[0][2]);
		System.out.println("W: "+wr[1][0]+" "+wr[1][1]+" "+wr[1][2]);
		
		System.out.println("got to solve");
		//--------------------//
		//SOLVE RED/WHITE EDGE//
		//--------------------//
		int[][] rwCord = searchForEdge('R', 'W');
		if(rwCord[0][1] !=0 && rwCord[0][2] != 1) {
			StringBuilder instructionMessage = new StringBuilder(); 
			instructionMessage.append("Turn the ");
			int rotateCount = 0;
			int rotatedFace = 1;
			while((rwCord = searchForEdge('R', 'W'))[0][1] != 0 && rwCord[0][2] != 1) { //while the red tile is not in the top square rotate until its there
				rotatedFace = rwCord[0][0];
				rotate(rotatedFace,true);
				rotateCount++;
				//System.out.println("first while loop");
				if(rotateCount<8) {
					System.out.print("rw1:");
					System.out.println("f: "+rwCord[0][0]+" row: "+rwCord[0][1]+" col: "+rwCord[0][2]);
				}
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
		}
		
		rwCord = searchForEdge('R', 'W');
		switch(rwCord[0][0]) {
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
				do { //while the red tile is not on the red side
					rotatedFace = getRotatableSide(rwCord[0][0], rwCord[0][1], rwCord[0][1]);
					rotate(rotatedFace,true);
					rotateCount++;
					//System.out.println("second while loop");
					if(rotateCount<8) {
						System.out.print("rw2:");
						System.out.println("f: "+rwCord[0][0]+" row: "+rwCord[0][1]+" col: "+rwCord[0][2]);
					}
					rwCord = searchForEdge('R', 'W');
				}while(rwCord[0][0] != 1); 
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
		}
		
		
/*
		//----------------------//
		//SOLVE GREEN/WHITE EDGE//
		//----------------------//
		System.out.println("got to green");
		int[][] gwCord = searchForEdge('G', 'W');
		int rotateCount = 0;
		if(gwCord[0][1] !=2 && gwCord[0][2] != 1) {
			StringBuilder instructionMessage = new StringBuilder(); 
			instructionMessage.append("Turn the ");
			rotateCount = 0;
			int rotatedFace = 1;
			
			while((gwCord = searchForEdge('G', 'W'))[0][1] != 2 && gwCord[0][2] != 1) { //while the green tile is not in the bottom square rotate until its there
				rotatedFace = gwCord[0][0];
				rotate(rotatedFace,true);
				rotateCount++;
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
		}
		
		switch(gwCord[0][0]) {
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
				int rotatedFace = 1;
				while((gwCord = searchForEdge('G', 'W'))[0][0] != 2) { //while the green tile is not on the green side
					rotatedFace = 5;
					rotate(rotatedFace,true);
					rotateCount++;
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
				rotate(2, false);
				rotate(2, false);
				instructions.add(new SolveInstruction(copyState(sides),"Turn the left side counter clock-wise 2 times"));
		}
		
		//
		//SOLVE ORANGE/WHITE EDGE
		//
		
		
		//
		//SOLVE BLUE/WHITE EDGE
		//
		
		*/
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
				else if(row==1&&col==0) {
					return 2;
				}
				else if(row==1&&col==2) {
					return 3;
				}
				else if(row==2&&col==1) {
					return 1;
				}
				break;
			case 1:
				if(row==0&&col==1) {
					return 0;
				}
				else if(row==1&&col==0) {
					return 2;
				}
				else if(row==1&&col==2) {
					return 3;
				}
				else if(row==2&&col==1) {
					return 5;
				}
				break;
			case 2:
				if(row==0&&col==1) {
					return 0;
				}
				else if(row==1&&col==0) {
					return 4;
				}
				else if(row==1&&col==2) {
					return 1;
				}
				else if(row==2&&col==1) {
					return 5;
				}
				break;
			case 3:
				if(row==0&&col==1) {
					return 0;
				}
				else if(row==1&&col==0) {
					return 1;
				}
				else if(row==1&&col==2) {
					return 4;
				}
				else if(row==2&&col==1) {
					return 5;
				}
				break;
			case 4:
				if(row==0&&col==1) {
					return 0;
				}
				else if(row==1&&col==0) {
					return 3;
				}
				else if(row==1&&col==2) {
					return 2;
				}
				else if(row==2&&col==1) {
					return 5;
				}
				break;
			case 5:
				if(row==0&&col==1) {
					return 1;
				}
				else if(row==1&&col==0) {
					return 2;
				}
				else if(row==1&&col==2) {
					return 3;
				}
				else if(row==2&&col==1) {
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
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 0; cords[1][2] = 1;
						return cords;
					}
				}
				if(sides[f][1][0]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 0);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 1; cords[1][2] = 0;
						return cords;
					}
				}
				if(sides[f][1][2]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 2);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 1; cords[1][2] = 2;
						return cords;
					}
				}
				if(sides[f][2][1]==c1) {
					int[] corCords = getCorrespondingEdge(f, 2, 1);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 2; cords[1][2] = 1;
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
	/** (this method returns the face value at a certain index)
	* @param (passes in an index value)
	* @return (a char[][] face index)
	 */ 
	public char[][] getFace(int index)
	{
		return sides[index];
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
