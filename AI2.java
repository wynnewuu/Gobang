package tic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JPanel;



public class AI2 extends MouseAdapter implements Setting {

	private JPanel j;
	private Graphics g;
	private int MAXi = 0, MAXj = 0;
	
	HashMap<String, Integer> fq = new HashMap<String, Integer>();
	// save chess point
	private int[][] chessV = new int[LINE + 2][LINE + 2]; 
	// save weight
	private int[][] chessA = new int[LINE + 2][LINE + 2];  
	


	public AI2(Graphics g, int[][] chessArray, JPanel j) {
		this.g = g;
		this.chessA = chessArray;
		this.j = j; 
       // set weight 
	fq.put("-1", 20); fq.put("-1-1", 100);
	fq.put("1-11", 5); fq.put("-1-1-1", 1800);
	fq.put("-1-1-1-1", 9000); fq.put("-11", 4);
	fq.put("-11-1", 5); fq.put("-1-11", 40);
	fq.put("-1-1-11", 400); fq.put("-1-1-1-11", 20000);
	fq.put("1-1-1-1-1", 20000); fq.put("1", 8);
	fq.put("11", 40); fq.put("111", 200);
	fq.put("1-1-11", 5); fq.put("1111", 3000);
	fq.put("1111-1", 3000); fq.put("1111-1-1", 3000);
	fq.put("1-1", 6); fq.put("11-1", 60);
	fq.put("111-1", 700); fq.put("-111-1", 5);
	}

