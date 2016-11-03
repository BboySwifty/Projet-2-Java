import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JFrame
{
	private Container c = getContentPane();
	
	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	ArrayList<DVD> alDVD = new ArrayList<DVD>();
	ArrayList<Livre> alLvres= new ArrayList<Livre>();
	ArrayList<Periodique> alPeriodiques = new ArrayList<Periodique>();
	
	String[] strArray = {"Livre","Periodiques","DVDs","Recherche","Quitter"};
	
	Interface()
	{
		super("La mediatheque de GG");
		
		for(int i =0; i<strArray.length; i++)
		{
			jtab.addTab(strArray[i],null);
		}
		
		add(jtab);
		
		setVisible(true);
		setSize(1000,700);
		setLocationRelativeTo(null);
		
		lireFichier("DVD.txt");
		
		/*//quitter
		jmenuquitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == jmenuquitter)
				{
					System.exit(0);
				}
			}
		});
		*/
		
		jtab.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent e)
					{
						if(e.getSource().equals(jtab.getTitleAt(strArray.length-1)))
						{
							System.exit(0);
						}
					}
				});
		//System.out.println(jtab.getTitleAt(strArray.length-1));
	}
	
	public void lireFichier(String strFichier)
	{
		BufferedReader br = null;
		
		try
		{
			String strLigne;
			
			br = new BufferedReader(new FileReader(strFichier));
		
			/*
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		     while (st.hasMoreTokens()) 
		     {
		         System.out.println(st.nextToken());
		     }
		    */
			
			while((strLigne=br.readLine()) != null)
			{
				if(strFichier.compareTo("Livres.Txt".toLowerCase()) == 0)
				{
					
				}
				
				else if(strFichier.compareTo("DVD.txt".toLowerCase())==0)
				{
					
				}
				
				else if(strFichier.compareTo("Periodiques.txt".toLowerCase())==0)
				{
					
				}
				
				System.out.println(strLigne);
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
