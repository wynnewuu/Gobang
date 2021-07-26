package tic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UI implements Setting{
private int[][] chessArray = new int[LINE+2][LINE+2]; 
	
	public void showUI() {
	    // JFrame 
		JFrame jf = new JFrame();
		// title 
		jf.setTitle("Tic-Tac-Toe /5*5");
		jf.setSize(800, 700);
		// set exit 
		jf.setDefaultCloseOperation(3);
		// set in the mid
		jf.setLocationRelativeTo(null);
		panel gp = new panel(chessArray);
		// set background color
		gp.setBackground(new Color(139,139,122));
		jf.add(gp,BorderLayout.CENTER);
		//set right side
		JPanel jp=new JPanel();
		jp.setBackground(new Color(245,245,245));
		jf.add(jp,BorderLayout.EAST);
		java.awt.FlowLayout fl=new java.awt.FlowLayout(5,5,60);
		jp.setLayout(fl);
		Dimension di=new Dimension(120,0);
		jp.setPreferredSize(di);
		// set button ( size 
		javax.swing.JButton jbu1=new javax.swing.JButton("Start");
		Dimension di1=new Dimension(100,60);
		jbu1.setPreferredSize(di1);
		jp.add(jbu1);
		javax.swing.JButton jbu2=new javax.swing.JButton("PVP");
		Dimension di2=new Dimension(100,60);
		jbu2.setPreferredSize(di2);
		jp.add(jbu2);
		javax.swing.JButton jbu3=new javax.swing.JButton("PVE");
		Dimension di3=new Dimension(100,60);
		jbu3.setPreferredSize(di3);
		jp.add(jbu3);
		javax.swing.JButton jbu4=new javax.swing.JButton("Return");
		Dimension di4=new Dimension(100,60);
		jbu4.setPreferredSize(di4);
		jp.add(jbu4);
		javax.swing.JButton jbu5=new javax.swing.JButton("RE");
		Dimension di5=new Dimension(100,60);
		jbu5.setPreferredSize(di5);
		jp.add(jbu5);
		jf.setVisible(true);
		// set brush
		Graphics g = gp.getGraphics();
		control mouse = new control(g,chessArray,gp);	
		// button 
		jbu1.addActionListener(mouse);
		jbu2.addActionListener(mouse);
		jbu3.addActionListener(mouse);
		jbu4.addActionListener(mouse);
		jbu5.addActionListener(mouse);
		
	}
	// main 
	public static void main(String[] args) {
		UI ui = new UI();
		ui.showUI();
	}
}
