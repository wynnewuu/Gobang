package tic;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class panel extends JPanel implements Setting {
            private int [][] chessArray;
            
            public panel(int [][] chessArray) {
            	this.chessArray = chessArray;
            }
   // paint panel          
   public void paint(Graphics g) {
            	super.paint(g);
            	for(int i = 0;i<LINE;i++) {
            		g.drawLine(X, Y+i*SIZE, (LINE-1)*SIZE+X, Y+i*SIZE);
            		g.drawLine(X+i*SIZE, Y, X+i*SIZE, (LINE-1)*SIZE+Y);
            		
            	}
            	paintChess(g);
            }
   // paint chess /color
   public void paintChess(Graphics g) {
	   	for(int i=0; i <chessArray.length;i++) {
	   		for(int j=0;j<chessArray[i].length;j++) {
	   			if(chessArray[i][j]==1) {
	   				// set color
	   				g.setColor(Color.WHITE);
	   				//filled ellipse (coordinate and width , height
	   				g.fillOval(i*SIZE+X-CHESS/2, j*SIZE+Y-CHESS, 30, 30);
	   			}else if(chessArray[i][j] ==-1) {
	   				g.setColor(Color.BLACK);
	   				g.fillOval(i*SIZE+X-CHESS/2, j*SIZE+Y-CHESS/2, 30, 30);
	   			}
	   		}
	   	}
	   		
   
   }
    
}
