
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Main extends JFrame implements ActionListener,FocusListener
{
	
	
    // the main panel on the screen
    JPanel mainPanel = new JPanel();
    
    // Menu Bar 
	JMenuBar menuBar = new JMenuBar();

    // file menu
    JMenu     fileMenu = new JMenu("File");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
   
	
	// calculate menu
	JMenu     calcMenu = new JMenu("Calculate");
	JMenuItem calcMenuItem = new JMenuItem("Calculate");
	
	//textfields
	JTextField number1Field     = new JTextField("",8);
	JTextField operatorField   = new JTextField("",2);   
	JTextField number2Field = new JTextField("",8);
	JTextField finalNumField = new JTextField("",8);
	
	
    // calculator buttons
    JButton calcButton = new JButton("Calculate");
    JButton exitButton = new JButton("Exit");
    JButton clearButton = new JButton("Clear");
    
    JButton exponentButton = new JButton("^");
    JButton multiplyButton = new JButton("*");
    JButton divideButton = new JButton("/");
    JButton plusButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton modButton = new JButton("Mod");
    
    JButton oneButton = new JButton("1");
    JButton twoButton = new JButton("2");
    JButton threeButton = new JButton("3");
    JButton fourButton = new JButton("4");
    JButton fiveButton = new JButton("5");
    JButton sixButton = new JButton("6");
    JButton sevenButton = new JButton("7");
    JButton eightButton = new JButton("8");
    JButton nineButton = new JButton("9");
    JButton zeroButton = new JButton("0");
    
    JButton negativeButton = new JButton("-");
    JButton periodButton = new JButton(".");
    JButton divideFractionButton = new JButton("/");
            
	//labels	
	JLabel equalLabel   = new JLabel("=");
	 
		
	//buttons for filler
	JLabel fillerLabel1 = new JLabel("           ");
	JLabel fillerLabel2 = new JLabel("           ");
	JLabel fillerLabel3 = new JLabel("           ");
	JLabel fillerLabel4 = new JLabel("           ");
	JLabel fillerLabel5 = new JLabel("           ");
	JLabel fillerLabel6 = new JLabel("           ");
	JLabel fillerLabel7 = new JLabel("           ");
	JLabel fillerLabel8 = new JLabel("           ");
	JLabel fillerLabel9 = new JLabel("           ");
	
    // panels for each BorderLayout position
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel centerPanel = new JPanel();
	
	
	int whichBox = 1;  // indicates which box the digit goes in
	char whichOperator = '+'; // indicates the current operator
	
	
	
	// constructors
	public Main()
	{
		
		super("CALCULATOR");
		setSize(500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// addActionListener methods
		calcMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		calcButton.addActionListener(this);
		exitButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		zeroButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
    fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		sevenButton.addActionListener(this);
    eightButton.addActionListener(this);
		nineButton.addActionListener(this);

		plusButton.addActionListener(this);
		subtractButton.addActionListener(this);
    multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
    exponentButton.addActionListener(this);
		modButton.addActionListener(this);


		periodButton.addActionListener(this);
		divideFractionButton.addActionListener(this);
		negativeButton.addActionListener(this);
		
	   
			
		
		
        // to see who has the focus
        number1Field.addFocusListener(this);
        number2Field.addFocusListener(this);
            
                        
        // we will create layout managers for the panels
        BorderLayout b1 = new BorderLayout();
        mainPanel.setLayout(b1);
        
        GridLayout eastLayout = new GridLayout(5,1);
        eastPanel.setLayout(eastLayout);
        
        GridLayout centerLayout = new GridLayout(5,3);
        centerPanel.setLayout(centerLayout);
        
        GridLayout westLayout = new GridLayout(4,1);
        westPanel.setLayout(westLayout);
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        southPanel.setLayout(fl);
        northPanel.setLayout(fl);
        
        

        // we will add components to the center panel
		centerPanel.add(sevenButton);
		centerPanel.add(eightButton);
		centerPanel.add(nineButton);
		centerPanel.add(fourButton);
		centerPanel.add(fiveButton);
		centerPanel.add(sixButton);
		centerPanel.add(oneButton);
		centerPanel.add(twoButton);
		centerPanel.add(threeButton);
		centerPanel.add(zeroButton);
		centerPanel.add(periodButton);
		centerPanel.add(negativeButton);
		centerPanel.add(divideFractionButton);
		centerPanel.add(fillerLabel8);
		centerPanel.add(fillerLabel9);
		
		eastPanel.add(plusButton);
		eastPanel.add(subtractButton);
		eastPanel.add(multiplyButton);
		eastPanel.add(divideButton);
		eastPanel.add(modButton);
		
		westPanel.add(clearButton);
		westPanel.add(exponentButton);
		westPanel.add(fillerLabel1);
		westPanel.add(fillerLabel2);
        
        // add components to the other panels
		northPanel.add(number1Field);
		northPanel.add(operatorField);
		northPanel.add(number2Field);
		northPanel.add(equalLabel);
		northPanel.add(finalNumField);
		
		
		southPanel.add(calcButton);
		southPanel.add(exitButton);
				
	
				
        // add menu items to the menus
		calcMenu.add(calcMenuItem);
		fileMenu.add(exitMenuItem);

        // add the menus to the bar
		menuBar.add(fileMenu);
        menuBar.add(calcMenu);
        // set the bar to be the menu bar
		setJMenuBar(menuBar);

        
        // add each panel to the mainPanel
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.add(eastPanel,BorderLayout.EAST);
        mainPanel.add(westPanel,BorderLayout.WEST);
		mainPanel.add(centerPanel,BorderLayout.CENTER);

		
                
        // make the mainPanel be the main content area and show it
        setContentPane(mainPanel);
        setVisible(true);

	}

    public static void main(String[] args)
	{
		Main cal = new Main();
	}
	

    
    // focusGained and focusLost methods
    // These methods get called when a button gains or loses the
    // focus.
    // (provided the addFocusListener method has been called.
    // these methods are in the FocusListener interface 
 
    public void focusGained(FocusEvent fe)
    {
		Object source = fe.getSource();
    	if (source == number1Field)
    	  whichBox = 1;
    	else if (source == number2Field)
    	  whichBox = 2;
    }
    
    // this method is in the FocusListener interface 
    public void focusLost(FocusEvent fe)
    {
    	// it must be there
    }
  
  
  
  
    
    
    // this method adds a string to the right of a number field
    public void addDigit(String key)
    {
		if (whichBox == 1) // if whichBox is number1Field
		{
			String s = number1Field.getText();
			if (key.equals("-"))
				number1Field.setText(key+s); // put negative at front
			else
				number1Field.setText(s+key);
		}
		else if (whichBox == 2) // if whichBox is number2Field
		{
			String s = number2Field.getText();
			if (key.equals("-"))
				number2Field.setText(key+s); // put negative at front
			else
				number2Field.setText(s+key);
		}    	
    }
    
 
 
    
    // public void actionPerformed(ActionEvent e)
    // This method gets called when a button is clicked.
    // (provided the addActionListener method has been called.
    // This method receives information about what object
    //     got clicked

    
    public void actionPerformed(ActionEvent e)
	{
		// e.getSource() returns the address of the GUI
		// object that got clicked
		Object source = e.getSource();
		
		if ( (source == exitMenuItem) || (source == exitButton) )
		{
			System.exit(0);			
		}
		
		else if (source == zeroButton)
		{
			addDigit("0");
		}

		else if (source == oneButton)
		{
			addDigit("1");
		}
		
		else if (source == twoButton)
		{
			addDigit("2");
		}
		
		else if (source == threeButton)
		{
			addDigit("3");
		}
    else if (source == fourButton)
		{
			addDigit("4");
		}

		else if (source == fiveButton)
		{
			addDigit("5");
		}
		
		else if (source == sixButton)
		{
			addDigit("6");
		}
		
		else if (source == sevenButton)
		{
			addDigit("7");
		}
    else if (source == eightButton)
		{
			addDigit("8");
		}
		
		else if (source == nineButton)
		{
			addDigit("9");
		}


	
  
  	else if (source == divideFractionButton)
		{
			addDigit("/");
		}

		else if (source == negativeButton)
		{
			addDigit("-");
		}

    else if (source == periodButton)
		{
			addDigit(".");
		}


		else if (source == plusButton)
		{
			operatorField.setText("+");
			whichOperator = '+';
		}
		
		else if (source == subtractButton)
		{
			operatorField.setText("-");
			whichOperator = '-';
		}		
    else if (source == multiplyButton)
		{
			operatorField.setText("*");
			whichOperator = '*';
		}
		
		else if (source == divideButton)
		{
			operatorField.setText("/");
			whichOperator = '/';
		}
    else if (source == exponentButton)
		{
			operatorField.setText("^");
			whichOperator = '^';
		}
		
		else if (source == modButton)
		{
			operatorField.setText("%");
			whichOperator = '%';
		}
		


		else if (source == clearButton)
		{
			number1Field.setText("");
			number2Field.setText("");
			operatorField.setText("");
			finalNumField.setText("");
			whichBox = 1;
		}
		
		else if ( (source == calcMenuItem) || (source == calcButton) )
		{
		  try
		  {
            
            String s1 = number1Field.getText().trim();
            String s2 = number2Field.getText().trim();
            String tempOperator = operatorField.getText().trim();
            
            if ( s1.equals("") || s2.equals("") || tempOperator.equals("") )
            	return;
            	
            whichOperator = tempOperator.charAt(0);
            
            	
           
           	// This if statement if true means that both
           	// input fields contain a fraction.  
           	// Therefore, our answer will also
           	// show as a fraction in reduced form.
           
            if (s1.contains("/") && s2.contains("/"))
            {
            	// display the result as a fraction
            	Fraction f1 = new Fraction(s1);
            	Fraction f2 = new Fraction(s2);
            	Fraction result = null;
            	
            	if (whichOperator == '+')
            	{
            		result = f1.add(f2);
            	}
            	else if (whichOperator == '-')
            	{
            		result = f1.subtract(f2);
            	}
              else if (whichOperator == '*')
            	{
            		result = f1.multiply(f2);
            	}
            	else if (whichOperator == '/')
            	{
            		result = f1.divide(f2);
            	}
            	
            	
            
				
            	
            	
            	finalNumField.setText(result.toString());
            } // end of if (s1.contains("/") && s2.contains("/"))

            
           	
           	// This else section means that the input
           	// fields are not both fractions, so we will
           	// show the result as a decimal number.
           	
            else
            {
            	// display the result as a decimal
            	double x=0; // x will hold the value of the number stored in s1
            	double y=0; // y will hold the value of the number stored in s2
            	double z=0; // z will hold our answer
            	
            	
            	// first, we will get the value of the number stored in s1
            	// and store it in x
            	if (s1.contains("/"))
            	{
            		// build a Fraction object and call getDoubleValue()
            		Fraction f1 = new Fraction(s1);
            		x = f1.getDoubleValue();
            	}
            	else
            	{
            		// this will convert the number stored in the variable s1
            		// into a primitive double
            		x = Double.parseDouble(s1);
            	}
            	


            	// second, we will get the value of the number stored in s2
            	// and store it in y
            	if (s2.contains("/"))
            	{
            		
                Fraction f2 = new Fraction(s1);
            		y = f2.getDoubleValue();
            	}
            	else
            	{
            		// this will convert the number stored in the variable s2
            		// into a primitive double
            		y = Double.parseDouble(s2);
            	}

            	
            	
            	
            	
            	
				if (whichOperator == '+')
				{
			  		z = x + y;
				}
				else if (whichOperator == '-')
				{
			  		z = x - y;
				}
        else if (whichOperator == '*')
				{
			  		z = x * y;
				}
				else if (whichOperator == '/')
				{
			  		z = x / y;
				}
        else if (whichOperator == '%')
				{
			  		z = x % y;
				}
				else if (whichOperator == '^')
				{
			  		z = Math.pow(x,y);
				}
				


			
			
				// String.format(format specifier, one or more replacement values)
				// the % means a replacement value should be inserted into
				// the String at this position
				// the .4 means round to four decimal positions
				// the f means a double value or float value must be used to replace the format specifier
				// the z is the replacement value
		 		String answer = String.format("%.4f",z);
            	
				finalNumField.setText(answer);
            }
            
		  }
		  catch (Exception event)	
		  {
		  	System.out.println("Error in Calculating");
		  }
		  
		} // end of else if ( (source == calcMenuItem) || (source == calcButton) )
	
				
	} // end of actionPerformed method
	
	
	
	
	// class Fraction handles numbers in a fraction form
	// this is an inner class
	

	class Fraction
	{
		int numerator;
		int denominator;
		
		public Fraction(int numerator, int denominator)
		{
			
			this.numerator = numerator;
     			this.denominator = denominator;

			
			reduce();

		


		}
		
		public Fraction(String fraction)
		{
			// parse the input  (Example: "4/8") using Scanner and useDelimeter
			Scanner scan = new Scanner(fraction);
			scan.useDelimiter("/"); 
			
			
			numerator = scan.nextInt();
      denominator = scan.nextInt();
			
			
			reduce();
			

			
		}

		private void reduce()
		{
			// Euclid's algorithm to simply the fraction
			
			int x = numerator;
			int y = denominator;
			int remainder = 1;
			
			while (remainder != 0)
			{
				remainder = x % y;
				x = y;
				y = remainder;
			}
			
			int gcf = x;
			
			numerator = numerator/gcf;
			denominator = denominator/gcf;
			
			
		}
		
		public Fraction add(Fraction other)
		{
			
			// add this Fraction and the other Fraction
			// create a new Fraction object and return it
			int a = numerator;
			int b = denominator;
			int c = other.numerator;
			int d = other.denominator;
			
			
			// a     c     a*d     b*c     a*d + b*c
			// -  +  -  =  ---  +  ---  =  --------- 
			// b     d     b*d     b*d        b*d
			
			int newNum = a*d + b*c;
			
						
			int newDen = b*d; 
			
			
			return new Fraction(newNum,newDen);	
		}

		public Fraction subtract(Fraction other)
		{
			
			// subtract this Fraction and the other Fraction
			// create a new Fraction object and return it
			
			int a = numerator;
			int b = denominator;
			int c = other.numerator;
			int d = other.denominator;
      
      int newNum = a*d - b*c;

      int newDen = b*d;



			return new Fraction(newNum,newDen);  	
		}


				

    public Fraction multiply(Fraction other)
    {
      int a = numerator;
			int b = denominator;
			int c = other.numerator;
			int d = other.denominator;

      int newNum = a*c;
      int newDen = b*d;
      
      
      return new Fraction(newNum,newDen);
    }
    
    
    public Fraction divide(Fraction other)
    {
      int a = numerator;
			int b = denominator;
			int c = other.numerator;
			int d = other.denominator;
      
      int newNum = a*d;
      int newDen = b*c;
      
      // a     c     
			// -  / - 
			// b     d     
      
      return new Fraction(newNum,newDen);
    }


   
		
		
		public double getDoubleValue()
		{
			
			// return the value of numerator/denominator as a double (using a type cast)
			return (double)numerator/denominator; 
		}
		
		public String toString()
		{
			if (denominator == 1)
			{
			
				return ""+numerator;  
       
			}
			
			
			
			// return in fractional form
			// Example:  numerator 5, denominator 7   return 5/7
			// So join together the numerator plus "/" plus denominator
			// Use the + operator
			
			return numerator + "/" + denominator; 
 
		}


	} // end of class Fraction 	
	
	
} // end of public class Main


