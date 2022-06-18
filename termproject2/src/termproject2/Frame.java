package termproject2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class Frame {

	
	
	public Frame() {
		
		JFrame frame = new JFrame();
		GamePlay  gameplay = new GamePlay();
		BottomPlane bottom = new BottomPlane();
		UpPanel up = new UpPanel();
		
		
		
		

		
		frame.setBounds(0,0,1024,768);
		frame.setResizable(false);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		up.setPreferredSize(new Dimension(1024,100));
		gameplay.setPreferredSize(new Dimension(1024,618));
		bottom.setPreferredSize(new Dimension(1024,50));
		frame.add(up,BorderLayout.NORTH);
		frame.add(gameplay,BorderLayout.CENTER);
		frame.add(bottom,BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
	
	
	

