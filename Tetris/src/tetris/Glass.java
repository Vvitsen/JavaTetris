/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Victor.Malmygin
 */
public class Glass extends Canvas{

    private final int SIZE = 25;
    private final int WIDTH = 10;
    private final int HEIGHT = 18;
    private int[][] field = new int[HEIGHT][WIDTH]; 
    
//    Glass(){
//        for (int h = 0; h < s.length; h++) {
//            for (int w = 0; w < s[h].length; w++) {
//                field[h][w] = s[h][w];
//            }
//        }
//    }
    
    @Override
    public void paint(Graphics g){            
        for(int h = 0; h < HEIGHT; h++ ){
            for(int w = 0; w < WIDTH; w++){
                if (field[h][w] != 0) g.setColor(Color.GRAY);
                else g.setColor(Color.WHITE);
                g.fillRect(w*SIZE, h*SIZE, SIZE-1, SIZE-1);
            }
        }
    }

    public Rectangle getRect(){
        
        return new Rectangle (100, 100, WIDTH*(SIZE)+6 , HEIGHT*(SIZE)+29);
    }
    
    public boolean insertFigure(Figure f){
//        int[][] s = f.getShape();
//        for (int h = h0; h < s.length; h++) {
//            for (int w = w0; w < s[h].length; w++) {
//                if (s[h][w] != 0 && field[h][w] != 0) break;
//            }
//        }
//        for (int h = h0; h < s.length; h++) {
//            for (int w = w0; w < s[h].length; w++) {
//                if (s[h][w] == 1) field[h][w] = s[h][w];
//            }
//        }
        
        int[][] as = f.getAltShape();
//        int[] point = f.getPoint();
        int h0 = f.getY();
        int w0 = f.getX();
        for (int[] xy : as){
            if ((h0 + xy[0] > HEIGHT-1) || (w0 + xy[1] > WIDTH-1) ) return false;
        }
        for (int[] xy : as) {          
            if (field[h0 + xy[0]][w0 + xy[1]] != 0) return false;
        }
        for (int[] xy : as) {
            field[h0 + xy[0]][w0 + xy[1]] = 1 ;
        }
        repaint();
        return true;
    }
    
    public void clearFigure(Figure f){
//        int[][] s = f.getShape();
//        for (int h = h0; h < s.length; h++) {
//            for (int w = w0; w < s[h].length; w++) {
//                if (s[h][w] != 1) field[h][w] = 0;
//            }
//        }
        int[][] as = f.getAltShape();
        int h0 = f.getY();
        int w0 = f.getX();
        for (int[] xy : as) {
            field[h0 + xy[0]][w0 + xy[1]] = 0 ;
        }
        repaint();
    }
    
    public void stepDownFigure(Figure f){
//        int[][] s = f.getShape();
//        for (int h = 0; h < s.length; h++) {
//            for (int w = 0; w < s[h].length; w++) {
//                field[h][w] = s[h][w];
//            }
//        }
//        int[] point = f.getPoint();
//        point[0] += 1;
//        f.setPoint(point);
//        repaint();
        if(figureGoesOut(f, 1)) return;
        clearFigure(f);
        f.setY(f.getY()+1);
        insertFigure(f);
    }
    
    public boolean figureGoesOut(Figure f, int ds){
        int[][] as = f.getAltShape();
        int h0 = f.getY();
        int w0 = f.getX();
        for (int[] xy : as){
            if ((h0 + xy[0] + ds > HEIGHT-1) || (w0 + xy[1] > WIDTH-1) ) return true;
        }
        return false;
    }
    
}
