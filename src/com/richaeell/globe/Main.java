
package com.richaeell.globe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Main {

	private MouseHandler mouseListener;
	private Matrix matrix;
	private DrawPanel drawPanel;
	private ControlPanel controlPanel;


	public static void main(String[] args)	//MAIN ==================================================================================
	{
		Main mainWindow = new Main();	//creates a of instance of a JFrame
		EventQueue.invokeLater(new Runnable() {public void run() {mainWindow.setVisible(true);}});  //Something to do with the
																									 //queueing of mouse events
	}

	public Main()		//Default constructor that is called once a object of Globe is instantiated
	{
		initComponents();		//Initialises everything
	}

	public void initComponents()
	{
		this.setTitle("THE GLOBE EDITOR");		//Sets the title of the window
		this.setSize(1220, 600);				//Sets the window size
		this.setVisible(true);					//Sets it so its visible
		this.setLocationRelativeTo(null);		//Sets it centred relative to the screen on start up
		this.setResizable(false);				//No resize
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Closes when you click the x button

		mouseListener = new MouseHandler();
		matrix = new Matrix();
		drawPanel = new DrawPanel();	//Creates a instance of the drawing panel
		controlPanel = new ControlPanel();	//Creates a instance of the button panel

		//We add mouse listeners to determine if the mouse is being clicked or dragged, we can also retrieve the mouse location
		drawPanel.addMouseListener(new MouseAdapter() {public void mousePressed(MouseEvent evt){jPanel2MousePressed(evt);}public void mouseReleased(MouseEvent evt) {jPanel2MouseReleased(evt);}});
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {public void mouseDragged(MouseEvent evt) {jPanel2MouseDragged(evt);}});

		this.add(drawPanel,BorderLayout.CENTER);	//we add the drawing panel to the window in the centre
		this.add(controlPanel,BorderLayout.SOUTH);	//we add the buttons panel to the window in the bottom
		pack();		//This resizes the window to it all fits nice and suck ( I think )

	}

	public MouseHandler getMouseListener() {
		return mouseListener;
	}

	public void setMouseListener(MouseHandler mouseListener) {
		this.mouseListener = mouseListener;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}
}
