package ProPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ballGame extends JPanel implements ActionListener, KeyListener{
	
	
//This is just a serial ID generated by Java. Don't worry about it.
	private static final long serialVersionUID = 1L;
//Setting the timer.
	Timer tik = new Timer(5, this);
	Random random = new Random();
//default sizing for screen
	static int width = 1200;	
	static int height = 680;
	
	int playerOneX = 20;
	int playerOneY = 100;
	int playerOneVX = 0;
	int playerOneVY = 0;	
	int playerOneSize = 50;
	int playerOnePoint = -1;
	
	int playerTwoX = width-70;
	int playerTwoY = 100;
	int playerTwoVX = 0;
	int playerTwoVY = 0;
	int playerTwoSize = 50;
	int playerTwoPoint = 0;
	
	String winningPlayerName = "";
	
	int xspeed = 5;
	
	int ballX = width/2;
	int ballY = height/2;
	int ballVX = 5;
	int ballVY = 5;
	int ballSize = 30;
	String ballInstruction = "press SPACE to Start";
	
	boolean endRound = false;
	
	int titlePosition = 0;
	int titleMove = 0;
	
	int bluePosition = 0;
	int blueMove = 0;
	
	int redPosition = 0;
	int redMove = 0;
	
	String restart = "";
	
	double pauseNum = 0;
	
	String Paused = "";

	
	
//constructor, starting timer
	public ballGame(){
		tik.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	void GoalPoints() {
		if(ballX + ballSize >= width) {
			ballVX = 0;
			ballVY = 0;
			ballX = width/2 - 45;
			ballY = height/2 - 25;
			playerOnePoint++;
			endRound = true;
			ballInstruction = "press SPACE to Start";
			
		}
		if(ballX <= 0) {
			ballVX = 0;
			ballVY = 0;
			ballX = width/2 - 45;
			ballY = height/2 - 25;
			playerTwoPoint++;
			endRound = true;
			ballInstruction = "press SPACE to Start";
		}
	}
	
	void victory() {
		if(playerOnePoint >= 7) {
			ballVX = 0;
			ballVY = 0;
			ballX = width/2 - 45;
			ballY = height/2 - 25;
			
			winningPlayerName = "Player One Wins!!!";
			restart = "Play Again? Press R!";
		}
		if(playerTwoPoint >= 7) {
			ballVX = 0;
			ballVY = 0;
			ballX = width/2 - 45;
			ballY = height/2 - 25;
			
			winningPlayerName = "Player Two Wins!!!";
			restart = "Play Again? Press R!";
			
		}
	}
	
	void startGame() {
		
		if(titlePosition <= 1000) {
			titleMove = 2;
		}
		if(bluePosition >= -1000) {
		blueMove = -2;
		}
		if(redPosition <=1000)
		redMove = 2;
	}
	
	void restartGame() {
		
		playerOneX = 20;
		playerOneY = 100;
		playerOneVX = 0;
		playerOneVY = 0;	
		playerOneSize = 50;
		playerOnePoint = 0;
		
		playerTwoX = width-70;
		playerTwoY = 100;
		playerTwoVX = 0;
		playerTwoVY = 0;
		playerTwoSize = 50;
		playerTwoPoint = 0;
		
		
		xspeed = 5;
		
		ballX = width/2;
		ballY = height/2;
		ballVX = 5;
		ballVY = 5;
		ballSize = 30;
		ballInstruction = "press SPACE to Start";
		
		endRound = false;
		
		titlePosition = 0;
		titleMove = 0;
		
		bluePosition = 0;
		blueMove = 0;
		
		redPosition = 0;
		redMove = 0;
		
	}
	
	void pauseGame() {
		if(ballVY != 0) {
		ballVX = 0;
		ballVY = 0;
		
		Paused = "Game Paused";
		}
	}
	void unpauseGame() {
		
		ballVX = 5;
		ballVY = 5;
		
		Paused = " ";
		
	}
	   
	    
	
// Making Visible Objects
	public void paint(Graphics gg) {
		gg.setColor(Color.white);
		gg.fillRect(0, 0, width, height);
		gg.setColor(Color.black);
		gg.fillRect(20, 20, width-40, height-60);
		/*
		gg.setColor(Color.white);
		gg.fillRect((width/2)-25, 0, 50, height);
		*/
		
		gg.setColor(Color.blue);
		gg.fillRect(playerOneX, playerOneY, playerOneSize, playerOneSize*3);
		gg.setFont(new Font (null, Font.BOLD,20));
		gg.drawString( "Player 1 Points: " + playerOnePoint,100,300);
		
		gg.setColor(Color.red);
		gg.fillRect(playerTwoX, playerTwoY, playerTwoSize, playerTwoSize*3);
		gg.setFont(new Font (null, Font.BOLD,20));
		gg.drawString( "Player 2 Points: " + playerTwoPoint,width - 300,300);
		
		gg.setColor(Color.green);
		gg.fillOval(ballX, ballY, ballSize, ballSize);
		gg.setFont(new Font(null, Font.ROMAN_BASELINE,10));
		gg.drawString(ballInstruction, ballX , ballY - 100);
		
		gg.setColor(Color.yellow);
		gg.setFont(new Font(null, Font.BOLD,70));
		gg.drawString(winningPlayerName, 250,100);
		gg.setFont(new Font(null, Font.BOLD,30));
		gg.drawString(restart, 400,200);
		gg.drawString(Paused, 440,200);
		
		gg.setColor(Color.blue);
		gg.fillRect(0 + bluePosition, 0, 600, height);
		gg.setColor(Color.red);
		gg.fillRect(600 + redPosition, 0, 700, height);
		
		gg.setColor(Color.yellow);
		gg.fillRect(230, 200 + titlePosition, 700,150);
		gg.setColor(Color.black);
		gg.fillRect(250, 220 + titlePosition, 660,110);
		
		gg.setColor(Color.yellow);
		gg.setFont(new Font(null, Font.BOLD,100));
		gg.drawString("Ball Game", 330,300 + titlePosition);
		gg.setFont(new Font(null, Font.ITALIC,50));
		gg.drawString("Press ENTER to play", 330, 500 + titlePosition);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// where everything runs
		repaint();
		 // position is constantly added with the velocity
		
		playerOneX += playerOneVX;
		playerOneY += playerOneVY;
		
		playerTwoX += playerTwoVX;
		playerTwoY += playerTwoVY;
		
		ballX += ballVX;
		ballY += ballVY;
		
		titlePosition += titleMove;
		bluePosition += blueMove;
		redPosition += redMove;
		
		GoalPoints();
		victory();
		
		if(ballY + ballSize >= height) {
			ballVY =-ballVY;
		}
		if(ballY <= 0) {
			ballVY =-ballVY;
		}
		
		if(ballY <= playerOneY + playerOneSize*3 && ballY + ballSize >= playerOneY) {
			if(ballX <= playerOneX + playerOneSize) {
				ballVX = -ballVX;
			}
		}
		if(ballY <= playerTwoY + playerTwoSize*3 && ballY + ballSize >= playerTwoY) {
			if(ballX + ballSize >= playerTwoX) {
				ballVX = -ballVX;
			}
		}
		
		}

	@Override
	public void keyPressed(KeyEvent e) {
		int co = e.getKeyCode();
		
			if(co == KeyEvent.VK_W ) {
				playerOneVY = -xspeed;
			}		

			if(co == KeyEvent.VK_S) {
				playerOneVY = xspeed;
			}
			/*
			if(co == KeyEvent.VK_A ) {
				playerOneVX = -xspeed;
			}		
			if(co == KeyEvent.VK_D ) {
				playerOneVX = xspeed;
			}		
			*/
			
			if(co == KeyEvent.VK_UP ) {
				playerTwoVY = -xspeed;
			}		
			if(co == KeyEvent.VK_DOWN) {
				playerTwoVY = xspeed;
			}	
			if(co == KeyEvent.VK_SPACE) {
				
			}
			/*
			if(co == KeyEvent.VK_LEFT ) {
				playerTwoVX = -xspeed;
			}		
			if(co == KeyEvent.VK_RIGHT ) {
				playerTwoVX = xspeed;
			}
			*/
			if(co == KeyEvent.VK_ENTER) {
				
			}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		int co = e.getKeyCode();	
		if(co == KeyEvent.VK_W ) {
			playerOneVY = 0;
		}		
		
		if(co == KeyEvent.VK_S) {
			playerOneVY = 0;
		}
		/*
		if(co == KeyEvent.VK_A ) {
			playerOneVX = 0;
		}
		if(co == KeyEvent.VK_D ) {
			playerOneVX = 0;
		}		
		*/
		
		if(co == KeyEvent.VK_UP ) {
			playerTwoVY = 0;
		}		
		
		if(co == KeyEvent.VK_DOWN) {
			playerTwoVY = 0;
		}	
		if(endRound == true) {
			if(co == KeyEvent.VK_SPACE) {
				ballVX = 5;
				ballVY = 5;
				endRound = false;
				ballInstruction = " ";
			}
		}
		if(co == KeyEvent.VK_ENTER) {
				startGame();
		}
		if(co == KeyEvent.VK_R) {
				restartGame();
	}
		
		

		if(co == KeyEvent.VK_P) {
			if(pauseNum/2 == (int)(pauseNum/2)) {
			pauseGame();
			pauseNum++;
			}
			else if (pauseNum/2 != (int)(pauseNum/2)) {
			unpauseGame();
			pauseNum++;
			}
		}
		
		/*
		if(co == KeyEvent.VK_LEFT ) {
			playerTwoVX = 0;
		}
		if(co == KeyEvent.VK_RIGHT ) {
			playerTwoVX = 0;
		}
		*/
	}
		
	public static void main(String[]args) {
			JFrame j = new JFrame();	
			ballGame ball = new ballGame();
			j.add(ball);
			j.setTitle("Template for Making Games");
			j.setSize(width, height);
			j.setResizable(false);
			j.setVisible(true);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
