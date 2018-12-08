package com.richaeell.globe;

import java.awt.event.MouseListener;

public class Matrix {
	
	private static int[][] matrix = new int[56][200];	//the matrix
	private int toolAction = 1;	
	
	Matrix()
	{
		fillMatrixWhith(Matrix.matrix,0);
	}
	
	public static void updateMatrix(int[][] matrix,int col,int row)	//Updates the matrix according to the mouse click positions it receives
    {
    	if(mainWindow>=0 && Main.getMouseListener().getX_pos()<200 && Main.getMouseListener().getY_pos()>=0 && Main.getMouseListener().getX_pos()<56)	//Here we check if the click is in the drawing area
        {
//          System.out.println("Position: "+x_pos+" , "+y_pos);
	        if(toolAction == 1)			//if its a drawing tool
	        {
	            matrix[row][col]=1;		//set position to 1 
	        }
	        else if(toolAction == 0)	//if its a eraser tool 
	        {
	            matrix[row][col]=0;		//set position to zero
	        }
        }
        else	// if its out of bounds then simply don't do anything (We could delete this part)
        {
//        	System.out.println("Out of Bounds");
        }
    	repaint();		//After we've updated the matrix with its respective values we then repaint the image according to the matrix we've just updated

    }
    public void fillMatrixWhith(int[][] matrix,int i)	//This method puts all the matrix positions to zero 
    {
    	for(int row=0;row<56;row++)
		{
			for(int col=0;col<200;col++)
			{
				matrix[row][col]=i;		//We fill each "cell" of the matrix with an i value witch is passed on in the method argument
			}
		}
    }
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int getToolAction() {
		return toolAction;
	}
	public void setToolAction(int toolAction) {
		this.toolAction = toolAction;
	}
    
    
}
