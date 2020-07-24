/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Victor.Malmygin
 */
public class Glass extends Canvas{

    private final int SIZE = 25;
    private final int WIDTH = 10;
    private final int HEIGHT = 18;
    private final Color[][] field = new Color[HEIGHT][WIDTH];
    
    private Figure currentFigure;
    private CircularList<Figure> figures = new CircularList<>();
    
    Glass(){
        for(int h = 0; h < HEIGHT; h++ ){
            for(int w = 0; w < WIDTH; w++){
                field[h][w] = Color.WHITE;
            }
        }
    }
    
    @Override
    public void paint(Graphics g){            
//        for(int h = 0; h < HEIGHT; h++ ){
//            for(int w = 0; w < WIDTH; w++){
//                g.setColor(field[h][w]);
//                g.fillRect(w*SIZE, h*SIZE, SIZE-1, SIZE-1);
//            }
//        }       
        for (Figure f : figures){
            int[][] as = f.getAltShape();
            for (int[] xy : as) {
                g.setColor(f.getColor());               
                g.fillRect((f.getX()+ xy[1])*SIZE, (f.getY() + xy[0])*SIZE, SIZE-1, SIZE-1);
            }
        }
    }

    public Rectangle getRect(){
        
        return new Rectangle (100, 100, WIDTH*(SIZE)+6 , HEIGHT*(SIZE)+29);
    }
    
    public void addFigure(){
        Figure f = new Figure();
        if(inBoard(f) && fit(f)){
            if(currentFigure != null ) currentFigure.setColor(Color.GRAY);
            currentFigure = f;
            currentFigure.setColor(Color.DARK_GRAY);
            figures.add(currentFigure);
        }else{
            f = null;
        }
        repaint();
    }
    
    public void changeFigure(){
        currentFigure.setColor(Color.GRAY);
        currentFigure = figures.get(figures.indexOf(currentFigure) - 1);
        currentFigure.setColor(Color.DARK_GRAY);
        repaint();
    }
    
    public void insert(Figure f){
        int[][] as = f.getAltShape();
        for (int[] xy : as) {
            field[f.getY() + xy[0]][f.getX()+ xy[1]] = f.getColor() ;
        }
        repaint();
    }
    
    public boolean inBoard(Figure f){
        int[][] as = f.getAltShape();
        for (int[] xy : as){
            if ((f.getY() + xy[0] > HEIGHT-1) || (f.getX() + xy[1] > WIDTH-1) ) return false;
        }
        return true;
    }
    
    public boolean fit(Figure f){
        int[][] as = f.getAltShape();
        for (int[] xy : as) {          
            if (field[f.getY() + xy[0]][f.getX() + xy[1]] != Color.WHITE) return false;
        }
        return true;
    }
    
    public void clearFigure(Figure f){
        int[][] as = f.getAltShape();
        int h0 = f.getY();
        int w0 = f.getX();
        for (int[] xy : as) {
            field[h0 + xy[0]][w0 + xy[1]] = Color.WHITE ;
        }
        repaint();
    }
    
    public void stepDownFigure(Figure f){
        if(figureGoesOut(f, Direction.DOWN) ) return;
        clearFigure(f);
        f.setY(f.getY()+1);
        insert(f);
    }
    
    public void moveFigure(Direction ds){
        moveFigure(currentFigure, ds);
    }
    
    public void moveFigure(Figure f, Direction ds){ 
        clearFigure(f);
        if(!figureGoesOut(f, ds)){
            f.setY(f.getY()+ ds.dy());
            f.setX(f.getX() + ds.dx());
        }
        insert(f);
    }
    
    public boolean figureGoesOut(Figure f, Direction ds){
        int[][] as = f.getAltShape();
        for (int[] xy : as){
            int y = f.getY() + xy[0] + ds.dy();
            int x = f.getX() + xy[1] + ds.dx();
            if ( (y  > HEIGHT-1) ||
                 (y  < 0)        || 
                 (x > WIDTH-1)   ||
                 (x < 0)            ) return true;
            if (field[y][x] != Color.WHITE) return true;
        }
        return false;
    }
    
    public boolean isPossible(Figure f){
        int[][] as = f.getAltShape();
        for (int[] xy : as){
            int y = f.getY() + xy[0];
            int x = f.getX() + xy[1];
            if ( (y  > HEIGHT-1) ||
                 (y  < 0)        || 
                 (x > WIDTH-1)   ||
                 (x < 0)            ) return false;
            if (field[y][x] != Color.WHITE) return false;
        }
        return true;
    }
    
    public void rotateFigure(){
        rotateFigure(currentFigure);
    }
    
    public void rotateFigure(Figure f){
        clearFigure(f);
        if (!figureRotateOut(f)){
            int[][] as = f.getAltShape();
            for (int[] xy : as){
                int tmp = xy[0];
                xy[0] = xy[1];
                xy[1] = -tmp;
            }
        }
        insert(f);      
    }
    
    public boolean figureRotateOut(Figure f){
        int[][] as = f.getAltShape();
        for (int[] xy : as){
            int y = f.getY() + xy[1];
            int x = f.getX() - xy[0];
            if ( (y  > HEIGHT-1) ||
                 (y  < 0)        || 
                 (x > WIDTH-1)   ||
                 (x < 0)            ) return true;
            if (field[y][x] != Color.WHITE) return true;
        }
        return false;
    }
}
