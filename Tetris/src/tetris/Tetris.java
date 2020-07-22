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
import javax.swing.JFrame;

/**
 *
 * @author Victor.Malmygin
 */
public class Tetris extends JFrame{
//public class Tetris {
    
    private Glass glass;
    private Figure figure;
    private CircularList<Figure> figures = new CircularList<>();
    
       
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
                if (c == 'i') {
                    Figure f = new Figure();
                    if(glass.inBoard(f) && glass.fit(f)){
                        if (figure != null) figure.setColor(Color.GRAY);
                        figure = f;
                        figure.setColor(Color.DARK_GRAY);
                        glass.insert(figure);
                        figures.add(figure);                       
                    }else{
                        f = null;
                    }                    
                }
                if (c == 'c') glass.clearFigure(figure);
                if (c == 'v') glass.stepDownFigure(figure);
                int i = ke.getKeyCode();
//                    switch (i){
//                        case KeyEvent.VK_LEFT: glass.moveFigure(figure, Direction.LEFT);
//                                                break;
//                    }
                    
                if (i == KeyEvent.VK_LEFT) glass.moveFigure(figure, Direction.LEFT);
                if (i == KeyEvent.VK_RIGHT) glass.moveFigure(figure, Direction.RIGHT);
                if (i == KeyEvent.VK_UP) glass.moveFigure(figure, Direction.UP);
                if (i == KeyEvent.VK_DOWN) glass.moveFigure(figure, Direction.DOWN);
                if (i == KeyEvent.VK_SPACE) glass.rotateFigure(figure);
                if (i == KeyEvent.VK_1){
                    figure.setColor(Color.GRAY);
                    figure = figures.get(figures.indexOf(figure) - 1);
                    figure.setColor(Color.DARK_GRAY);
                }
                if (i == KeyEvent.VK_2){
                    figure.setColor(Color.GRAY);
                    figure = figures.get(figures.indexOf(figure) + 1);
                    figure.setColor(Color.DARK_GRAY);
                }   
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


