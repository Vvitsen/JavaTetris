/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Point;
import static java.lang.Math.random;


/**
 *
 * @author Victor.Malmygin
 */
public class Figure {
    
    private Point p = new Point(0,0);

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }
    
    private int x = 0;
    private int y = 0;
    
    private int[][][] Shapes = {
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 0, x + 3}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 1, x + 0},
         {y + 1, x + 1}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 1, x + 0}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 1, x + 1}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 1, x + 1},
         {y + 1, x + 2}}
    };
    
    private int[][] Shape;
    
    private Color color = Color.GRAY;

    public Figure() {
        int index = (int) (random() * 5);
        Shape = Shapes[index];
    }
    
    public Figure(int[][] shape){
        this.Shape = shape;
    }
    
    public Figure(int y, int x, int[][] shape){
        this.y = y;
        this.x = x;
        this.Shape = shape;
    }
    
    public int[][] getAltShape(){
        return Shape;
    }
        
    public void setX (int x){
        this.x = x;
    }
    public void setY (int y){
        this.y = y;
    }

    int getY() {
        return y;
    }
    int getX() {
        return x;
    }
    
    public void setShape(int[][] shape){
        this.Shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
