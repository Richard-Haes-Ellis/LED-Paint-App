package com.richaeell.globe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class ControlPanel extends JPanel{	//objects created with this class will be a custom type of a JPanel 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Buttons
	private JButton genCodeButton;		
	private JButton textEnter;			
	private JButton clearScreenButton;	
	private JButton fillScreenButton;	 
	
	//Text fields
	private JTextField textField;	
	
	//Radio Buttons (Circular)
	private JRadioButton pen;				
	private JRadioButton eraser;			
	private JRadioButton fill;				
	private JRadioButton rectangleButton;	
	private JRadioButton lineButton;		
	private JRadioButton elipseButton;
	
	//Button groups that contain buttons
	private ButtonGroup selectionGroup;
	
	//Spinners 
	private JSpinner penSize;
	private JSpinner textSize;
	
	//Labels
	private JLabel textSizeLabel;
	private JLabel penSizeLabel;
	
	//Variables that contain information from text fields and other compounds
	private static String sourceCode = new String();		//here is were we store the generated source code in text format 
	private static String text;								//here we store what's in the text field
	
	public ControlPanel(){
		
		clearScreenButton = new JButton("Clear All");	//Creates a button object with title
		genCodeButton = new JButton("Generate Code");	
		
		//THIS SETS UP THE TEXT SECTION LAYOUT
		textEnter = new JButton("Enter Text");	
		textField = new JTextField("",10);		//We set the default text and size that will be in the text area
		textSize = new JSpinner(new SpinnerNumberModel(5,5,20,1));
		textSizeLabel = new JLabel("Text Size:");
		JPanel textPanel = new JPanel();
		JPanel textNPanel = new JPanel();
		JPanel textSPanel = new JPanel();
		Border textBorder = BorderFactory.createTitledBorder("Texts");
		textNPanel.add(textField);
		textNPanel.add(textEnter);
		textSPanel.add(textSizeLabel);
		textSPanel.add(textSize);
		textPanel.setLayout(new BorderLayout());
		textPanel.setBorder(textBorder);
		textPanel.add(textNPanel,BorderLayout.NORTH);
		textPanel.add(textSPanel,BorderLayout.SOUTH);
		
		//THIS SETS UP THE TOOL SECTION LAYOUT
		pen =  new JRadioButton("Pen");				//We set the titles for the radio buttons 
		eraser =  new JRadioButton("Eraser");
		fill =  new JRadioButton("filler");
		rectangleButton = new JRadioButton("Rectangle");
		lineButton = new JRadioButton("Lines");
		elipseButton = new JRadioButton("Elipses");
		//penSize = new JSpinner(new SpinnerNumberModel(1,1,56,1));  //(minimum,default,maximum,increments)
		selectionGroup = new ButtonGroup();			//We create a group that will contain the different tools (pen, eraser);
		selectionGroup.add(eraser);			//We add the eraser radio button to the group 
		selectionGroup.add(pen);			//We add the pen radio button to the group 
		selectionGroup.add(rectangleButton);
		selectionGroup.add(elipseButton);
		selectionGroup.add(lineButton);
		JPanel selectPanel = new JPanel();				//we create a mini panel that will contain the group of radio button
		Border selectBorder = BorderFactory.createTitledBorder("Tools"); 		//We create a border with a Title for the group 
		selectPanel.setBorder(selectBorder);		//We add the border with the title to the main panel
		selectPanel.add(pen);						
		selectPanel.add(rectangleButton);	
		selectPanel.add(lineButton);	
		selectPanel.add(elipseButton);	
		selectPanel.add(eraser);	
		selectPanel.add(fill);
		//selectPanel.add(penSize);
		pen.setSelected(true);				//This sets the default selected option for the pen
		
		this.add(selectPanel);
		this.add(textPanel);
		this.add(clearScreenButton);
		this.add(genCodeButton);
		
		
		
		//Handles the action when the GENERATE CODE button is pressed
		genCodeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JTextArea textArea = new JTextArea(35,21);			//Creates a text area to display
				textArea.setEditable(true);		//Sets it editable
				
		//This is the algorithm that turns the column arrays into groups of 7 bytes converted to hexadecimal values and stores it in the JTextArea 
//===================================================================================================================================================================
				int multiplyer=1000,cont=0,num=0;
				int hex=0,j=1,remainder;
			 
			    for(int col=0;col<200;col++){			textArea.append("{0x");
				        for(int row=55;row>=0;row--){	num=num+Matrix.getMatrix()[row][col]*multiplyer;	multiplyer=multiplyer/10;
				            if(multiplyer<=0){
				            	if(cont==2){
				            	textArea.append(",0x");	cont=0;}
				            	multiplyer=1000;
								while(num!=0){			remainder=num%10;hex=hex+remainder*j;j=j*2;				num=num/10;}
								sourceCode=(Integer.toHexString(hex)).toUpperCase();
								textArea.append(sourceCode);
				            	num=0;
				            	cont++;
				            	hex=0;
				            	j=1;
				            }
				        }cont=0;
				        textArea.append("},\n");
			    	}
//===================================================================================================================================================================
				JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	//Creates a scroll panel
				JOptionPane.showMessageDialog(null,scrollPane,"    Code:", JOptionPane.PLAIN_MESSAGE);		//Shows a pop up, null for the default frame and the message to display
				
//				System.out.println("GENERATING CODE");
			}
		});
		
		textEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				text = textField.getText();
				System.out.println(text);
			}
		});
		
		//Handles the action when the CLEAR ALL button is pressed
		clearScreenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.fillMatrixWhith(Matrix.getMatrix(), 0);
				repaint();
//				System.out.println("CLEARS SCREEN");
			}
		});
		
		eraser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.setToolAction(0);
			}
		});	
		
		pen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.setToolAction(1);
			}
		});	
		
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.setToolAction(2);
			}
		});	
		
		lineButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.setToolAction(3);
			}
		});	
		
		elipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Matrix.setToolAction(4);
			}
		});		
	}
}