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
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javafx.scene.canvas.GraphicsContext;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Victor.Malmygin
 */
public class Tetris extends JFrame{
//public class Tetris {
    
    private Glass glass; 
    
       
    public Tetris(){
        
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        glass = new Glass();        

        setBounds(glass.getRect());
        
        add(BorderLayout.CENTER, glass);
        setResizable(false);
       
        
   
        setVisible(true);
    }
    
    private void InitComponents(){
        
        
            
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (c == 'b') glass.setBackground(Color.BLUE);
                if (c == 'w') glass.setBackground(Color.WHITE);
            }
            
        });

 
        
    }
    
    private void processing(){
        
        Figure figure = new Figure();
        glass.insertFigure(figure, 0, 0);
//        glass.moveFigure(figure);

    }
        
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        Tetris tetris = new Tetris();
        tetris.InitComponents();
        tetris.processing();
        
    }
    

    
}
