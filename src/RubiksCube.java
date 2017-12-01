import java.util.Scanner;

public class RubiksCube
{
	public char[][][] sides = new char[6][3][3];
		
	
	
	public RubiksCube()
	{
		for(int i = 0; i < sides.length; i++)
		{
			for(int j = 0; j < sides[i].length; j++)
			{
				for(int k = 0; k < sides[i][j].length; k++)
				{
					sides[i][j][k] = 'A';
				}
			}
		}
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
		
		sides = copyState(sides);
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
		
		sides = copyState(sides);
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
		
		sides = copyState(sides);
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
		
		sides = copyState(sides);
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
		
		sides = copyState(sides);
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
		temp[3][2][0] = sides[2][2][0];
		temp[3][2][1] = sides[2][2][1];
		temp[3][2][2] = sides[2][2][2];
		
		//rotate right to back
		temp[4][2][0] = sides[4][2][0];
		temp[4][2][1] = sides[4][2][1];
		temp[4][2][2] = sides[4][2][2];
		
		//rotate back to left
		temp[2][2][0] = sides[3][2][0];
		temp[2][2][1] = sides[3][2][1];
		temp[2][2][2] = sides[3][2][2];
		
		//rotate left to front
		temp[1][2][0] = sides[1][2][0];
		temp[1][2][1] = sides[1][2][1];
		temp[1][2][2] = sides[1][2][2];
		
		if(!clockwise)
		{
			rotateBottom(true);
			rotateBottom(true);
		}
		
		sides = copyState(sides);
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
		sides = copyState(sides);
	}
}