	public void ai() {
	for (int i = 0; i < LINE; i++) {
		for (int j = 0; j < LINE; j++) {
		if (chessA[i][j] == 0) {
			String code = "";
			int color = 0;
	// to right
		for (int k = i + 1; k < 15; k++) {
			if (chessA[Math.abs(k)][j] == 0) {
					break;
				} else 
				{
				if (color == 0) { // 
				color = chessA[Math.abs(k)][j]; // save color
				code += chessA[Math.abs(k)][j]; // save line
				} else if (chessA[Math.abs(k)][j] == color) {
					code += chessA[Math.abs(k)][j]; //save line
					} else
					{
					code += chessA[Math.abs(k)][j]; //save line
					break;
					}
			}
				if (chessA[i][j] != 0) {
					chessV[i][j] = 0;
				}
	}
		
			Integer value = fq.get(code);
			if (value != null) {
				chessV[i][j] += value;
			}
			if (value != null) {
				chessV[i][j] += value;
			}
	// to left
			code = "";
			color = 0;
		for (int k = i - 1; k >= 0; k--) {
			if (chessA[Math.abs(k)][j] == 0) {
				break;
		    } else
		    {
			if (color == 0) { // 
				color = chessA[Math.abs(k)][j]; 
				code += chessA[Math.abs(k)][j]; 
			} else if (chessA[Math.abs(k)][j] == color) {
				
					code += chessA[Math.abs(k)][j];
			  } else 
					{
				code += chessA[Math.abs(k)][j]; 
						break;
				}
		}

	}
		
			value = fq.get(code);
			if (value != null) {
					chessV[i][j] += value;
			}
			 if (chessA[i][j] != 0) {
				chessV[i][j] = 0;
			}
					
					
					
	// go down
		code = "";
		color = 0;
		for (int k = j - 1; k >= 0; k--) {
			if (chessA[i][Math.abs(k)] == 0) {
			  break;
			} else
			{
			   if (color == 0) {  
					color = chessA[i][Math.abs(k)];  
					code += chessA[i][Math.abs(k)];  
				} else if (chessA[i][Math.abs(k)] == color) {
					
				code += chessA[i][Math.abs(k)]; 
				} else {
				code += chessA[i][Math.abs(k)]; 
					break;
			}
				}

		}
			value = fq.get(code);
				if (value != null) {
					chessV[i][j] += value;
				}
				if (chessA[i][j] != 0) {
					chessV[i][j] = 0;
				}
					
					
					
	// go up
		code = "";
		color = 0;
		for (int k = j + 1; k < LINE; k++) {
			if (chessA[i][Math.abs(k)] == 0) {
					break;
			} else
			{
				if (color == 0) { 
						color = chessA[i][Math.abs(k)]; 
						code += chessA[i][Math.abs(k)];  
				} else if (chessA[i][Math.abs(k)] == color) {
						code += chessA[i][Math.abs(k)]; 
					} else
					{
					code += chessA[i][Math.abs(k)]; 
						break;
					}
	}

}
		
		value = fq.get(code);
		if (value != null) {
			chessV[i][j] += value;
	}
		if (chessA[i][j] != 0) {
			chessV[i][j] = 0;
	}
					
		
		// slash
			code = "";
			color = 0;
			for (int k = i + 1, l = j + 1; k < LINE || l < LINE; k++, l++) {
				if (chessA[Math.abs(k)][Math.abs(l)] == 0) {
					break;
			} else 
			{
				if (color == 0) { // 
					color = chessA[Math.abs(k)][Math.abs(l)]; //
					code += chessA[Math.abs(k)][Math.abs(l)]; // 
				} else if (chessA[Math.abs(k)][Math.abs(l)] == color) {
					code += chessA[Math.abs(k)][Math.abs(l)]; // 
				} else
				{
					code += chessA[Math.abs(k)][Math.abs(l)]; // 
					break;
					}
		}

}
			
		value = fq.get(code);
			if (value != null) {
				chessV[i][j] += value;
		}
			if (chessA[i][j] != 0) {
				chessV[i][j] = 0;
		}
		
			
	// slash
			code = "";
			color = 0;
			for (int k = i + 1, l = j - 1; k < LINE || l >= 0; k++, l--) {
				if (chessA[Math.abs(k)][Math.abs(l)] == 0) {
					break;
			} else {
				if (color == 0) { // 
					color = chessA[Math.abs(k)][Math.abs(l)]; // 
					code += chessA[Math.abs(k)][Math.abs(l)]; // 
			} else if (chessA[Math.abs(k)][Math.abs(l)] == color) {
				code += chessA[Math.abs(k)][Math.abs(l)]; // 
			} else
			{
				code += chessA[Math.abs(k)][Math.abs(l)]; // 
					break;
			}
		}

}
			
			
			value = fq.get(code);
			if (value != null) {
				chessV[i][j] += value;
		}
			if (chessA[i][j] != 0) {
				chessV[i][j] = 0;
		}
			
			
	// slash
			code = "";
			color = 0;
		for (int k = i - 1, l = j - 1; k >= 0 || l >= 0; k--, l--) {
			if (chessA[Math.abs(k)][Math.abs(l)] == 0) {
				break;
		} else 
		{
			if (color == 0) { // 
				color = chessA[Math.abs(k)][Math.abs(l)]; // 
				code += chessA[Math.abs(k)][Math.abs(l)]; // 
		} else if (chessA[Math.abs(k)][Math.abs(l)] == color) {
				code += chessA[Math.abs(k)][Math.abs(l)]; // 
		} else
		{
				code += chessA[Math.abs(k)][Math.abs(l)]; // 
				break;
	}
}
}
					
		value = fq.get(code);
		if (value != null) {
		chessV[i][j] += value;
	}
		if (chessA[i][j] != 0) {
			chessV[i][j] = 0;
	}
					
		
// slash
		code = "";
		color = 0;
	for (int k = i - 1, l = j + 1; k >= 0 || l < LINE; k--, l++) {
		if (chessA[Math.abs(k)][Math.abs(l)] == 0) {
				break;
		} else  
		{
		if (color == 0) { // 
			color = chessA[Math.abs(k)][Math.abs(l)]; // 
			code += chessA[Math.abs(k)][Math.abs(l)]; // 
	} else if (chessA[Math.abs(k)][Math.abs(l)] == color) {
			code += chessA[Math.abs(k)][Math.abs(l)]; // 
		} else
		{
			code += chessA[Math.abs(k)][Math.abs(l)]; // 
				break;
		}
	}

}
		value = fq.get(code);
		if (value != null) {
			chessV[i][j] += value;
	}
		if (chessA[i][j] != 0) {
			chessV[i][j] = 0;
	}
}}}

	
// print map -- value/ weight  map 	
	for (int j = 0; j < LINE; j++) {
			for (int i = 0; i < LINE; i++) {
				System.out.print(chessV[i][j] + "  ");
			}
			System.out.println();
		}
		for (int j = 0; j < LINE; j++) {
			for (int i = 0; i < LINE; i++) {
				System.out.print(chessA[i][j] + "  ");
			}
			System.out.println();
		}
		
		
// check the weight  put chess in the most important place
		int maxv = 0;
		for (int i = 0; i < LINE; i++) {
			for (int j = 0; j < LINE; j++) {
				if (maxv < chessV[i][j]) {
					maxv = chessV[i][j];
					MAXi = i;
					MAXj = j;
				}
			}
		}


		
		
//set  chess  white -- AI
		g.setColor(Color.WHITE);
		// size of chess
		g.fillOval(MAXi * SIZE + X - CHESS / 2, MAXj * SIZE + Y - CHESS / 2,30, 30);
		chessA[MAXi][MAXj] = 1;
		System.out.println("x" + MAXi + "y" + MAXj);
		for (int i = 0; i < LINE; i++) {
			for (int j = 0; j < LINE; j++) {
				chessV[i][j] = 0;
			}
		}
	}
	
	public int getMAXj() {
		return MAXj;
	}
	public int getMAXi() {
		return MAXi;
	}
}