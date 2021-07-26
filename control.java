package tic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class control extends MouseAdapter implements Setting, ActionListener {
	private JPanel j;
	private Graphics g;
	private int x1, y1;
	//The coordinate of the current chess
	private int xx, yy; 
	// color for chess
	private int count = 0; 
	// save chess
	private AI2 a;
	private int[][] chessArray = new int[LINE + 2][LINE + 2]; 


	public control(Graphics g, int[][] chessArray, JPanel j) {
		this.chessArray = chessArray;
		this.j = j;
		this.g = g;

	}

	//check row 
	public int checkrow(int x, int y) {
		int count1 = 0; // the number of save same color chess in row
		for (int i = x + 1; i < 15; i++) {
			if (chessArray[Math.abs(i)][y] == chessArray[x][y]) {
				count1++;
				System.out.println(count1);
			} else {
				break;
			}
		}
		for (int i = x; i >= 0; i--) {
			if (chessArray[Math.abs(i)][y] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}

		return count1;
	}

// check colum
	public int checkcolumn(int x, int y) {
		int count1 = 0; // the same color chess in column
		for (int i = y + 1; i < 15; i++) {
			if (chessArray[x][Math.abs(i)] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		for (int i = y; i >= 0; i--) {
			if (chessArray[x][Math.abs(i)] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}

		return count1;
	}

// check slash 
	public int checkSlash1(int x, int y) {
		int count1 = 0;
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
				System.out.println(count1);
			} else {
				break;
			}
		}
		for (int i = x + 1, j = y + 1; i < LINE && j < LINE; i++, j++) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		return count1;
		
	}
// check slash 
	public int checkSlash2(int x, int y) {
		int count1 = 0;
		for (int i = x - 1, j = y + 1; i >= 0 && j < LINE; i--, j++) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		for (int i = x + 1, j = y - 1; i < LINE && j >= 0; i++, j--) {
			if (chessArray[i][j] == chessArray[x][y]) {
				count1++;
			} else {
				break;
			}
		}
		return count1;
	}

	// when white win
		public void Wwin() {
			javax.swing.JFrame jf = new javax.swing.JFrame();
			java.awt.FlowLayout fl = new java.awt.FlowLayout();
			jf.setLayout(fl);
			javax.swing.JLabel jlb = new javax.swing.JLabel("White Win");
			jlb.setFont(new java.awt.Font("Dialog", 1, 100));
	        // set size for typeface 
			jf.setSize(500, 200);
			jf.add(jlb);

			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(3);
			jf.setVisible(true);
		}

	// when black win
		public void Bwin() {
			javax.swing.JFrame jf = new javax.swing.JFrame();
			java.awt.FlowLayout fl = new java.awt.FlowLayout();
			jf.setLayout(fl);
			javax.swing.JLabel jlb = new javax.swing.JLabel("Black Win");
			jlb.setFont(new java.awt.Font("Dialog", 1, 100));
			jf.setSize(500, 200);
			jf.add(jlb);

			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(3);
			jf.setVisible(true);
		}
	// check win or lose 
	public void gameWin(int x,int y){
		if(checkSlash1(x, y)>=4||checkSlash2(x,y)>=4||checkcolumn(x,y)>=5||checkrow(x,y)>=5){
			if(chessArray[x][y] == -1){
				Bwin();
			}else if(chessArray[x][y] == 1){
				Wwin();
			}
		}
	}


// calculate intersection
	public void inter() {
	
		if ((x1 - X) % SIZE > SIZE / 2) {
			xx = (x1 - X) / SIZE + 1;
		} else {
			xx = (x1 - X) / SIZE;
		}
		if ((y1 - Y) % SIZE > SIZE / 2) {
			yy = (y1 - Y) / SIZE + 1;
		} else {
			yy = (y1 - Y) / SIZE;
		}

	  // black and white appear alternately
		if (chessArray[xx][yy] == 0) {
			if (count == 1) {
				g.setColor(Color.WHITE);
				chessArray[xx][yy] = 1;
				count--;
			} else {
				g.setColor(Color.BLACK);
				chessArray[xx][yy] = -1;
				count++;
			}
			
			g.fillOval(xx * SIZE + X - CHESS / 2, yy * SIZE + Y - CHESS / 2,30, 30);
			gameWin(xx, yy);
		}
	}
	// calculate intersection
	public void inter2() {
	
		if ((x1 - X) % SIZE > SIZE / 2) {
			xx = (x1 - X) / SIZE + 1;
		} else {
			xx = (x1 - X) / SIZE;
		}
		if ((y1 - Y) % SIZE > SIZE / 2) {
			yy = (y1 - Y) / SIZE + 1;
		} else {
			yy = (y1 - Y) / SIZE;
		}

		if (chessArray[xx][yy] == 0) {
			g.setColor(Color.BLACK);
			chessArray[xx][yy] = -1;
			g.fillOval(xx * SIZE + X - CHESS / 2, yy * SIZE + Y - CHESS / 2,30,30);
		}

	}
// use mouse to put chess
	public void mouseClicked(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if (z == 1) {
			inter();
		}
		if (z == 2) {
			inter2();
			gameWin(xx, yy);
			try {
		    	  Thread.sleep(350);
		       }catch(Exception ef) {
			}
			// allow AI to put chess
			// auto put 
			a.ai();
			gameWin(a.getMAXi(),a.getMAXj());
			
		}

	}

	
	public int z;
// button
	public void actionPerformed(ActionEvent e) {
		System.out.println("str" + e.getActionCommand());
       // game start after clicked button "Start"
		if (e.getActionCommand().equals("Start")) {
			j.addMouseListener(this);
		}
		// change mode 
		// will add "PVE"
		if (e.getActionCommand().equals("PVP")) {
			//set color black
			z = 1;
		}
	   // return one step (if put chess in wrong place
		if (e.getActionCommand().equals("Return")) {
		//	System.out.println("2");
			for (int i = 0; i < LINE; i++) {
				for (int j = 0; j < LINE; j++) {
					chessArray[xx][yy] = 0;
					count = 0;
				}
			}
			j.repaint();

		}
		// AI mode
		if(e.getActionCommand().equals("PVE")){
			// Let AI work
		a= new AI2(g, chessArray, j);
			// set color white
			z=2;
		}
		// reopen a game
		if (e.getActionCommand().equals("RE")) {
			// check systeam working normally
		//	System.out.println("1");
			
			for (int i = 0; i < LINE; i++) {
				for (int j = 0; j < LINE; j++) {
					chessArray[i][j] = 0;
					count = 0;
				}
			}
			j.repaint();
		}

	}
}
