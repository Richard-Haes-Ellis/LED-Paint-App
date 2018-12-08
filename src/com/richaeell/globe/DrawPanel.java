package com.richaeell.globe;

import java.awt.*;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{	//Objects created with this class will be of type JPanel, in this case the panel will be used to be drawn on.

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	DrawPanel()		//Default constructor, gets called when we instantiate a Draw JPanel object
	{
		this.setPreferredSize(new Dimension(1200,336));		//We set the dimension of the JPanel, in this case it will be the drawing image size
		this.setBackground(Color.WHITE);					//And we put a default background, this is not necessary as we will be painting over the hole thing anyway.
	}

	public void paintComponent(Graphics g)		//this method gets called whenever the JPanel need repainting, we use the repaint() method to implicitly call it.
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);		//Again this is actually useless.. but whatever.
		g.setColor(Color.BLACK);				//Same here
		g.fillRect(0,0, 1200, 336);				//And here...


		//This is were the magic happens, it checks all the "cells" in the matrix to check its value and according to it, it will paint a black or white rectangle
		for(int row=0;row<56;row++)
		{
			for(int col=0;col<200;col++)
			{
				if(Matrix.getMatrix()[row][col]==1)			//if the value of the cell is 1 then we paint it white
				{
					g.setColor(Color.WHITE);			//We set the colour and what we are going to draw
					g.fillRect(col*6, row*6, 6 ,6);		//it takes the top left corner positions and the length and height of the rectangle
				}
				else if(Matrix.getMatrix()[row][col]==0)		//if the value of the cell is 0 when we paint it black
				{
					g.setColor(Color.BLACK);			//We set the colour and what we are going to draw
					g.fillRect(col*6, row*6,6 ,6);		//it tales the top left corner positions and the length and height of the rectangle
				}
			}
		}
	}
	//More drawing methods. Here we could specify if we want to draw circles rectangles lines eclipses or whatever we want really.
}
