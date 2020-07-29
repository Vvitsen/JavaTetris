/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Victor.Malmygin
 */
public class Tetris extends JFrame{
    
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
               
        glass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {

                int i = ke.getKeyCode();
                    switch (i){
                        case KeyEvent.VK_A: glass.addFigure();
                                                break;
                        case KeyEvent.VK_SPACE: glass.rotateFigure();
                                                break;
                        case KeyEvent.VK_Z: glass.changeFigure();
                                                break;
                        case KeyEvent.VK_X: glass.changeFigure();
                                                break;                        
                        case KeyEvent.VK_LEFT: glass.moveFigure(Direction.LEFT);
                                                break;
                        case KeyEvent.VK_RIGHT: glass.moveFigure(Direction.RIGHT);
                                                break;
                        case KeyEvent.VK_UP: glass.moveFigure(Direction.UP);
                                                break;
                        case KeyEvent.VK_DOWN: glass.moveFigure(Direction.DOWN);
                                                break;                        
                    }   
            }            
        });
        
        glass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                glass.addFigure();
            }
        });
    }
    
    private void processing(){
        

        

    }
        
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        Tetris tetris = new Tetris();
        tetris.InitComponents();
//        tetris.processing();
        
    }
    

    
}


