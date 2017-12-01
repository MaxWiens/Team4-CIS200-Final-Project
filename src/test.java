import java.util.ArrayList;

public class test {
	char[][][] sides;
	private ArrayList <SolveInstruction> instructions = new ArrayList <> ();
	
	public void rotate(int faceIndex, boolean cw) {}
	
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
	
	public void solve() {
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
				if(rotateCount<8)
					System.out.print("rw1:");
					System.out.println("f: "+rwCord[0][0]+" row: "+rwCord[0][1]+" col: "+rwCord[0][2]);
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
				while((rwCord = searchForEdge('R', 'W'))[0][0] != 1) { //while the red tile is not on the red side
					rotatedFace = rwCord[0][0];
					rotate(rotatedFace,true);
					rotateCount++;
					//System.out.println("second while loop");
					if(rotateCount<8)
						System.out.print("rw2:");
						System.out.println("f: "+rwCord[0][0]+" row: "+rwCord[0][1]+" col: "+rwCord[0][2]);
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
			for(int r=0;r<sides[f].length;r++) {
				if(sides[f][0][1]==c1) {
					int[] corCords = getCorrespondingEdge(f, 0, 1);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 0; cords[1][2] = 1;
						return cords;
					}
				}
				else if(sides[f][1][0]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 0);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 1; cords[1][2] = 0;
						return cords;
					}
				}
				else if(sides[f][1][2]==c1) {
					int[] corCords = getCorrespondingEdge(f, 1, 2);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 1; cords[1][2] = 2;
						return cords;
					}
				}
				else if(sides[f][2][1]==c1) {
					int[] corCords = getCorrespondingEdge(f, 2, 1);
					if(sides[corCords[0]][corCords[1]][corCords[2]] == c2) {
						cords[0] = corCords;
						cords[1][0] = f; cords[1][1] = 2; cords[1][2] = 1;
						return cords;
					}
				}
			}
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
}
