package termproject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.applet.Applet;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
	
	
	 protected static boolean play = false;
	 protected boolean play_2 = false;
	 protected static Timer timer;
	 protected int delay = 4;
	 static int level = 0;
	 protected int paddleposX = 450;
	 protected int  ballposX = 510;
	 protected int ballposY = 350;
	 protected int ballXdir = -1 ;
	 protected int ballYdir = +4 ;
	 
	 
	 int  count = 0;
	 int timecounter= 0;
	 Random rand = new Random();
	 final int a = ThreadLocalRandom.current().nextInt(0,368);
	 final int a1 = ThreadLocalRandom.current().nextInt(20,800);
	 final int b = ThreadLocalRandom.current().nextInt(a +67,435);
	 final int b1 = ThreadLocalRandom.current().nextInt(a1 + 67 ,867);
	 final int c = ThreadLocalRandom.current().nextInt(b +67,502);
	 final int c1 = ThreadLocalRandom.current().nextInt(b1 + 67 ,934);
	 boolean bool1 = true;
	 boolean bool2 = true;
	 boolean bool3 = true;
	 int boolcount = 1;
	 int boolcount2 = 1;
	 int boolcount3 = 1;
	 static int second = 30;
	 
	 protected static int score = 0;
	
	
	
	public GamePlay() {
		
		this.setBackground(Color.cyan);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	
	public void paint(Graphics g) {
		
		//Background
		g.setColor(Color.black);
		g.fillRect(1, 1, 1016, 618);
		
		//Borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 4, 618);
		g.fillRect(0, 0, 1016, 4);
		g.fillRect(1005, 0, 4, 618);
		
		
		//Paddle
		g.setColor(Color.BLUE);
		g.fillRect(paddleposX, 525, 120, 10);
		
		
		//Ball
	
		g.setColor(Color.RED);
		g.fillOval(ballposX, ballposY, 10, 10);
		
		//Images
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\Users\\ocaga\\eclipse-workspace\\termproject2\\src\\termproject2\\meteorite_small.png"));
		} catch (IOException e) {
		}
		
		
		
		
		
		BufferedImage img2 = null;
		try {
		    img2 = ImageIO.read(new File("C:\\Users\\ocaga\\eclipse-workspace\\termproject2\\src\\termproject2\\star_small.png"));
		} catch (IOException e) {
		}
		
		BufferedImage img3 = null;
		try {
		    img3 = ImageIO.read(new File("C:\\Users\\ocaga\\eclipse-workspace\\termproject2\\src\\termproject2\\ufoship_small.png"));
		} catch (IOException e) {
		}
		
		
		

		
		
		
		
		Graphics2D g2d = (Graphics2D)g;
		if(bool1) {
		g2d.drawImage(img,a1,a,img.getWidth(),img.getHeight(),null); // 60 x60 height x width
		}
		if(bool2) {
		g2d.drawImage(img2,b1,b,img2.getWidth(),img2.getHeight(),null);//67x67
		}
		
		if(bool3) {
		g2d.drawImage(img3,c1,c,img3.getWidth(),img3.getHeight(),null);//60x67
		}
		
		
		
		//GameOver
		
		if(ballposY > 600) {
			if(UpPanel.numberoflives <= 0 ) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("serif",Font.BOLD,30));
				g.drawString("Game Over, Score: " + UpPanel.score, 300,300);
						
			}
			
					
		}
		
		
		
		g.dispose();
		g2d.dispose();
		
		
		
		
		

		
	}
	
	
	public static int getScore() {
		return score;
	}


	public static void setScore(int score) {
		GamePlay.score = score;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		
		
		
		
		
		
		if(play) {
			
			
			updateScore();
			
			updateCounters();
			
			
			secondChecker();
			
			
			
			paddleCollision();
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			
			imagesCollision();
			
			boundaryChecker();
			
			
			
			
				
			
			
			
			
			
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			
			}	
		
		
		
		
			repaint();
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(paddleposX >= 880) {
				paddleposX = 884;
			}
			
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(paddleposX <= 4) {
				paddleposX = 4;
			}
			else {
				moveLeft();
				}
			
			
		
		
		
	}

	}
	
	public void moveRight() {
	
		if(play) {
		paddleposX += 30;
		}
		
		
	}
	
	public void moveLeft() {
		if(play) {
		paddleposX -= 30;
		}
		
		
	}
	
	
	
	public static  void setplay(boolean a) {
		play = a;
	} 
	
	public static int getTime() {
		return second;
		
		
	}

	
	public static void updateScore() {
		
		score += 10;
		
		UpPanel.setScore(score);
	}
	
	public void updateCounters() {
		
		if(count== 25) {
			
			ballYdir++;
			count =0;
		}
		else {
			count++;
		
		}
		
		if(timecounter==50) {
			second--;
			timecounter=0;
		}
		else {
		
			timecounter++;
		}
		
	}
	
	
	public void secondChecker() {
		
		if(second < 0) {
			level ++;
			play = false;
			paddleposX = 450;
			ballXdir = -1 -level;
			ballYdir = 4 + level;
			second = 30;
			ballposX =510;
			ballposY = 350;
			bool1 = true;
			bool2 = true;
			bool3 = true;
			boolcount = 1;
			boolcount2 = 1;
			boolcount3 = 1;
			}
		
		}	
	public void paddleCollision() {
		
		if(ballposX >= paddleposX && ballposX <= paddleposX + 120) {
			if(new Rectangle(ballposX,ballposY,10,10).intersects(new Rectangle(paddleposX,525,120,10))) {
		
				ballYdir = -ballYdir;
		
		
			}
		
		}
		
	}
	
	public void imagesCollision() {
		
		
		if(new Rectangle(ballposX,ballposY,10,10).intersects(new Rectangle(a1,a,60,60))) {
			bool1=false;
			if(boolcount ==1) {
				ballYdir *= 2 ;
				ballXdir *= 2;
				boolcount--;
			}
			}
		
		if(new Rectangle(ballposX,ballposY,10,10).intersects(new Rectangle(b1,b,60,67))) {
			
			bool2=false;
			if(boolcount2 ==1) {
			
				score += 10000;
				boolcount2--;}
			
		}
		if(new Rectangle(ballposX,ballposY,10,10).intersects(new Rectangle(c1,c,67,67))) {bool3=false;
			
		
		if(boolcount3 ==1) {
			int[] array = {-1,0,1};
			
		
			UpPanel.numberoflives = UpPanel.numberoflives + array[rand.nextInt(3)];
			boolcount3--;			}
		
		}
	}
	
	
	
	public void boundaryChecker() {
		
		if(ballposY > 600) {
			play = false;
			
			paddleposX = 450;
			if(UpPanel.numberoflives >0) {
				UpPanel.numberoflives--;
				ballposX =510;
				ballposY = 350;
				second = 30;
				ballXdir = -1 -level;
				ballYdir = 4 + level;
			}
		}
		
		
		if(ballposX < 0) {
			ballXdir = - ballXdir;
			}
		if(ballposY <0 ) {
			ballYdir = - ballYdir;
			
			}
		if (ballposX > 994) {
				ballXdir = - ballXdir;
			}
		
		}	
		
		
		
		
	
	
	
	
	}
	
	
	



