/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Victor.Malmygin
 */
public class Tetris extends JFrame{
//public class Tetris {
    
    private Canvas canvas = new Canvas();
    
    public Tetris(){
        
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBounds(100, 100, 250, 450);
        setResizable(false);
        canvas.setBackground(Color.WHITE); // define the background color
        add(BorderLayout.CENTER, canvas);
        setVisible(true);
    }
        
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        new Tetris();
    }
    

    
}
