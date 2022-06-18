package termproject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class UpPanel extends JPanel implements ActionListener{
	
	protected static int score;
	protected Timer timer2;
	int delay2 = 20;
	protected static int numberoflives = 3;
	
	public UpPanel() {
	
		this.setFocusable(false);
		setFocusTraversalKeysEnabled(true);
		this.setBackground(Color.red);
		timer2 = new Timer(delay2,this);
		timer2.start();
		
		
		
	}

	@Override
	public void paint(Graphics g) {
		
		//background
		
		g.setColor(Color.black);
		g.fillRect(1, 1, 1016, 99);
		
		
		
		//text
		g.setColor(Color.CYAN);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("SCORE :"+ getScore(), 790, 50);
		
		
		
		//level
		
		g.setColor(Color.blue);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("LEVEL:"+ (GamePlay.level + 1) , 590, 50);

		
		
		//countertimer
		
		
		DecimalFormat dFormat = new DecimalFormat("00");
		g.setColor(Color.red);
		
		g.setFont(new Font("serif",Font.BOLD,25));
		if(GamePlay.getTime()>= 0) {
			g.drawString("00:"+ dFormat.format(GamePlay.getTime()), 390, 50);
			
		}
		
		
		
		// hearts
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\Users\\ocaga\\eclipse-workspace\\termproject2\\src\\termproject2\\heart2.png"));
		} catch (IOException e) {
		}
		
		Graphics2D g2d = (Graphics2D)g;
		
		if(numberoflives ==4) {
			g2d.drawImage(img, 10,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			g2d.drawImage(img, 20 + img.getWidth()/ 16,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			g2d.drawImage(img, 30 + img.getWidth()/ 8,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			g2d.drawImage(img, 222,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			
		}
		else if(numberoflives ==3) {
		g2d.drawImage(img, 10,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
		g2d.drawImage(img, 20 + img.getWidth()/ 16,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
		g2d.drawImage(img, 30 + img.getWidth()/ 8,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
		}
		else if(numberoflives == 2) {
			g2d.drawImage(img, 10,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			g2d.drawImage(img, 20 + img.getWidth()/ 16,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			
			
		}
		
		else if(numberoflives == 1) {
			g2d.drawImage(img, 10,10 , img.getWidth()/ 16,(int) img.getHeight()/13,null);
			
			
		}
		else {;}
		
		
		g.dispose();
		g2d.dispose();
	}

	public int getScore() {
		return score;
	}

	public static void setScore(int z) {
		score = z;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer2.start();
		if(GamePlay.play) {
			this.repaint();
		}
		
	}
	

	

	
	
	
	



}
