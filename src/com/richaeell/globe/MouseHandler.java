package com.richaeell.globe;

import java.awt.event.MouseEvent;

public class MouseHandler {

	private int x_pos,y_pos,old_x_pos,old_y_pos;

	MouseHandler()
	{
		//Nothing
	}

	public void jPanel2MousePressed(MouseEvent evt)		//GETS CALLED WHEN MOUSE IS CLICKED
	{
		old_x_pos = (int) (evt.getX()/6);		//We save the x position of the mouse in a variable
		old_y_pos = (int) (evt.getY()/6);		//We save the y position of the mouse in a variable
												//The /6 is just to scale the mouse positions to the pixel size
        Matrix.updateMatrix(Matrix.getMatrix(),old_x_pos,old_y_pos);		//We update the matrix with the position of the mouse click
    }

	//GETS CALLED WHEN MOUSE IS DRAGGED
	public void jPanel2MouseDragged(MouseEvent evt)
	{
		x_pos = (int) (evt.getX()/6);		//We load the the x position of the mouse event object and save it in a variable
    y_pos = (int) (evt.getY()/6);		//We load the the y position of the mouse event object and save it in a variable
        									//The /6 is just to scale the mouse positions to the pixel size
        Matrix.updateMatrix(Matrix.getMatrix(),x_pos,y_pos);		//We update the matrix with those points by passing the above variables
    }

	//GETS CALLED WHEN MOUSE IS RELEASED
    public void jPanel2MouseReleased(MouseEvent evt)
    {
        x_pos = (int) (evt.getX()/6);		//We load the the x position of the mouse event object and save it in a variable
        y_pos = (int) (evt.getY()/6);		//We load the the y position of the mouse event object and save it in a variable
        									//The /6 is just to scale the mouse positions to the pixel size
        Matrix.updateMatrix(Matrix.getMatrix(),x_pos,y_pos);
    }

	public int getX_pos() {
		return x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public int getOld_x_pos() {
		return old_x_pos;
	}

	public int getOld_y_pos() {
		return old_y_pos;
	}
}
