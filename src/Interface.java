import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface extends JFrame
{
	private Container c = getContentPane();
	
	Interface()
	{
		super("La mediatheque de GG");
		
		JFrame jframe = new JFrame();
		
		jframe.setLayout(new BorderLayout());
		
		setVisible(true);
		setSize(800,700);
		setLocationRelativeTo(null);
		
		/*
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
	}
}
